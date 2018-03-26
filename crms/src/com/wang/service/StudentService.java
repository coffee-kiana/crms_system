package com.wang.service;


import java.io.InputStream;
import java.util.List;

import com.wang.domain.Student;
import com.wang.utils.PageUtil;

public interface StudentService {

	Student login(String username, String password);

	void update(Student employee);

	void updatePassword(String newpassword, Integer id);

	Student query(Integer id);

	PageUtil<Student> getStudentByPage(int page, int i);

	Student getStudentById(Integer id);

	void save(Student model);

	void delete(Integer id);

	Student findById(String id);// 根据主键查找用户


	InputStream ExcelDaoChu(String[] selectedRow);

	void add(List<Student> sList);

}
