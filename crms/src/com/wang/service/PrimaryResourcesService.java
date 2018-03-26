package com.wang.service;

import java.util.List;

import com.wang.domain.PrimaryResources;

public interface PrimaryResourcesService {

	List<PrimaryResources> findAll();

	void save(PrimaryResources primaryUnit);

	PrimaryResources getPrimaryUnitById(Integer id);

	void update(PrimaryResources primaryUnit);

	void delete(Integer id);
    
}
