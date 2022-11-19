<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.StudentDAO, com.example.bean.StudentVO"%>
<%@page import="com.example.util.FileUpload"%>
<%
	String sid = request.getParameter("id");
	if (sid != ""){  
		int id = Integer.parseInt(sid);
		StudentVO u = new StudentVO();
		u.setSeq(id);
		StudentDAO studentDAO = new StudentDAO();
		String filename = studentDAO.getPhotoFilename(id);
		if(filename != null) FileUpload.deleteFile(request, filename);
		studentDAO.deleteSTUDENT(u);
	}
	response.sendRedirect("posts.jsp");
%>