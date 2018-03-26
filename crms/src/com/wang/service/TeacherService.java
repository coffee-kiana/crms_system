package com.wang.service;

import com.wang.domain.Teacher;
import com.wang.utils.PageUtil;

public interface TeacherService {

	Teacher login(String username, String password);

	void update(Teacher employee);

	void updatePassword(String newpassword, Integer id);

	Teacher query(Integer id);



	void save(Teacher model);

	void delete(Integer id);
	//---------------------------------
	PageUtil<Teacher> getTeacherByPage(int page, int i);

	Teacher getTeacherById(Integer id);
}
