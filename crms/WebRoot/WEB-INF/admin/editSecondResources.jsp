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
	<title>系统</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
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
	            <p>修改二级单位！${session.existTeacher.name }</p>
	          </div>
	          <div class="form">
	          <form action="secondResources_editSecondResources.action" method="post">
			    <input type="hidden" name="id" value="${id }"/>
			  	资源名称：<s:textfield  name="sname"/> <br/>
			  	资源描述：<s:textfield  name="description"/> <br/>
		  		所属一级资源
			  	<select name="primaryResources.id">
						<s:iterator var="c" value="primaryResourcesList">
							<option value="<s:property value="#c.id"/>" <s:if test="primaryResources.id==#c.id">selected</s:if>><s:property value="#c.pname"/></option>
						</s:iterator>
				</select>
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
