package com.laptrinhjavaweb.utils;

import java.sql.*;

public class SqlUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/estateadvance";
    private static final String USER = "root";
    private static final String PASS = "root";
//	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        try {
//			Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        }catch(SQLException e){
            throw new SQLException("Could not get connection");
        }
    }

    public static void closeAllConnection(Connection conn, Statement stmt, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
