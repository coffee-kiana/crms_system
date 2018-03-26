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
<title>添加学生</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="js/showlist.js" type="text/javascript"></script>
<script type="text/javascript">
function toDown(filename){
         var url = encodeURI("toDown.jsp?filename="+filename);
         window.location.href= url;
       }
</script>
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
					<div class="panel-heading">批量添加学生</div>

						<form action="student_batchAddStudent.action" method="post" enctype="multipart/form-data">
							
							<div class="form-group">
								<label for="exampleInputFile">Excel导入学生</label> 
							<input type="file"  name="uploadStudents" accept=".xls,.xlsx">
								<p class="help-block">选择导入的Excel后缀为.xls</p>
							</div>
							
							<button type="submit" class="btn btn-default">Submit</button>
							<input type="reset" class="btn btn-default"/>
						</form>
					<a href="javascript:void(0)" onclick="toDown('student.xls');">下载excel模板</a>   
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
