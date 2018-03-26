package com.wang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.wang.base.BaseAction;
import com.wang.domain.SecondResources;
import com.wang.utils.ZipFileUtil;

@Controller
@Scope("prototype")
public class BatchDownloadAction extends BaseAction<SecondResources>{

	private String[] selectedRow;
	//压缩后保存的名字
	private String fileName;
	//下载时用到的额输入流
	private InputStream inputStream;
	
	public String getFileName() throws Exception {
		 String formatDate =new  SimpleDateFormat("yyyyMMdd").format(new Date());
	        //压缩后的zip文件存放路径
		String  ploadName = formatDate + ".zip";
		ploadName=new String(ploadName.getBytes(),"iso-8859-1");  
		return ploadName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String batchDownloadSecondResources() throws Exception{
		List<String> filenames=secondResourcesService.getFileNameByIds(selectedRow);
	
		  //使用当前时间生成文件名称
        String formatDate =new  SimpleDateFormat("yyyyMMdd").format(new Date());
        //压缩后的zip文件存放路径
        String fileName1 = "D:\\test\\" + formatDate + ".zip";
         
        if(filenames != null && !"".equals(filenames)) {
            //将多个附件的路径取出
            if(filenames != null && filenames.size() >0) {
                File[] files = new File[filenames.size()];
                for(int i=0;i<filenames.size();i++) {
                    if(filenames.get(i) != null) {
                        File file = new File(filenames.get(i).trim());
                        if(file.exists()) {
                            files[i] = file;
                        }
                    }
                }
                //将多个附件压缩成zip
                ZipFileUtil.compressFiles2Zip(files,fileName1);
            }
        }
        inputStream = new FileInputStream(fileName1);
		return "batchDownloadSecondResources"; 
	}
	

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}
	

	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
