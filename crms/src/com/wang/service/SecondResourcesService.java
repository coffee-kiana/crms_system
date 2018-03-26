package com.wang.service;

import java.util.List;

import com.wang.domain.SecondResources;
import com.wang.utils.PageUtil;

public interface SecondResourcesService {

	List<SecondResources> findAll();

	void save(SecondResources secondUnit);

	SecondResources getSecondUnitById(Integer id);

	void update(SecondResources secondUnit);

	void delete(Integer id);

	PageUtil<SecondResources> getSecondResourcesByPage(int page, int i);

	List<String> getFileNameByIds(String[] selectedRow);

}
