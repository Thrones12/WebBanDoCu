<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<Label>ID</Label><br> 
		<input type="text" name="userID" /><br>
	
		<Label>Name</Label><br> 
		<input type="text" name="userName" /><br>
		
		<Label>Password</Label><br> <input type="text"
			name="password" /><br> 
			
		<Label>Email</Label><br> <input
			type="text" name="email" /><br> 
			
		<Label>Role</Label><br> <input type="text"
			name="role" /><br> 
		
		<input type="submit"
			value="User insert" />
	</form>
</body>
</html>