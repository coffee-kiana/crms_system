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
	<title>老师管理</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	
	<style type="text/css">
		.custom{
			height:51px;
		}
	</style>
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
	</head>
<body>
<div class="container">
<jsp:include page="nav.jsp"></jsp:include>
		
	<div class="row">
    	<jsp:include page="function.jsp"></jsp:include>
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">老师列表</div>
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	           		 <tr>
	                <td colspan="7" align="center">
	                </td>
          			  </tr>
          			   
	                <tr>
	                   	<th>登录名</th> <th>姓名</th> <th>性别</th> <th>民族</th>
			  			  <th>联系电话</th><th>入职时间</th>
			  			 <th>地址</th> <th>所属部门</th> <th>权限</th><th>操作</th> 
	                </tr>
	            </thead>
	            <tbody>
            		<s:iterator value="datas" var="t">
            			<tr> 
	            			<td>${t.username }</td> 
	            			<td>${t.name }</td> 
	            			<td>${t.gender }</td>
	            			<td>${t.nation }</td>
		  					<td>${t.mobile }</td>
		  					<td>${t.entryTime }</td>
		  					<td>${t.address }</td>
		  					<td>${t.department }</td>
		  					<td>
						<s:if test='#t.authority == 1'>
		        			管理员
		        		</s:if>
		        		<s:else>
			   				老师
		        		</s:else>
							</td>
		  					<td>
			  					<a href="teacher_editTeacherUI.action?id=${t.id }">修改</a>
			  					&nbsp;&nbsp;&nbsp;&nbsp;
			  					<a href="teacher_deleteTeacher.action?id=${t.id }" onclick="javascript:return p_del()">删除</a>
		  					</td>
            			</tr>
            		</s:iterator>
	            </tbody>
	          </table>
	        </div>    
    	</div>  
	</div>
	<div class="panel-footer">
	        <ul class="pager">
	          	 	<li>当前页 ：<s:property value="page"/>&nbsp;&nbsp;</li>
	          	 	<li>总页数：<s:property value="totalPage"/></li>
	          	 	<s:if test="page-1 > 0">
	          	 		<li><a href="teacher_listTeacher.action?page=<s:property value="page-1"/>" >上一页</a></li>
	          	 	</s:if>
					<s:set var="totalPage" value="totalPage"></s:set>
					<s:if test="page+1 <= #totalPage">
				  		<li><a href="teacher_listTeacher.action?page=<s:property value="page+1"/>" >下一页</a></li>
	          	 	</s:if>
			</ul>
	 </div>
	
   </div>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
