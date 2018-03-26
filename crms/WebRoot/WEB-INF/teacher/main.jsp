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
	<title>老师</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="js/showlist.js" type="text/javascript"></script>
	<style type="text/css">
	.headeee{
	width:100%;
	height:51px;
	}
	</style>
	</head>
<body>
<div class="headeee"></div>
	<div class="container">
		<jsp:include page="nav.jsp"></jsp:include>
		
		<div class="row">
    	<jsp:include page="function.jsp"></jsp:include>
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">公告信息</div>
	          <div class="panel-body">
	                  木有公告啦！老师：${session.existTeacher.name }
	          </div>
	        
	        </div> 
    	</div>
	</div>
   </div><!-- /.container -->
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
