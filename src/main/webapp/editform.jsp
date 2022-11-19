<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.dao.StudentDAO, com.example.bean.StudentVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>

<%
	StudentDAO studentDAODAO = new StudentDAO();
	String id=request.getParameter("id");	
	StudentVO u=studentDAODAO.getSTUDENT(Integer.parseInt(id));
	request.setAttribute("u", u);
%>

<h1>학생 정보 수정</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
<table id="edit">
	<tr><td>Name:</td><td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
	<tr><td>Age:</td><td><input type="text" name="age" value="<%= u.getAge()%>"/></td></tr>
	<tr><td>Gender:</td><td><input type="text" name="gender" value="<%= u.getGender()%>"/></td></tr>
	<tr><td>Student ID:</td><td><input type="text" name="id" value="<%= u.getId()%>"/></td></tr>
	<tr><td>Email:</td><td><input type="text" name="email" value="<%= u.getEmail()%>"/></td></tr>
	<tr><td>RC:</td><td><input type="text" name="RC" value="<%= u.getRC()%>"/></td></tr>
	<tr><td>Phone:</td><td><input type="text" name="phone" value="<%= u.getPhone()%>"/></td></tr>
	<tr><td>Photo:</td></td><input type="file" name="photo" value="<%= u.getPhoto()%>"/>
	<c:if test="${u.getPhoto() ne ''}"><br /><img src="${pageContext.request.contextPath}/upload/${u.getPhoto()}" class="photo"></c:if></td></tr>

<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>