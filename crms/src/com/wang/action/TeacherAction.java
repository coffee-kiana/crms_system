package com.wang.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wang.base.BaseAction;
import com.wang.domain.Teacher;
import com.wang.utils.ConstantUtils;
import com.wang.utils.EncryptUtil;
import com.wang.utils.PageUtil;

@Controller
@Scope("prototype")
public class TeacherAction extends BaseAction<Teacher>{

	private String newpassword;
	private String repassword;
	private int page=1;
	/**
	 * 转到更新密码的页面
	 */
	public String UpdatePasswordUI(){
		return "UpdatePasswordUI";
	}
	//转换到管理界面
	public String adminUI(){
		return "adminUI";
	}
	
	/**
	 * 把对学生的修改信息保存到数据库中
	 */
	public String teacherUpdate(){
		//获取原先的员工
		Teacher teacher=(Teacher) ActionContext.getContext().getSession().get("existTeacher");
		//设置被修改的数据
		teacher.setName(model.getName());
		teacher.setUsername(model.getUsername());
		teacher.setGender(model.getGender());
		teacher.setNation(model.getNation());
		teacher.setMobile(model.getMobile());
		teacher.setEntryTime(model.getEntryTime());
		teacher.setAddress(model.getAddress());
		teacher.setDepartment(model.getDepartment());
		
		//保存到数据库中
		teacherService.update(teacher);
		
		return "updateSuccess";
	}
	
	
	/**
	 * 转到修改学生资料界面
	 * @return
	 */
	public String updateTeacherInfoUI(){
		
		return "updateTeacherInfoUI";
	}
	
	/**
	 * 展示学生个人资料
	 * @return
	 */
	public String teacherInfo(){
		//准备数据
		Teacher existTeacher=(Teacher) ActionContext.getContext().getSession().get("existTeacher");
		if(null == existTeacher){
			return "error";
		}
		//把数据放入值栈中，前端显示
		return "teacherInfo";
	}
	
	
	//-------------------------------------------------------
	public String deleteTeacher(){
		teacherService.delete(model.getId());
		return "deleteTeacher";
	}
	
	public String editTeacher(){
		teacherService.update(model);
		return "editTeacher";
	}
	
	public String editTeacherUI(){
		Teacher teacher=teacherService.getTeacherById(model.getId());
		ActionContext.getContext().getValueStack().push(teacher);
		if(null == teacher){
			return ERROR;
		}
		return "editTeacherUI";
	}
	
	public String teacherAdd(){
		teacherService.save(model);
		return "teacherAdd";
	}
	//添加老师頁面
		public String addTeacherUI(){
			return "addTeacherUI";
		}
	//老师列表
	public String listTeacher(){
		//准备数据全部的员工，即employeeList
		PageUtil<Teacher> pageUtil=teacherService.getTeacherByPage(page,8);
		ActionContext.getContext().getValueStack().push(pageUtil);
		return "listTeacher";
	}
	/**
	 * 更新密码
	 */
	public String updatePassword(){
		Teacher teacher=(Teacher) ActionContext.getContext().getSession().get("existTeacher");
		
		if(null == teacher){
			return ERROR;
		}
		String password=model.getPassword();
		if(null == password || "".equals(password.trim())){
			this.addFieldError("password", "密码不能为空！");
			return "UpdatePasswordUI";
		}
		password = EncryptUtil.md5Encrypt(password);
		if(!teacher.getPassword().equals(password)){
			this.addFieldError("password", "密码不正确！");
			return "UpdatePasswordUI";
		}
		
		if(null == newpassword || "".equals(newpassword.trim())){
			this.addFieldError("newpassword", "新密码不能为空！");
			return "UpdatePasswordUI";
		}
		if(!newpassword.equals(repassword)){
			this.addFieldError("newpassword", "新密码与确认密码不一致！");
			return "UpdatePasswordUI";
		}
		newpassword=EncryptUtil.md5Encrypt(newpassword);
		teacherService.updatePassword(newpassword, teacher.getId());
		
		
		return "updatePwdSuccess";
	}
	/**
	 * 学生登录验证
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		//对密码使用md5加密
		String password = EncryptUtil.md5Encrypt(model.getPassword());
		Teacher teacher = teacherService.login(model.getUsername(), password);
		
		if(null != teacher){
			ActionContext.getContext().getSession().put("existTeacher", teacher);
			Integer authority = teacher.getAuthority();
			
			if(ConstantUtils.ADMIN == authority){	//admin
				return "adminLoginSuccess";
			
			}else if (ConstantUtils.EMPLOYEE == authority){	//普通老师
				return "teacherLoginSuccess";
			}
		}
		
		this.addActionError("用户名或密码错误！");
		return "logout";
	}
	
	/**
	 * 老师退出
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
	    ActionContext.getContext().getSession().remove("existTeacher");
		return "logout";
		
	}
	
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
