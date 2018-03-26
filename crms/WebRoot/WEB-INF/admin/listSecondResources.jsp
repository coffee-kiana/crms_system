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
	<title>二级资源管理</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	
	<style type="text/css">
		.custom{
			height:51px;
		}
	</style>
	<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="js/showlist.js" type="text/javascript"></script>
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
<style type="text/css">
.ddd{
background-color: #6495ED;
}
.dd{
display:inline;
}
.d{
float: right;
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
	<form action="batchDownload_batchDownloadSecondResources.action">
	     <div class="panel-heading ddd">
	          	<div class="dd">二级资源列表</div>
	            <div class="dd d"><button type="submit" class="btn btn-success">批量下载</button></div>
	      </div>
   <s:if test="datas == null || datas == 0">
        	没有二级资源！
      </s:if>	
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr><th>选择</th>
	                   	<th>二级资源编号</th> <th>资源名称</th><th>资源描述</th><th>所属一级资源</th><th>操作</th> 
	                </tr>
	            </thead>
	            <tbody>
            		<s:iterator value="datas" status="index" var="s">
            			<tr>
<td><input type="checkbox" id="selectedRow" name="selectedRow" value="<s:property value='#s.id'/>"></td>
	            			<td><s:property value="#index.index+1"/>  </td> 
	            			<td>${s.sname }</td> 
	            			<td>${s.description }</td>
	            			<td>${s.primaryResources.pname }</td>
		  					<td>
			  					<a href="secondResources_updateSecondResourcesUI.action?id=${s.id }">修改</a>
			  					&nbsp;&nbsp;
			  					<a href="secondResources_deleteSecondResources.action?id=${s.id }" onclick="javascript:return p_del()">删除</a>
		  						&nbsp;&nbsp;
			  					<a href="secondResources_uploadSecondResources.action?id=${s.id }">下载</a>
		  					</td>
            			</tr>
            		</s:iterator>
	            </tbody>
	          </table>
	    </form>
	        </div> <!-- end of panel -->
    	</div>
	</div>
	
	<div class="panel-footer">
	        <ul class="pager">
	          	 	<li>当前页 ：<s:property value="page"/>&nbsp;&nbsp;</li>
	          	 	<li>总页数：<s:property value="totalPage"/></li>
	          	 	<s:if test="page-1 > 0">
	          	 		<li><a href="secondResources_listSecondResources.action?page=<s:property value="page-1"/>" >上一页</a></li>
	          	 	</s:if>
					<s:set var="totalPage" value="totalPage"></s:set>
					<s:if test="page+1 <= #totalPage">
				  		<li><a href="secondResources_listSecondResources.action?page=<s:property value="page+1"/>" >下一页</a></li>
	          	 	</s:if>
			</ul>
	 </div>
	
   </div><!-- /.container -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
