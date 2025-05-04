package net.javaguides.login.database;
import net.javaguides.login.bean.Article;

import java.sql.*;
import java.util.*;


public class ArticleDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/proj?useSSL=false&serverTimezone=Africa/Casablanca";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT = "INSERT INTO article (title, content, author) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM article";
    private static final String SELECT_BY_ID = "SELECT * FROM article WHERE id = ?";
    private static final String UPDATE = "UPDATE article SET title = ?, content = ?, author = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM article WHERE id = ?";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertArticle(Article a) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, a.getTitle());
            stmt.setString(2, a.getContent());
            stmt.setString(3, a.getAuthor());
            stmt.executeUpdate();
        }
    }
    

    public List<Article> selectAllArticles() throws SQLException {
        List<Article> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setAuthor(rs.getString("author"));
                list.add(a);
            }
        }
        return list;
    }

    public Article selectArticle(int id) throws SQLException {
        Article a = null;
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                a = new Article();
                a.setId(id);
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setAuthor(rs.getString("author"));
            }
        }
        return a;
    }

    public boolean updateArticle(Article a) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setString(1, a.getTitle());
            stmt.setString(2, a.getContent());
            stmt.setString(3, a.getAuthor());
            stmt.setInt(4, a.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteArticle(int id) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
    
}
