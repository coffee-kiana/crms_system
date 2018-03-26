package com.wang.domain;

import java.util.HashSet;
import java.util.Set;

public class PrimaryResources {

	private Integer id;
	private String pname;//一级资源名称
	//一级资源对二级资源是一对多关系
	private Set<SecondResources> secondResources=new HashSet<SecondResources>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Set<SecondResources> getSecondResources() {
		return secondResources;
	}
	public void setSecondResources(Set<SecondResources> secondResources) {
		this.secondResources = secondResources;
	}
	
	
}
