package com.wang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.dao.PrimaryResourcesDao;
import com.wang.domain.PrimaryResources;
import com.wang.service.PrimaryResourcesService;

@Service
@Transactional
public class PrimaryResourcesServiceImpl implements PrimaryResourcesService{

	@Resource
	private PrimaryResourcesDao primaryUnitDao;
	
	public void setPrimaryUnitDao(PrimaryResourcesDao primaryUnitDao) {
		this.primaryUnitDao = primaryUnitDao;
	}

	@Override
	public List<PrimaryResources> findAll() {
		return primaryUnitDao.findAll();
	}

	@Override
	public void save(PrimaryResources primaryUnit) {
		primaryUnitDao.save(primaryUnit);
	}

	@Override
	public PrimaryResources getPrimaryUnitById(Integer id) {
		return primaryUnitDao.getById(id);
	}

	@Override
	public void update(PrimaryResources primaryUnit) {
		primaryUnitDao.update(primaryUnit);
	}

	@Override
	public void delete(Integer id) {
		primaryUnitDao.delete(id);
	}

}
