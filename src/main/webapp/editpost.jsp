<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.StudentDAO"%>
<%@page import="com.example.util.FileUpload"%>
<%@ page import="com.example.bean.StudentVO" %>
<% request.setCharacterEncoding("utf-8"); %>

<%--<jsp:useBean id="u" class="com.example.bean.StudentVO" />--%>
<%--<jsp:setProperty property="*" name="u"/>--%>

<%
	StudentDAO studentDAO = new StudentDAO();
	FileUpload upload = new FileUpload();
	StudentVO u = upload.uploadPhoto(request);

	int i=studentDAO.updateSTUDENT(u);
	response.sendRedirect("posts.jsp");
%>