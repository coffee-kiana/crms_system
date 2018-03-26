<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>添加老师</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="js/showlist.js" type="text/javascript"></script>
<style type="text/css">
.headeee {
	width: 100%;
	height: 51px;
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
		<div class="panel-heading">添加老师</div>

			<form class="form-horizontal"
						action="teacher_teacherAdd.action" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">姓名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name"
									placeholder="name">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">登录名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="username"
									placeholder="username">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">所属部门：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="department"
									placeholder="department">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">性别：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="gender"
									placeholder="gender">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">民族：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="nation"
									placeholder="nation">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">入职时间：
							</label>
							<div class="col-sm-10">
								<input type="date" class="form-control" name="entryTime"
									placeholder="entryTime">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">家庭地址：
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="address"
									placeholder="address">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">联系电话：
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="mobile"
									placeholder="mobile">
							</div>
						</div>
						<div class="form-group">
						  <label for="inputEmail3" class="col-sm-2 control-label">权限：
						  </label>
						  <div class="col-sm-10">
							<label class="radio-inline">
							  <input type="radio" name="authority" id="inlineRadio1" value="1"> 管理员
							</label>
							<label class="radio-inline">
							  <input type="radio" name="authority" id="inlineRadio2" value="2"> 老师
							</label>
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
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
