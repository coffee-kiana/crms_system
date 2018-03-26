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
			            <h4 >老师管理</h4>
			            <div class="list-item none">
			              <p ><a href="teacher_listTeacher.action" target="_self">老师列表</a></p>
			              <p ><a href="teacher_addTeacherUI.action" target="_self">添加老师</a></p>
			            </div>
			          </li>
			          <li >
			            <h4 >学生管理</h4>
			            <div class="list-item none">
			              <p ><a href="student_listStudent.action" target="_self">学生列表</a></p>
			              <p ><a href="student_addStudentUI.action" target="_self">添加学生</a></p>
			                <p ><a href="student_batchAddStudentUI.action" target="_self">Excel导入</a></p>
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
