package com.wang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wang.base.DaoSupportImpl;
import com.wang.dao.TeacherDao;
import com.wang.domain.Teacher;

@Component
public class TeacherDaoImpl extends DaoSupportImpl<Teacher> implements TeacherDao {

	@Override
	public Teacher findByUandP(String username, String password) {
		
		return (Teacher)getSession().createQuery(//
				"from Teacher e  where e.username=? and e.password=? ")//
				.setParameter(0, username)//
				.setParameter(1, password)//
				.uniqueResult();
	}

	@Override
	public void updatePassWord(String newpassword, Integer id) {

		getSession().createQuery(//
				"update Teacher e set e.password=?  where e.id=?")//
				.setParameter(0, newpassword)//
				.setParameter(1, id)//
				.executeUpdate();
	}

	@Override
	public Long getRowCounts() {
		return (Long) this.getSession().createQuery("select count(*) from Teacher").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getTeacherByPage(int page, int pageSize) {
		String hql="from Teacher";
		return this.getSession().createQuery(hql)//
				.setFirstResult((page-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();//
	}


	
}
