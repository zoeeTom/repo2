package com.zoee.jdbc;

import java.sql.*;

/**
 * @Author auuuu
 * @Date 2021/7/6 9:42
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study01",
                "root","123456");
        //3.获取操作数据库的预处理对象
        PreparedStatement preparedStatement = conn.prepareStatement("select * from account");
        //4.执行查询，获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        //关闭资源
        resultSet.close();
        preparedStatement.close();
        conn.close();

    }
}
