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
	<title>修改密码</title>
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
	          	 <div class="panel-heading">${existStudent.name }的资料</div>
				 <form action="student_updatePassword.action" method="post">
		     		密码：<input type="password" name="password"/> 
		     			<s:fielderror fieldName="password"></s:fielderror> <br />
		     		新密码：<input type="password" name="newpassword"/>
		     			<s:fielderror fieldName="newpassword"></s:fielderror>  <br />
		     		确认密码：<input type="password" name="repassword"/> <br />
		        	<input type="submit" value="保存"/>
		        </form>
		        
		     </div>
    	</div>
      
	</div>
    
   </div><!-- /.container -->
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
