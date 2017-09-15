<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopcar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <s:form action="product_addProduct" enctype="multipart/form-data"  method="post">
    <s:textfield label="商品名" name="pname" value=""></s:textfield>
    <s:textfield label="商品价格" name="price" value=""></s:textfield>
    <s:file lable="商品图片" name="img"></s:file>
    <s:submit value="添加商品"></s:submit>
  </s:form>
  
  
  <table border="1" align="center" width="50%">
    <tr align="center">
      <td>商品id</td>
      <td>商品名</td>
      <td>商品价格</td>
      <td>商品图片</td>
      <td colspan="3" >操作</td>
    </tr>
    <s:iterator value="#products" var="product">
      <tr align="center">
      <td><s:property value="pid"/></td>
      <td><s:property value="pname"/></td>
      <td><s:property value="price"/></td>
      <td><img width="50px" width="50px"  src='<s:property value="imgAddress"/>'></td>
      <td><a href="product_changeProductUI?pid=<s:property value='pid'/>">修改</a></td>
      <td><a href="product_removeProduct?pid=<s:property value='pid'/>">删除</a></td>
      <td><a href="product_downloadProductImg?pid=<s:property value='pid'/>">下载图片</a></td>
    </tr>
   </s:iterator>
  </table>
   <center>
    
        <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPages"/></font>页 </font>&nbsp;&nbsp;
        <font size="5">共<font color="red"><s:property value="#request.pageBean.allRecordCount"/></font>条记录</font><br><br>
         <font size="5">共<font color="red">当前是<s:property value="#request.pageBean.currentPage+1"/></font>页</font><br><br>
        <s:if test="#request.pageBean.currentPage == 0">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        
        <s:else>
            <a href="product_getPageProduct">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="product_getPageProduct?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage +1!= #request.pageBean.totalPages">
            <a href="product_getPageProduct?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="product_getPageProduct?page=<s:property value="#request.pageBean.totalPages-1"/>">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center><br>
   
  </body>
</html>
