package com.wang.domain;

public class SecondResources {

	private Integer id;
	private String sname;//二级资源名称
	private String description;//二级资源描述
	private String sr_url;//二级资源的路径
	//二级资源跟一级资源是多对一关系
	private PrimaryResources primaryResources;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSr_url() {
		return sr_url;
	}
	public void setSr_url(String sr_url) {
		this.sr_url = sr_url;
	}
	public PrimaryResources getPrimaryResources() {
		return primaryResources;
	}
	public void setPrimaryResources(PrimaryResources primaryResources) {
		this.primaryResources = primaryResources;
	}
	
	
}
