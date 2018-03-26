package com.wang.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.wang.base.BaseAction;
import com.wang.domain.PrimaryResources;

@Controller
@Scope("prototype")
public class PrimaryResourcesAction extends BaseAction<PrimaryResources>{

	//转到addPrimaryUnitUI页面
	public String addPrimaryResourcesUI(){
		return "addPrimaryResourcesUI";
	}
	//保存一级单位
	public String primaryResourcesAdd(){
		//从前端获取pname
		PrimaryResources primaryResources=new PrimaryResources();
		primaryResources.setPname(model.getPname());
		//保存到数据库中
		primaryResourcesService.save(primaryResources);
		return "primaryResourcesAdd";
	}
	
	//保存修改一级单位的信息
	public String editPrimaryResources(){
		// 1，从数据库取出原对象
		PrimaryResources primaryResources=primaryResourcesService.getPrimaryUnitById(model.getId());
		// 2，设置要修改的属性
		primaryResources.setPname(model.getPname());
		// 3，更新到数据库中
		primaryResourcesService.update(primaryResources);
		return "editPrimaryResources";
	}
	//转到修改一级单位的界面
		public String updatePrimaryResourcesUI(){
			//准备回显的一级单位信息
			PrimaryResources primaryUnit=primaryResourcesService.getPrimaryUnitById(model.getId());
			ActionContext.getContext().getValueStack().push(primaryUnit);
			return "updatePrimaryResourcesUI";
		}
		//删除一级单位
		public String deletePrimaryResources(){
			// 3，更新到数据库中
			primaryResourcesService.delete(model.getId());
			
			return "deletePrimaryResources";
		}
	
	public String listPrimaryResources(){
		//准备数据
		List<PrimaryResources> primaryResourcesList=primaryResourcesService.findAll();
		ActionContext.getContext().put("primaryResourcesList", primaryResourcesList);
		return "listPrimaryResources";
	}
}
