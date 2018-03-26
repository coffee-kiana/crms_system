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
	<title>一级资源管理</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
<SCRIPT LANGUAGE=javascript> 
function p_del() { 
var msg = "您真的确定要删除吗？\n\n请确认！"; 
if (confirm(msg)==true){ 
return true; 
}else{ 
return false; 
} 
} 
</script>
	<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="js/showlist.js" type="text/javascript"></script>
	<style type="text/css">
		.custom{
			height:51px;
		}
	</style>
	</head>
<body>
<div class="container">
		<jsp:include page="nav.jsp"></jsp:include>
		
	<div class="row">
    	<jsp:include page="function.jsp"></jsp:include>
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">一级单位列表</div>
	        
		      <s:if test="#primaryResourcesList == null || #primaryResourcesList.size() == 0">
	            	没有一级资源！
	          </s:if>	
	        
	          <s:else>
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr>
	                   	<th>一级单位id</th> <th>一级单位名称</th><th>操作</th> 
	                </tr>
	            </thead>
	            <tbody>
            		<s:iterator value="#primaryResourcesList">
            			<tr>
	            			<td>${id }</td> 
	            			<td>${pname }</td> 
		  					<td>
		  					    <a href="primaryResources_updatePrimaryResourcesUI.action?id=${id }">修改</a>
		  					    &nbsp;&nbsp;&nbsp;
		  					    <a href="primaryResources_deletePrimaryResources.action?id=${id }" onclick="javascript:return p_del()">删除</a>
		  					</td>
            			</tr>
            		</s:iterator>
	            	
	            </tbody>
	          </table>
	         </s:else>
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div><!-- /.container -->
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
