<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	text-align: right;
}
</style>
</head>
<body>
	<div id="show" align="center">
		<h2>로그인</h2>
		<form id="frm" name="frm" action="login" method="post">
			<table id="tbl">
				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>패스워드 :</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<br>
			<button type="submit">로그인</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>