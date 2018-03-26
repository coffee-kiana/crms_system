package com.wang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wang.base.BaseAction;
import com.wang.domain.Student;
import com.wang.utils.EncryptUtil;
import com.wang.utils.PageUtil;
import com.wang.utils.UploadFile;

@Controller
@Scope("prototype")
public class StudentAction extends BaseAction<Student>{

	private InputStream excelFile;
	private String newpassword;
	private String repassword;
	private int page=1;
	
	//Excel导入的功能的
	private File uploadStudents;
	private String uploadStudentsContentType;
	private String uploadStudentsFileName;
	//Excel导出功能的
	private String[] selectedRow;
	
	
	//-----------------------------导入导出--------------------------------------------
	//转到批量导入学生界面
	public String batchAddStudentUI(){
			return "batchAddStudentUI";
	}
	//批量导入
	public String batchAddStudent() throws Exception{
		String directory = "/file";
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		File target = UploadFile.Upload(uploadStudents, uploadStudentsFileName,targetDirectory);
		List<Student> sList = new ArrayList<Student>();
		excelFile = new FileInputStream(target);
		Workbook wb = new HSSFWorkbook(excelFile);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rowNum; i++) {
			Student student = new Student();
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for (int j = 0; j < cellNum; j++) {
				Cell cell = row.getCell(j);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String cellValue = null;
				
				switch (j+1) {// 通过列数来判断对应插如的字段
				case 1:
					//姓名
					cellValue=cell.getStringCellValue();
					student.setName(cellValue);
					break;
				case 2://性别
					cellValue=cell.getStringCellValue();
					student.setGender(cellValue);
					break;
				case 3://学号
					
					cellValue=cell.getStringCellValue();
					student.setStuNo(cellValue);
					break;
				case 4:
					cellValue=cell.getStringCellValue();
					student.setNation(cellValue);
					break;
				case 5:
					cellValue=cell.getStringCellValue();
					student.setProfession(cellValue);
					break;
				case 6:
					cellValue=cell.getStringCellValue();
					student.setMobile(cellValue);
					break;
				/*case 7:
					cellValue=cell.getStringCellValue();
					student.setEntranceTime(new SimpleDateFormat("yyyy-MM-dd").parse(cellValue));
					break;*/
				case 7:
					cellValue=cell.getStringCellValue();
					student.setAddress(cellValue);
					break;
					}
				sList.add(student);
			}
		}
		studentService.add(sList);
		return "batchAddStudentSucess";
	}
	//------------------------------简单CRUD-------------------------------
	//导出到Excel在中
	public String export2Excel(){
		excelFile=studentService.ExcelDaoChu(selectedRow);
		return "export2Excelsucess";
	}
	
	//添加学生
	public String studentAdminAdd(){
		//保存信息
		studentService.save(model);
		
		return "studentAdminAdd";
	}
	//跳转到添加学生界面
		public String addStudentUI(){		
			return "addStudentUI";
		}
	//删除
		public String adminDeleteStudent(){
		    
			studentService.delete(model.getId());
			return "adminDeleteStudent";
		}
	//admin保存修改
		public String studentAdminUpdate(){
			//保存信息
			studentService.update(model);
			return "studentAdminUpdate";
		}
	//跳转到修改学生转到界面
		public String adminEditStudentUI(){
			//转杯employee
			Student student=studentService.getStudentById(model.getId());
			ActionContext.getContext().getValueStack().push(student);
			if(null == student){
				return ERROR;
			}
			return "adminEditStudentUI";
		}
		

	//展示所有的学生列表
	public String listStudent(){
		//准备数据全部的员工，即employeeList
		PageUtil<Student> pageUtil=studentService.getStudentByPage(page,8);
		ActionContext.getContext().getValueStack().push(pageUtil);
		return "listStudent";
	}
	
	
	/**
	 * 转到更新密码的页面
	 */
	public String UpdatePasswordUI(){
		return "UpdatePasswordUI";
	}
	/**
	 * 更新密码
	 */
	public String updatePassword(){
		Student student=(Student) ActionContext.getContext().getSession().get("existStudent");
		
		if(null == student){
			return ERROR;
		}
		String password=model.getPassword();
		if(null == password || "".equals(password.trim())){
			this.addFieldError("password", "密码不能为空！");
			return "UpdatePasswordUI";
		}
		password = EncryptUtil.md5Encrypt(password);
		if(!student.getPassword().equals(password)){
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
		studentService.updatePassword(newpassword, student.getId());
		
		
		return "updatePwdSuccess";
	}
	
	/**
	 * 把对学生的修改信息保存到数据库中
	 */
	public String StudentUpdate(){
		//获取原先的员工
		Student student=(Student) ActionContext.getContext().getSession().get("existStudent");
		//设置被修改的数据
		student.setName(model.getName());
		student.setUsername(model.getUsername());
		student.setGender(model.getGender());
		student.setNation(model.getNation());
		student.setProfession(model.getProfession());
		student.setMobile(model.getMobile());
		
		student.setEntranceTime(model.getEntranceTime());
		student.setAddress(model.getAddress());
		
		//保存到数据库中
		studentService.update(student);
		
		return "updateSuccess";
	}
	
	
	/**
	 * 转到修改学生资料界面
	 * @return
	 */
	public String updateStudentInfoUI(){
		
		return "updateStudentInfoUI";
	}
	
	/**
	 * 展示学生个人资料
	 * @return
	 */
	public String studentInfo(){
		//准备数据
		Student existStudent=(Student) ActionContext.getContext().getSession().get("existStudent");
		if(null == existStudent){
			return "error";
		}
		//把数据放入值栈中，前端显示
		return "studentInfo";
	}
	
	
	/**
	 * 学生登录验证
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
	
        //		System.out.println(rememberMe);
		
		//对密码使用md5加密
		String password = EncryptUtil.md5Encrypt(model.getPassword());
		Student student = studentService.login(model.getUsername(), password);
		
		if(null != student){
			ActionContext.getContext().getSession().put("existStudent", student);
			return "studentLoginSuccess";
		}
		
		this.addActionError("用户名或密码错误！");
		return "logout";
	}
	
	/**
	 * 用户退出
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
	    ActionContext.getContext().getSession().remove("existStudent");
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
	public File getUploadStudents() {
		return uploadStudents;
	}
	public void setUploadStudents(File uploadStudents) {
		this.uploadStudents = uploadStudents;
	}
	
	
	public String getUploadStudentsContentType() {
		return uploadStudentsContentType;
	}
	public void setUploadStudentsContentType(String uploadStudentsContentType) {
		this.uploadStudentsContentType = uploadStudentsContentType;
	}
	public String getUploadStudentsFileName() {
		return uploadStudentsFileName;
	}
	public void setUploadStudentsFileName(String uploadStudentsFileName) {
		this.uploadStudentsFileName = uploadStudentsFileName;
	}


	public String[] getSelectedRow() {
		return selectedRow;
	}


	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}
	public InputStream getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}


	
}
