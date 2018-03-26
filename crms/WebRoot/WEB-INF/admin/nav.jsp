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
	<title>管理员首页</title> 
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
<SCRIPT src="top.files/clock.js" type=text/javascript></SCRIPT>
	<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
	</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	  <div class="container">
		<div class="navbar-header">
		  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 			     
              data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </button>
		  <a class="navbar-brand" href="">
             	<img alt="首页" src="img/index.png" height="25"/>
             	首页
             </a>
		</div>
    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav">
           
           <s:if test="#session.existTeacher.authority==1">
                <li><a href="teacher_adminUI.action">管理界面</a></li>
           </s:if>
           
                <li><a href="unit.html" target="_blank">单位简介</a></li>
                <li role="presentation" class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               		 关于我们
                    <span class="caret"></span>
                  </a>
                  <ul class="dropdown-menu"  role="menu">
                    <li><a >东</a></li>
                    <li><a >王东</a></li>
                    <li><a >王东东</a></li>
                    <li class="divider"></li>
                    <li><a >啊哈-点我</a></li>
                  </ul>
                </li>
                <li>
                  <a href="javascript:history.go(-1);">
                  		<img src="top.files/nav_back.gif"  border="0">后退
                  </a></li>
                  <li>
					<a href="javascript:history.go(1);">
						<img src="top.files/nav_forward.gif"  border="0">前进
					</a></li>
					<li>
					<a href="http://localhost:8080/crms/login.jsp" target=_top>
					<img src="top.files/1.gif"  border="0">重新登录
					</a></li>
				<li>
					<a><span id="clock"></span></a>
                </li>
                
                
          </ul>
		  <ul class="nav navbar-nav navbar-right">
	           	<li><a href="teacher_teacherInfo.action">用户：${existTeacher.name } <span class="glyphicon glyphicon-user"></span></a></li>
	           	<li class="divider-vertical"></li>
	           	<li><a href="teacher_logout.action">退出 <span class="glyphicon glyphicon-log-out"></span></a></li>
	      </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <!-- 以上是导航菜单-->
    
    <!--空白处-->
    <div class="custom">
    </div>
<SCRIPT type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</SCRIPT>
</body>
</html>
