package com.wang.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;


import com.wang.base.DaoSupportImpl;
import com.wang.dao.StudentDao;
import com.wang.domain.Student;

@Repository(value="studentDao")
public class StudentDaoImpl extends DaoSupportImpl<Student> implements StudentDao {

	@Override
	public Student findByUandP(String username, String password) {
		
		return (Student)getSession().createQuery(//
				"from Student e  where e.username=? and e.password=? ")//
				.setParameter(0, username)//
				.setParameter(1, password)//
				.uniqueResult();
	}

	@Override
	public void updatePassWord(String newpassword, Integer id) {

		getSession().createQuery(//
				"update Student e set e.password=?  where e.id=?")//
				.setParameter(0, newpassword)//
				.setParameter(1, id)//
				.executeUpdate();
	}

	@Override
	public Long getRowCounts() {
		return (Long) this.getSession().createQuery("select count(*) from Student").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentByPage(int page, int pageSize) {
		String hql="from Student";
		return this.getSession().createQuery(hql)//
				.setFirstResult((page-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();//
	}

	
	@Override
	public Student findById(int idd) {
		return (Student)getSession().createQuery(//
				"from Student e  where e.id? ")//
				.setParameter(0, idd)//
				.uniqueResult();
	}

	@Override
	public void add(List<Student> student) {
		if(student.size() > 0){
			int sNum = student.size();
			for(int i=0;i<sNum;i++){
				this.getSession().saveOrUpdate(student.get(i));
			}
		}
	}

}
