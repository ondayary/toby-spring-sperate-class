package com.line;

import com.line.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UserDao {

    // add
    public void add(User user) throws SQLException {

        Map<String, String> env = System.getenv();

        Connection c = DriverManager.getConnection(env.get("DB_HOST"),
                                                   env.get("DB_USER"),
                                                   env.get("DB_PASSWORD"));

        Connection conn = null;
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id, name, pasword) VALUES(?,?,?)"
        );

        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        // Query문 실행
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User select(String id) {

    }
}
