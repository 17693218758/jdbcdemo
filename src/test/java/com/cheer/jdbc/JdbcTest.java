package com.cheer.jdbc;

import org.junit.*;

import java.sql.*;

public class JdbcTest {

    //查询数据库表dept的信息
    @Test
    public void getDept(){
        try{
            //加载驱动 ##反射##
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/1?useUnicode=true&characterEncoding=UTF-8";
        String sql = "select * from dept";
        //ALT + Enter 导入类和解决异常
        //3个接口
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            //获取数据库连接
            connection = DriverManager.getConnection(url,username,password);
            //创建一个statement，用来执行sql语句
            statement = connection.prepareStatement(sql);
            //执行sql，并获取结果集
            resultSet = statement.executeQuery();
            //遍历结果集
            while (resultSet.next()){
                Integer deptno = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String loc = resultSet.getString(3);
                //%s表示一个占位符
                System.out.println(String.format("%s\t%s\t%s",deptno,name,loc));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭资源，顺序按照先不用的先关闭
        finally{
            try{
                //CTRL+ALT+T
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if (connection !=null){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    @Test
    //增
    public void save(){
        try{
            //加载驱动 ##反射##
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/1?useUnicode=true&characterEncoding=UTF-8";
        String sql = "insert into dept values(?,?,?)";
        //ALT + Enter 导入类和解决异常
        //2个接口
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            //获取数据库连接
            connection = DriverManager.getConnection(url,username,password);
            //创建一个statement，用来执行sql语句
            statement = connection.prepareStatement(sql);
            statement.setObject(1,"a");
            statement.setObject(2,"NEW-1");
            statement.setObject(3,"BEIJIN");

            int result = statement.executeUpdate(sql);

            Assert.assertEquals(1,result);

        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭资源，顺序按照先不用的先关闭
        finally{
            try{
                //CTRL+ALT+T
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if (connection !=null){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    @Test
    //改
    public void update(){
        try{
            //加载驱动 ##反射##
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/1?useUnicode=true&characterEncoding=UTF-8";
        String sql = "update dept set loc = ? where deptno = ?";
        //ALT + Enter 导入类和解决异常
        //3个接口
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            //获取数据库连接
            connection = DriverManager.getConnection(url,username,password);
            //创建一个statement，用来执行sql语句
            statement = connection.prepareStatement(sql);
            statement.setObject(1,"SHANGHAI");
            statement.setObject(2,50);

            int result = statement.executeUpdate(sql);

            Assert.assertEquals(1,result);

        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭资源，顺序按照先不用的先关闭
        finally{
            try{
                //CTRL+ALT+T
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if (connection !=null){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    @Test
    //删
    public void remove(){
        try{
            //加载驱动 ##反射##
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/1?useUnicode=true&characterEncoding=UTF-8";
        String sql = "delete from dept where deptno = ?";
        //ALT + Enter 导入类和解决异常
        //3个接口
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            //获取数据库连接
            connection = DriverManager.getConnection(url,username,password);
            //创建一个statement，用来执行sql语句
            statement = connection.prepareStatement(sql);
            statement.setObject(1,50);
            int result = statement.executeUpdate(sql);

            Assert.assertEquals(1,result);

        }catch (SQLException e){
            e.printStackTrace();
        }
        //关闭资源，顺序按照先不用的先关闭
        finally{
            try{
                //CTRL+ALT+T
                if(statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

            try{
                if (connection !=null){
                    connection.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}


