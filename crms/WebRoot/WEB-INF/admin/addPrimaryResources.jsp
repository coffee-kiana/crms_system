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
	<title>单位</title>
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
          <div class="panel-heading">添加一级单位</div>
          
         <form class="form-horizontal"
						action="primaryResources_primaryResourcesAdd.action" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">一级资源名称：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="pname"
									placeholder="pname">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">保存</button>
							</div>
						</div>

					</form>
		</div>
        </div>
      </div>
      
      
	</div>
	</div>
  
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
