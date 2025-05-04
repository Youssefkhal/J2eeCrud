<%@ page
	import="java.util.*,  net.javaguides.login.database.ArticleDao, net.javaguides.login.bean.Article"%>
<%
    ArticleDao dao = new ArticleDao();
    List<Article> articles = dao.selectAllArticles();
%>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Actions</th>
	</tr>
	<%
        for (Article a : articles) {
    %>
	<tr>
		<td><%= a.getId() %></td>
		<td><%= a.getTitle() %></td>
		<td><%= a.getAuthor() %></td>
		<td><a href="editarticle.jsp?id=<%= a.getId() %>">Edit</a> <a
			href="DeleteArticleServlet?id=<%= a.getId()%>" onclick="return confirm('Are you sure you want to delete this article?');">Delete</a></td>
	</tr>
	<%
        }
    
    %>

</table>
	<a href="addarticle.jsp">
		<button type="button">Add New Article</button>
	</a>
	<a href="login.jsp">
		<button type="button">back to login</button>
	</a>
