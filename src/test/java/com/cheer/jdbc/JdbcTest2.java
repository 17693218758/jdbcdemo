// 预编译的方式
package com.cheer.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
public class JdbcTest2 {
    public void securityLogin() {
        try {
        // 加载驱动 ##反射##
        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }

        String dbUsername = "root";
        String dbPassword = "123456";
        String url = "jdbc:mysql://localhost:3306/1?useUnicode=true&characterEncoding=UTF-8&useSSL=false";

        // 安全漏洞：sql注入
        // String username = "admin' or '1' = '1";
        // String password = "sfsdfsdf";
        String username = "admin";
        String password = "admin";
        // select count(*) from user where username = 'admin' and password = 'admin'

        // ?是占位符
        String sql = "select count(*) from user where username = ? and password = ?";

        // ALT + Enter 导入类和解决异常
        Connection connection = null;
        // Statement statement = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        // 获取数据库连接
        connection = DriverManager.getConnection(url, dbUsername, dbPassword);
        // 创建一个Statement，用来执行sql语句
        statement = connection.prepareStatement(sql);
        // 给预编译语句设置参数
        statement.setString(1, username);
        statement.setString(2, password);
        // 执行sql，并获取结果集
        resultSet = statement.executeQuery();
        // 遍历结果集
        if (resultSet.next()) {
        int count = resultSet.getInt(1);
        if (count == 1) {
        System.out.println("登录成功！");
        return;
        }
        }
        System.out.println("登录失败！");
        } catch (SQLException e) {
        e.printStackTrace();
        }
        // 关闭资源，顺序按照先不用的先关闭
        finally {
        try {
        // CTRL + ALT + T
        if (resultSet != null) {
        resultSet.close();

        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        try {
        if (statement != null) {
        statement.close();
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        try {
        if (connection != null) {
        connection.close();
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
    }
}

