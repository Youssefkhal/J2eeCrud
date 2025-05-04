package net.javaguides.login.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import net.javaguides.login.bean.Article;
import net.javaguides.login.database.ArticleDao;

@WebServlet("/updateArticle")
public class UpdateArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArticleDao articleDao;

    public void init() {
        articleDao = new ArticleDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des champs du formulaire
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");

        // Création de l'objet Article
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setAuthor(author);
        article.setContent(content);

        // Mise à jour dans la base de données
        try {
			articleDao.updateArticle(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Redirection après la mise à jour
        response.sendRedirect("listarticles.jsp");
    }
}
