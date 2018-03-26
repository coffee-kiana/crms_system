<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="zh-CN">
	<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>修改一级资源</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	
	<style type="text/css">
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			margin-top: 450px;
		}
	
	</style>
	
	<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="js/showlist.js" type="text/javascript"></script>
	</head>

<body>
	<div class="container">
		<jsp:include page="nav.jsp"></jsp:include>
		
		<div class="row">
    	<jsp:include page="function.jsp"></jsp:include>
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">修改信息</div>
	          <div class="panel-body">
	            <p>修改一级资源！${session.existTeacher.name }</p>
	          </div>
	          <div class="form">
	          <form action="primaryResources_editPrimaryResources.action" method="post">
			    <input type="hidden" name="id" value="${id }"/>
			  	单位名称：<s:textfield  name="pname"/> <br/>
			    <input type="submit" id="add" value="更新"/>	
	    	</form>
	        </div> 
    	</div>
	</div>
   </div>
   </div><!-- /.container -->
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
