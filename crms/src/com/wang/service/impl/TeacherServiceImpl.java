package com.wang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.dao.TeacherDao;
import com.wang.domain.Teacher;
import com.wang.service.TeacherService;
import com.wang.utils.PageUtil;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public Teacher login(String username, String password) {
		Teacher teacher=teacherDao.findByUandP(username,password);
		return teacher;
	
	}

	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);		
	}

	@Override
	public void updatePassword(String newpassword, Integer id) {

		teacherDao.updatePassWord(newpassword,id);
	}

	@Override
	public Teacher query(Integer id) {
		return teacherDao.getById(id);
	}
   
	
	@Override
	public void save(Teacher model) {
		teacherDao.save(model);
	}

	@Override
	public void delete(Integer id) {
		teacherDao.delete(id);
	}
	
	 //-----------------------------------------
		@Override
		public PageUtil<Teacher> getTeacherByPage(int page,int pageSize) {
			//新建pageUtil,
			PageUtil<Teacher> pageUtil=new PageUtil<Teacher>();
			//设置参数1.
			Long tem=teacherDao.getRowCounts();
			int rowCounts=tem.intValue();
			pageUtil.getTotalPage(rowCounts, pageSize);	//计算总页数
			List<Teacher> teachers=teacherDao.getTeacherByPage(page,pageSize);
			pageUtil.setDatas(teachers);
			
			return pageUtil;
		}
		@Override
		public Teacher getTeacherById(Integer id) {
			return teacherDao.getById(id);
		}

}
