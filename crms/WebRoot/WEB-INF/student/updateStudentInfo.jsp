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
	<title>修改资料</title>
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
				 <form action="student_StudentUpdate.action" method="post">
		     	 <ul>
		      
		        	<li>
		        		姓名：
		        		<input type="text" name="name" value="${existStudent.name}"/>
		        	</li>
		        	<li>
		        		登陆名：
		        		<input type="text" name="username" value="${existStudent.username}"/>
		        	</li>
		        	<li>
		        		性别：
		        		<s:if test='#session.existStudent.gender == "男"'>
		        			<input type="radio" name="gender" value="男" checked="checked"/>男
		        			<input type="radio" name="gender" value="女"/>女
		        		</s:if>
		        		<s:else>
			   				<input type="radio" name="gender" value="男" />男
		        			<input type="radio" name="gender" value="女" checked="checked"/>女
		        		</s:else>
		        	</li>
		        	<li>
		        		民族：
		        		<input type="text" class="input" name="nation" value="${existStudent.nation }"/>
		        	</li>
		        	<li>
		        		专业：
		        		<input type="text" class="input" name="profession" value="${existStudent.profession }"/>
		        	</li>
		        	
		        	<li>
		        		手机号码：
		        		<input type="text" class="input" name="mobile" value="${existStudent.mobile }"/>
		        	</li>
		       
		        	<li>
		        		入学时间：
		        		<input type="date" name="entranceTime" value="${existStudent.entranceTime }" >
		        	</li>
		        	<li>
		        		地址：
		        		<input type="text" class="input" name="address" value="${existStudent.address }"/>
		        	</li>
		        </ul>
		        
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
