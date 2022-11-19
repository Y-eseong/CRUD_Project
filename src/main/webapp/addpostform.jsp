<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD</title>
</head>
<body>

<h1>학생 정보 추가</h1>
<form action="addpost.jsp" method="post" enctype="multipart/form-data">
<table id="edit">
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
<tr><td>Age:</td><td><input type="text" name="age"/></td></tr>
<tr><td>Gender:</td><td><input type="text" name="gender"/></td></tr>
<tr><td>Student ID:</td><td><input type="text" name="id"/></td></tr>
    <tr><td>Email:</td><td><input type="text" name="email"/></td></tr>
    <tr><td>RC:</td><td><input type="text" name="RC"/></td></tr>
    <tr><td>Phone:</td><td><input type="text" name="phone"/></td></tr>
    <tr><td>Photo:</td><td><input type="file" name="photo"/></td></tr>
    <tr><td><a href="posts.jsp">목록 보기</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>