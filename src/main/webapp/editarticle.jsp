<%@ page import="net.javaguides.login.bean.Article"%>
<%@ page import="net.javaguides.login.database.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ArticleDao dao = new ArticleDao();
    Article article = dao.selectArticle(id);
%>
<html>
<head>
<title>Edit Article</title>
</head>
<body>
	<h2>Edit Article</h2>
	<form action="updateArticle" method="post">
		<input type="hidden" name="id" value="<%= article.getId() %>">
		Title: <input type="text" name="title"
			value="<%= article.getTitle() %>" required><br>
		<br> Author: <input type="text" name="author"
			value="<%= article.getAuthor() %>" required><br>
		<br> Content:<br>
		<textarea name="content" rows="5" cols="50"><%= article.getContent() %></textarea>
		<br>
		<br> <input type="submit" value="Update">
	</form>
</body>
</html>
