package com.wang.dao;

import java.util.List;

import com.wang.base.DaoSupport;
import com.wang.domain.Student;

public interface StudentDao extends DaoSupport<Student> {

	Student findByUandP(String username, String password);

	void updatePassWord(String newpassword, Integer id);

	Long getRowCounts();

	List<Student> getStudentByPage(int page, int pageSize);

	

	Student findById(int idd);

	void add(List<Student> sList);



}
