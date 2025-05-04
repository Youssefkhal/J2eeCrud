package net.javaguides.login.web;
import net.javaguides.login.database.ArticleDao;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.login.bean.Article;

@WebServlet("/add-article")
public class AddArticleServlet extends HttpServlet {
    private ArticleDao articleDao;

    public void init() {
        articleDao = new ArticleDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);

        try {
            articleDao.insertArticle(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("listarticles.jsp");
    }
}
