<%@ page import="java.util.*, net.javaguides.login.database.ArticleDao, net.javaguides.login.bean.Article" %>
<%
    ArticleDao dao = new ArticleDao();
    List<Article> articles = dao.selectAllArticles();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Articles List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f4f4f4;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 0 auto 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px #ccc;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        a {
            text-decoration: none;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 16px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        button:hover {
            background-color: #45a049;
        }

        .button-container {
            text-align: center;
        }
    </style>
</head>
<body>

<h1>List of Articles</h1>

<table>
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
        <td>
            <a href="editarticle.jsp?id=<%= a.getId() %>">
                <button>Edit</button>
            </a>
            <a href="DeleteArticleServlet?id=<%= a.getId()%>" onclick="return confirm('Are you sure you want to delete this article?');">
                <button>Delete</button>
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>

<div class="button-container">
    <a href="addarticle.jsp"><button type="button">Add New Article</button></a>
    <a href="login.jsp"><button type="button">Back to Login</button></a>
</div>

</body>
</html>
