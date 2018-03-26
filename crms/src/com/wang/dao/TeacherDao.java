package com.wang.dao;

import java.util.List;

import com.wang.base.DaoSupport;
import com.wang.domain.Teacher;

public interface TeacherDao extends DaoSupport<Teacher> {

	Teacher findByUandP(String username, String password);

	void updatePassWord(String newpassword, Integer id);
   //-------------------------
	Long getRowCounts();

	List<Teacher> getTeacherByPage(int page, int pageSize);

}
