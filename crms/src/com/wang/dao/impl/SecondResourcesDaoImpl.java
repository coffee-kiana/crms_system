package com.wang.dao.impl;


import java.util.List;

import org.springframework.stereotype.Component;

import com.wang.base.DaoSupportImpl;
import com.wang.dao.SecondResourcesDao;
import com.wang.domain.SecondResources;

@Component
public class SecondResourcesDaoImpl extends DaoSupportImpl<SecondResources> implements SecondResourcesDao {

	@Override
	public Long getRowCounts() {
		return (Long) this.getSession().createQuery("select count(*) from SecondResources").uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecondResources> getSecondResourcesByPage(int page, int pageSize) {
		String hql="from SecondResources";
		return this.getSession().createQuery(hql)//
				.setFirstResult((page-1)*pageSize)//
				.setMaxResults(pageSize)//
				.list();//
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllFileName() {
		String hql="select sr_url from SecondResources";
		return this.getSession().createQuery(hql).list();
	}

	@Override
	public String getFileNameById(int id) {
		String hql="select sr_url from SecondResources where id=?";
		return (String) this.getSession().createQuery(hql)//
					.setParameter(0, id)//
					.uniqueResult();//
	}

}
