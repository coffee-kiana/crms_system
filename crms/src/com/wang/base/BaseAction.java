package com.wang.base;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.service.PrimaryResourcesService;
import com.wang.service.SecondResourcesService;
import com.wang.service.StudentService;
import com.wang.service.TeacherService;


public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	//设置成protected使其子类也可以访问使用
	protected T model;
	public BaseAction(){
		try {
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz=(Class<T>) pt.getActualTypeArguments()[0];
			//通过反射创建model的实体
			model=clazz.newInstance();
	    } catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public T getModel(){
		return model;
	}
	//-----------下面进行service实例的声明------------
	@Autowired
	protected StudentService studentService;
	
	@Autowired
	protected SecondResourcesService secondResourcesService;
	
	@Autowired
	protected PrimaryResourcesService primaryResourcesService;
	
	@Autowired
	protected TeacherService teacherService;
}
