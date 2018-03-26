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
	<title>二级资源</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	.headeee{
	width:100%;
	height:51px;
	}
	</style>
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="js/showlist.js" type="text/javascript"></script>
	</head>
<body>
<div class="headeee"></div>
<div class="container">
	<jsp:include page="nav.jsp"></jsp:include>
	
<div class="row">
   	<jsp:include page="function.jsp"></jsp:include>
    	
      <div class="col-md-10">
        <div class="panel panel-primary">
          <div class="panel-heading">添加二级资源</div>
          <div class="form">
	    	<form action="secondResources_secondResourcesAdd.action" method="post" enctype="multipart/form-data">
				  <div class="form-group">
				    <label >资源名称：</label>
				    <input type="text" class="form-control" name="sname" placeholder="name">
				  </div>
				  <div class="form-group">
				    <label >资源描述：</label>
				    <textarea class="form-control" rows="3" name="description" placeholder="description"></textarea>
				  </div>
				  <div class="form-group">
				    <label >上传文件</label>
				    <input type="file" name="upload">
				    <p class="help-block">上传文件不宜过大</p>
				  </div>
				   <div class="form-group">
				    <label >所属一级资源</label>
				   <select class="form-control" name="primaryResources.id">
					  <s:iterator var="c" value="primaryResourcesList">
								<option value="<s:property value="#c.id"/>"><s:property value="#c.pname"/></option>
					  </s:iterator>
					</select>
				  </div>
				  <button type="submit" class="btn btn-default">保存</button>
				  <button type="reset" class="btn btn-default">重置</button>
				</form>
		</div>
        </div>
      </div>
      
      
	</div>
	</div>
  
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
