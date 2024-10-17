package com.example.dailylearning.database;

import java.sql.*;

public class CreateDataBase {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 注册SQLite的JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            // 创建连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_vipplatest?serverTimezone=UTC&rewriteBatchedStatements=true","root","beyourSelf95.");
            System.out.println("连接成功");

            // 创建Statement对象
            statement = connection.createStatement();

            //创建数据库
            String createDataBase = "CREATE DATABASE learnIt";
            statement.execute(createDataBase);
            System.out.println("数据库已创建");

            //连接所创建数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnIt?serverTimezone=UTC&rewriteBatchedStatements=true","root","beyourSelf95.");
            System.out.println("learnIt连接成功");

            // 创建Statement对象
            statement = connection.createStatement();

            // 创建表
            String createTableQuery = "CREATE TABLE student (name varchar(50) not null primary key, age int)";
            statement.execute(createTableQuery);
            System.out.println("表已创建");

            // 插入记录
            String insertQuery = "INSERT INTO student (name, age) VALUES ('John', 30)";
            statement.executeUpdate(insertQuery);
            System.out.println("记录已插入");

            // 查询记录
            String selectQuery = "SELECT * FROM student";
            resultSet = statement.executeQuery(selectQuery);
            //进行结果集解析
            //看是否有下一行数据，有的话就可以获取，
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("查询记录为：" + name + "--" + age);
            }

            // 更新记录
            String updateQuery = "UPDATE student SET age = 40 WHERE name = 'John'";
            statement.executeUpdate(updateQuery);
            System.out.println("记录已更新");

            // 删除记录
            String deleteQuery = "DELETE FROM student WHERE name = 'John'";
            statement.executeUpdate(deleteQuery);
            System.out.println("记录已删除");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接和Statement对象、resultSet对象。
                if (resultSet != null)
                    resultSet.close();

                if (statement != null)
                    statement.close();

                if (connection != null)
                    connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
