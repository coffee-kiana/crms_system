<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="col-md-2">
    		<div class="panel panel-primary">
    		  <div class="panel-heading">功能导航</div>	
			    <div class="left-sider">
			      <div class="operate">
			        <ul id="J_navlist">
			          <li>
			            <h4 >一级资源</h4>
			            <div class="list-item none">
			              <p ><a href="primaryResources_listPrimaryResources.action" target="_self">资源列表</a></p>
			              <p ><a href="primaryResources_addPrimaryResourcesUI.action" target="_self">添加资源</a></p>
			            </div>
			          </li>
			          <li >
			            <h4 >二级资源</h4>
			            <div class="list-item none">
			              <p ><a href="secondResources_listSecondResources.action" target="_self">资源列表</a></p>
			              <p ><a href="secondResources_addSecondResourcesUI.action" target="_self">添加资源</a></p>
			            </div>
			          </li>
			          
			          <li >
			            <h4>个人管理</h4>
			            <div class="list-item none">
			              <p ><a href="teacher_teacherInfo.action" target="_self">个人信息</a></p>
			              <p ><a href="teacher_UpdatePasswordUI.action" target="_self">修改密码</a></p>
			            </div>
			          </li>
			        </ul>
			        <script type="text/javascript">
						navList(1);
					</script>
			      </div>
			    </div>
			</div>
      	</div>

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>