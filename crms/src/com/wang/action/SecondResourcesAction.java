package com.wang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wang.base.BaseAction;
import com.wang.domain.PrimaryResources;
import com.wang.domain.SecondResources;
import com.wang.utils.PageUtil;
import com.wang.utils.ZipFileUtil;

@Controller
@Scope("prototype")
public class SecondResourcesAction extends BaseAction<SecondResources>{

	private  File upload; //上传的文件内容 
	private  String uploadFileName;  //文件名
	private  String uploadContentType;
	private int  page=1;
	//下载时用到的额输入流
	private InputStream inputStream;
	//下载的文件名称
	private String fileName;
	
	//单个文件的下载
		public String uploadSecondResources() throws Exception{
			SecondResources secondResources=secondResourcesService.getSecondUnitById(model.getId());
			String url=secondResources.getSr_url();
			url = url.replace("\\", "\\\\");
			File  file=new File(url);
			inputStream = new FileInputStream(file);
			return "uploadSecondResources";
		}
	
	
	public String getFileName() throws Exception {
		SecondResources secondResources=secondResourcesService.getSecondUnitById(model.getId());
		String url=secondResources.getSr_url();
		int pos=url.lastIndexOf("\\");
		String ploadName=url.substring(pos);
		ploadName=new String(ploadName.getBytes(),"iso-8859-1");  
		return ploadName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	//转到修改er级单位的界面updateSecondUnitUI
	public String updateSecondResourcesUI(){
		//准备回显的er级单位信息
		SecondResources secondResources=secondResourcesService.getSecondUnitById(model.getId());
		ActionContext.getContext().getValueStack().push(secondResources);
		//准备回显一级单位的信息
	    List<PrimaryResources> primaryResourcesList=primaryResourcesService.findAll();
	    ActionContext.getContext().getValueStack().set("primaryResourcesList",primaryResourcesList);
	    
		return "updateSecondResourcesUI";
	}

	//保存修改一级单位的信息
	public String editSecondResources(){
		// 1，从数据库取出原对象
		SecondResources secondUnit=secondResourcesService.getSecondUnitById(model.getId());
		// 2，设置要修改的属性
		secondUnit.setSname(model.getSname());
		//3更新所属的一级单位
		secondUnit.setPrimaryResources(model.getPrimaryResources());
		// 4，更新到数据库中
		secondResourcesService.update(secondUnit);
		return "editSecondResources";
	}
	//添加二级单位
		public String secondResourcesAdd() throws Exception{
			PrimaryResources primaryResources=primaryResourcesService//
					.getPrimaryUnitById(model.getPrimaryResources().getId());//
			
			//拼接新的文件名
			if(upload!=null){
				//创建路径名和相应文件
				String myfile="e:\\javaUpload\\"+primaryResources.getPname();
				                
				File file = new File(myfile);
				if(!file.exists()){
					file.mkdirs();
				}
				
				  File f1=new File(file.getPath()+ File.separator+getUploadFileName());
				  f1.createNewFile(); 
	
				//定义输出流
					OutputStream os=new FileOutputStream(f1);
					InputStream is=new FileInputStream(getUpload());
					byte buffer[]=new byte[1024];
					int count=0;
					while((count=is.read(buffer))>0){
						os.write(buffer,0,count);
					}
					os.close();
					is.close();	
					//保存信息
					model.setSr_url(file.getPath()+ File.separator+getUploadFileName());
					secondResourcesService.save(model);
			}
			return "secondResourcesAdd";
		}
	
	//转到SecondResourcesUI页面
	public String addSecondResourcesUI(){
		//准备所有的一级单位
		List<PrimaryResources> primaryResourcesList=primaryResourcesService.findAll();
		ActionContext.getContext().getValueStack().set("primaryResourcesList",primaryResourcesList);
		return "addSecondResourcesUI";
	}
	//删除一级单位
	public String deleteSecondResources(){
		// 1，删除到数据库中
		SecondResources resources=secondResourcesService.getSecondUnitById(model.getId());
		String url=resources.getSr_url();
		
		url = url.replace("\\", "\\\\");
		File  file=new File(url);
		
		if(file.exists() ){
			file.delete();
		}
		secondResourcesService.delete(model.getId());
		return "deleteSecondResources";
	}
	//二级资源列表
	public String listSecondResources(){
		PageUtil<SecondResources> pageUtil=secondResourcesService.getSecondResourcesByPage(page,8);
		ActionContext.getContext().getValueStack().push(pageUtil);
		return "listSecondResources";
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
