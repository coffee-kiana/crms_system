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
	<title>展示资料</title>
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
	          <div class="panel-heading">${existTeacher.name }的资料</div>
		     	 <ul>
		     	    <li>登录名：${existTeacher.username }</li>
		        	<li>姓名：${existTeacher.name }</li>
		        	<li>性别：${existTeacher.gender }</li>
		        	<li>民族：${existTeacher.nation }</li>
		        	<li>所属部门：${existTeacher.department }</li>
		        	<li>手机号码：${existTeacher.mobile }</li>
		        	<li>入职时间：${existTeacher.entryTime }</li>
		        	<li>家庭住址：${existTeacher.address }</li>
		        </ul>	
		        
		        <a href="teacher_updateTeacherInfoUI.action">修改基本资料</a>	
		     </div>
    	</div>
      
	</div>
    
   </div><!-- /.container -->

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
