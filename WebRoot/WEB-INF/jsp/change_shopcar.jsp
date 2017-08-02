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
  <s:debug></s:debug>
  <s:form action="product_changeProductInfo" enctype="multipart/form-data"  method="post">
    <s:hidden name="pid" value="%{#request.product.pid}"></s:hidden>
    <s:textfield label="商品名" name="pname" value="%{#request.product.pname}"></s:textfield>
    <s:textfield label="商品价格" name="price" value="%{#request.product.price}"></s:textfield>
    <s:file lable="商品图片" name="img"></s:file>
      <s:hidden name="imgAddress" value="%{#request.product.imgAddress}"></s:hidden>
    <s:submit value="修改商品"></s:submit>
  </s:form>
  
  
   
  </body>
</html>
