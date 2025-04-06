package com.example.socialnetwork.dao;
import com.example.socialnetwork.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    // Kiểm tra đăng nhập
    public boolean checkLogin(String username, String password) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
    // Đăng ký người dùng mới
    public boolean registerUser(String username, String password) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            // Kiểm tra username đã tồn tại
            String checkSql = "SELECT COUNT(*) FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return false; // Username đã tồn tại
            }
            // Thêm user mới
            String sql = "INSERT INTO users (username, password, role, created_at) VALUES (?, ?, 'user', CURRENT_TIMESTAMP)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        }
    }
    // Lấy user_id từ username
    public int getUserId(String username) throws Exception {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getInt("id") : -1;
        }
    }
}