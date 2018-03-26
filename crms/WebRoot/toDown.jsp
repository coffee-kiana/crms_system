<%@ page language="java" import="java.util.*,java.io.* "
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String filename = request.getParameter("filename");
	filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
	System.out.println(filename);
	OutputStream o = response.getOutputStream();
	byte b[] = new byte[500];
	/** * 得到文件的当前路径 * @param args */
	String serverpath = request.getRealPath("\\");
	File fileLoad = new File(serverpath + filename);
	//response.setContentType("application/octet-stream");//导入txt文件
	response.setContentType("application/vnd.ms-excel");//导入excel文件
	response.setHeader("content-disposition", "attachment; filename="
			+ filename);
	long fileLength = fileLoad.length();
	String length1 = String.valueOf(fileLength);
	response.setHeader("Content_Length", length1);
	FileInputStream in = new FileInputStream(fileLoad);
	int n;
	while ((n = in.read(b)) != -1) {
		o.write(b, 0, n);
	}
	in.close();
	out.clear();
	out = pageContext.pushBody();
%>