package com.wang.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.dao.SecondResourcesDao;
import com.wang.domain.SecondResources;
import com.wang.domain.Student;
import com.wang.service.SecondResourcesService;
import com.wang.utils.PageUtil;

@Service
@Transactional
public class SecondResouresServiceImpl implements SecondResourcesService{

	@Resource
	private SecondResourcesDao secondUnitDao;
	
	public void setSecondUnitDao(SecondResourcesDao secondUnitDao) {
		this.secondUnitDao = secondUnitDao;
	}

	@Override
	public List<SecondResources> findAll() {
		return secondUnitDao.findAll();
	}

	@Override
	public void save(SecondResources secondUnit) {
			secondUnitDao.save(secondUnit);
	}

	@Override
	public SecondResources getSecondUnitById(Integer id) {
		return secondUnitDao.getById(id);
	}

	@Override
	public void update(SecondResources secondUnit) {
		secondUnitDao.update(secondUnit);
	}

	@Override
	public void delete(Integer id) {
		secondUnitDao.delete(id);		
	}

	@Override
	public PageUtil<SecondResources> getSecondResourcesByPage(int page, int pageSize) {
		//新建pageUtil,
		PageUtil<SecondResources> pageUtil=new PageUtil<SecondResources>();
		//设置参数1.
		Long tem=secondUnitDao.getRowCounts();
		int rowCounts=tem.intValue();
		pageUtil.getTotalPage(rowCounts, pageSize);	//计算总页数
		List<SecondResources> employees=secondUnitDao.getSecondResourcesByPage(page,pageSize);
		pageUtil.setDatas(employees);
				
		return pageUtil;
	}

	@Override
	public List<String> getFileNameByIds(String[] selectedRow) {
		List<String> list=new ArrayList<String>();
		if(null== selectedRow || selectedRow.length==0){
			list=secondUnitDao.getAllFileName();
		}else{
			for(int i=0;i<selectedRow.length;i++){
				int id=Integer.parseInt(selectedRow[i].trim());
				String filename=secondUnitDao.getFileNameById(id);
				list.add(filename);
			}
		}
		return list;
	}

}
