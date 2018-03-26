package com.wang.dao;

import java.util.List;

import com.wang.base.DaoSupport;
import com.wang.domain.SecondResources;
import com.wang.domain.Student;

public interface SecondResourcesDao extends DaoSupport<SecondResources> {

	Long getRowCounts();

	List<SecondResources> getSecondResourcesByPage(int page, int pageSize);

	List<String> getAllFileName();

	String getFileNameById(int id);


}
