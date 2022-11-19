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

	int i = studentDAO.insertSTUDENT(u);
	String msg = "데이터 추가 성공 !";
	if(i == 0) msg = "[에러] 데이터 추가 ";
%>

<script>
	alert('<%=msg%>');
	location.href='posts.jsp';
</script>