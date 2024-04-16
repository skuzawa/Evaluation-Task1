<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>) request.getAttribute("rows");
	%>
	<form action="index" method="POST">
	
	<table border="1">
		<tr>
			<th>書籍名</th>
			<th>価格</th>
			<th>発行日</th>
		</tr>
		<%
		for (HashMap<String, String> columns : rows) {
		%>
		<tr>
				<td><%=columns.get("name")%></td>
				<td><%=columns.get("position")%></td>
				<td><%=columns.get("dpt")%></td>
				
				<td><button type="submit" value="delete" class="btn" name="action">削除</button></td> 
				<input type="hidden" name="id" value=<%=columns.get("id")%>>
				</form>
				<form action="update" method="GET">
				<td><button type="submit" value="update" class="btn" name="action">更新</button></td>
				<input type="hidden" name="id" value=<%=columns.get("id")%>>
				</form>
		</tr>
		<%}%>
	</table>
	<form action="resister" method="GET">
	<button type=submit>登録</button>
	</form>
	
</body>
</html>