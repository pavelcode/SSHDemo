package com.cblue.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;


import com.cblue.entity.Product;
import com.cblue.service.ProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	
	private Product product = new Product();
	ProductService productService;
	
	private File img;  //上传文件
	private String imgFileName; //上传文件的文件名
	private String imgContentType; //上传文件的文件类型
	
	private InputStream downloadFile;//下載文件的输入流	
	private String fileName; //下载的文件名
			

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public InputStream getDownloadFile() {
	     	return downloadFile;
		}

		public void setDownloadFile(InputStream downloadFile) {
			this.downloadFile = downloadFile;
		}
	
	

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String addProduct(){
		System.out.println("ProductAction--ProductAction");
		
		System.out.println("------上传文件开始-------");
		System.out.println(img.toString()+"--"+this.getImgFileName()+"---"+this.getImgContentType());
		//获得上传目录
		String saveDic = ServletActionContext.getServletContext().getRealPath("/images/");
		System.out.println("saveDic="+saveDic);
		try {
			if (saveDic != null) {
				   File filetemp = new File(saveDic);
				   if (filetemp.exists()) {
				    //建立文件夹
				         filetemp.mkdirs();
				   }
				 //上传文件
				FileUtils.copyFile(img, new File(saveDic, imgFileName));
			}
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		
		System.out.println("------上传文件上传完成-------");
		//编码文件路径
//		try {
//			imgFileName = URLEncoder.encode(imgFileName, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		product.setImgAddress("images/"+imgFileName);
		productService.saveProduct(product);
		return "allproduct";
	}
	
	public String allProduct(){
		System.out.println("ProductAction--allProduct");
		List<Product> products = productService.showAllProduct();
		ActionContext.getContext().put("products", products);
		return SUCCESS;
	}
	
	public String changeProductUI(){
		System.out.println("ProductAction--changeProductUI");
		System.out.println(product.getPid());
		int id = product.getPid();
		Product product = productService.getAProduct(id);
		System.out.println("ProductAction--changeProductUI---"+product);
		ServletActionContext.getRequest().setAttribute("product", product);
		return "change_shopcar";
	}
	
	
	public String changeProductInfo(){
		System.out.println("ProductAction--changeProductInfo");
		System.out.println("before product="+product);
		//如果提交的新数据没有图片地址，就使用原来的图片地址
		System.out.println("1="+product.getImgAddress());
		System.out.println("2="+productService.getAProduct(product.getPid()).getImgAddress());
		System.out.println("3="+(product.getImgAddress()==productService.getAProduct(product.getPid()).getImgAddress()));
		if(img!=null){
			System.out.println("------上传文件开始-------");
			System.out.println(img.toString()+"--"+this.getImgFileName()+"---"+this.getImgContentType());
			//获得上传目录
			String saveDic = ServletActionContext.getServletContext().getRealPath("/images/");
			System.out.println("saveDic="+saveDic);
			try {
				if (saveDic != null) {
					   File filetemp = new File(saveDic);
					   if (filetemp.exists()) {
					    //建立文件夹
					         filetemp.mkdirs();
					   }
					 //上传文件
					FileUtils.copyFile(img, new File(saveDic, imgFileName));
				}
			} catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			
			System.out.println("------上传文件上传完成-------");
			product.setImgAddress("images/"+imgFileName);
		}
		System.out.println("after product="+product);
		productService.changeProductInfo(product);
		return "allproduct";
	}
	
	public String removeProduct(){
		System.out.println("ProductAction--removeProduct");
		productService.removeProduct(product);
		return "allproduct";
	}

	public String downloadProductImg(){
		
		    Product productInfo = productService.getAProduct(product.getPid());
		    String realPath = ServletActionContext.getServletContext().getRealPath(productInfo.getImgAddress());
			System.out.println("realpath="+realPath);
			try {
				downloadFile = new FileInputStream(realPath);
				//获得文件名，会自动替换配置文件中的
				fileName = FilenameUtils.getName(realPath);
				//支持中文文件的下载
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return "download";
			
	}
	
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

}
