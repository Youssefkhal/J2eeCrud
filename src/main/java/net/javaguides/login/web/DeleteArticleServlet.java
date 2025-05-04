package net.javaguides.login.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            if (id != null && !id.trim().isEmpty()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj?useSSL=false&serverTimezone=Africa/Casablanca", "root", "");

                String sql = "DELETE FROM article WHERE id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(id));

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    request.setAttribute("message", "Article deleted successfully.");
                } else {
                    request.setAttribute("message", "Article not found.");
                }
            } else {
                request.setAttribute("message", "Invalid article ID.");
            }
        } catch (Exception e) {
            request.setAttribute("message", "Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                // Ignore cleanup errors
            }
        }

        request.getRequestDispatcher("deletearticle.jsp").forward(request, response);
    }
}
