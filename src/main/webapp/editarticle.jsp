<%@ page import="net.javaguides.login.bean.Article"%>
<%@ page import="net.javaguides.login.database.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ArticleDao dao = new ArticleDao();
    Article article = dao.selectArticle(id);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Article</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 500px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 15px;
            color: #444;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        textarea {
            resize: vertical;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            margin-top: 20px;
            width: 100%;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Edit Article</h2>
    <form action="updateArticle" method="post">
        <input type="hidden" name="id" value="<%= article.getId() %>">

        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="<%= article.getTitle() %>" required>

        <label for="author">Author:</label>
        <input type="text" id="author" name="author" value="<%= article.getAuthor() %>" required>

        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="5" required><%= article.getContent() %></textarea>

        <input type="submit" value="Update">
    </form>
</div>

</body>
</html>

