<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
 	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	.container {
    		width: 960px;
    	}
    	
    	.errors{
    		color: red;
    	}
    	body { 
			background-color: #f4fbfd; 
			background-image: url("img/bg.png"); 
			background-repeat: repeat-x; 
			padding-top: 30px; 
		}
		
    </style>
  </head>
  <body>

	<div class="container">
		<h1 class="page-header">用户登录</h1>
		
			
				<legend>登录也是一种美德哦！</legend>	
				

			  	<div class="form-group">
			    	<a href="Tea_login.jsp">老师登陆</a>
			  	</div>
			  
			  	<div class="form-group">
			    	<a href="Stu_login.jsp">学生登陆</a>
			  	</div>
			  
			
    </div> 
  </body>
</html>




