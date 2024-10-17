package com.example.dailylearning.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static final Logger log = LoggerFactory.getLogger(DBHelper.class);

    private static final String dbUrl = "jdbc:mysql://localhost:3306/cs_vipplatest?serverTimezone=UTC&rewriteBatchedStatements=true";
//    private static final String dbUrl = "jdbc:mysql://10.0.17.96:3306/vipplatest?serverTimezone=UTC&rewriteBatchedStatements=true";

    private static final String username = "root"; //用户名

    private static final String password = "beyourSelf95."; //密码

    private static final String driverClassName = "com.mysql.jdbc.Driver"; //连接类型

    public Connection conn = null; //数据库连接对象

    public DBHelper() {}

    /**
     * 提供功能接口，用于获取连接对象
     * @return Connection
     */
    public Connection getConnection(){
        return conn;
    }

    //开启数据库连接
    public void openConnection() {
        try {
            Class.forName(driverClassName);//指定连接类型
            conn = DriverManager.getConnection(dbUrl, username, password);//获取连接
            conn.setAutoCommit(false);//关闭自动提交
        } catch (Exception e) {
            log.error("数据库连接失败，请联系相关人员排查！",e);
        }
    }

    //关闭数据库连接
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            log.error("关闭数据库连接失败，请联系相关人员排查！",e);
        }
    }
}
