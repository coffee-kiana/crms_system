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
    <title>老师登录</title>
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
		<h1 class="page-header">老师登录</h1>
		<form class="form-horizontal" role="form"  action="teacher_login.action" method="post">
			<fieldset> 
				<legend>登录也是一种美德哦！</legend>	
				<div class="errors">
					<s:if test="actionErrors != null && actionErrors.size() != 0">
						<s:property value="actionErrors[0]"/>
					</s:if>
				</div>

			  	<div class="form-group">
			    	<label class="col-sm-5 control-label" for="usermame">用户名</label>
			   		<div class="col-sm-3">
			      		<input type="text" class="form-control" placeholder="username" 
			      			id="usermame" name="username" required autofocus>
			  			<span class="help-block">请输入用户名</span>
			  		</div>
			  	</div>
			  
			  	<div class="form-group">
			    	<label class="col-sm-5 control-label" for="password">密码</label>
			    	<div class="col-sm-3">
			      		<input type="password" class="form-control" 
			      			id="password" placeholder="password" name="password" required>
			    		<span class="help-block">请输入密码</span>
			    	</div>
			  	</div>
			  
			  	<div class="form-group">
			  		<div class="col-sm-offset-5 col-sm-7">
			  			<div class="checkbox">
					 	<label>
					  	  <input type="checkbox" name="rememberMe" value="rememberMe"/>  记住我一辈子
					    </label>
					    </div>
				    </div>
 				</div>

				<input type="submit" class="btn btn-success col-sm-offset-5 col-md-3" value="登录"/> 
			</fieldset>
		</form>
		
    </div> 
  </body>
</html>




