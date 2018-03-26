package com.wang.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.dao.StudentDao;
import com.wang.domain.Student;
import com.wang.service.StudentService;
import com.wang.utils.PageUtil;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Resource(name="studentDao")
	private StudentDao studentDao;
	private InputStream excelFile;
	
	@Override
	public Student login(String username, String password) {
		Student student=studentDao.findByUandP(username,password);
		return student;
	
	}
	@Override
	public void update(Student employee) {
		studentDao.update(employee);		
	}
	@Override
	public void updatePassword(String newpassword, Integer id) {
		studentDao.updatePassWord(newpassword,id);
	}

	@Override
	public Student query(Integer id) {
		return studentDao.getById(id);
	}
    ////////////////////admin管理了
	@Override
	public PageUtil<Student> getStudentByPage(int page,int pageSize) {
		//新建pageUtil,
		PageUtil<Student> pageUtil=new PageUtil<Student>();
		//设置参数1.
		Long tem=studentDao.getRowCounts();
		int rowCounts=tem.intValue();
		pageUtil.getTotalPage(rowCounts, pageSize);	//计算总页数
		List<Student> employees=studentDao.getStudentByPage(page,pageSize);
		pageUtil.setDatas(employees);
		
		return pageUtil;
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentDao.getById(id);
	}

	@Override
	public void save(Student model) {
		studentDao.save(model);
	}

	@Override
	public void delete(Integer id) {
		studentDao.delete(id);
	}

	@Override
	public Student findById(String id) {
		int idd=Integer.parseInt(id);
		System.out.println(idd+"-----------haode-------------------------------");
		Student stu=new Student();
		stu=studentDao.findById(idd);
		return stu;
	}

	

	@Override
	public  InputStream ExcelDaoChu(String[] selectedRow) {
		// 第一步，创建一个webbook，对应一个Excel文件
				HSSFWorkbook wb = new HSSFWorkbook();
				// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
				HSSFSheet sheet = wb.createSheet("学生表一");
				// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
				HSSFRow row = sheet.createRow((int) 0);
				// 第四步，创建单元格，并设置值表头 设置表头居中
				HSSFCellStyle style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

				HSSFCell cell = row.createCell(0);
				cell.setCellValue("姓名");
				cell.setCellStyle(style);
				cell = row.createCell(1);
				cell.setCellValue("性别");
				cell.setCellStyle(style);
				cell = row.createCell(2);
				cell.setCellValue("学号");
				cell.setCellStyle(style);
				cell = row.createCell(3);
				cell.setCellValue("民族");
				cell.setCellStyle(style);
				cell = row.createCell(4);
				cell.setCellValue("专业");
				cell.setCellStyle(style);
				cell = row.createCell(5);
				cell.setCellValue("电话");
				cell.setCellStyle(style);
				cell = row.createCell(6);
				cell.setCellValue("入学时间");
				cell.setCellStyle(style);
				cell = row.createCell(7);
				cell.setCellValue("地址");
				cell.setCellStyle(style);
				// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
				List<Student> list = new ArrayList<Student>();
				if(selectedRow.equals(null) || selectedRow.length==0){
					list=this.studentDao.findAll();
				}else{
					for(int i=0;i<selectedRow.length;i++){
						int id=Integer.parseInt(selectedRow[i]);
						Student stu=studentDao.getById(id);
						list.add(stu);
					}
				}
				for (int i = 0; i < list.size(); i++) {
					row = sheet.createRow((int) i + 1);
					Student stu = (Student) list.get(i);
					// 第四步，创建单元格，并设置值
					row.createCell(0).setCellValue(stu.getName());
					row.createCell(1).setCellValue(stu.getGender());
					row.createCell(2).setCellValue(stu.getStuNo());
					row.createCell(3).setCellValue(stu.getNation());
					row.createCell(4).setCellValue(stu.getProfession());
					row.createCell(5).setCellValue(stu.getMobile());
					cell = row.createCell(6);
					cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(stu
							.getEntranceTime()));
					row.createCell(7).setCellValue(stu.getAddress());
				     }
				// 第六步，将文件存到指定位置
				try {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					wb.write(baos);
					excelFile = new ByteArrayInputStream(baos.toByteArray());
					baos.close();
					return excelFile;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
	}
	public InputStream getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	@Override
	public void add(List<Student> sList) {
		studentDao.add(sList);
		
	}
}
