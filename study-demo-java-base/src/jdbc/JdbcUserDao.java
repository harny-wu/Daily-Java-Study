package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author daiYang_wu
 */
public class JdbcUserDao implements UserDao {

    @Override

    public void add(User form) {

        String driverClassName = "com.mysql.jdbc.Driver";    //启动驱动

        String url = "jdbc:mysql://localhost:3306/test";    //设置连接路径

        String username = "root";    //数据库用户名

        String password = "123";    //数据库连接密码

        Connection con = null;        //连接

        PreparedStatement pstmt = null;    //使用预编译语句

        ResultSet rs = null;    //获取的结果集

        try {

            Class.forName(driverClassName); //执行驱动

            con = DriverManager.getConnection(url, username, password); //获取连接

            String sql = "INSERT INTO USER VALUES(?,?,?,?)"; //设置的预编译语句格式

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, form.getUsername());

            pstmt.setString(2, form.getPassword());

            pstmt.setInt(3, form.getAge());

            pstmt.setString(4, form.getGender());

            pstmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(e);

        } finally {

            //关闭资源,倒关

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (con != null) con.close();  //必须要关

            } catch (Exception e) {

            }

        }

    }

    @Override

    public User findByUsername(String username) {

        String driverClassName = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/test";

        String mysqlusername = "root";

        String password = "123";

        Connection con = null;

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        try {

            Class.forName(driverClassName);

            con = DriverManager.getConnection(url, mysqlusername, password);

            String sql = "SELECT * FROM USER WHERE username=?";

            pstmt = con.prepareStatement(sql);

            pstmt.setNString(1, username);

            rs = pstmt.executeQuery();

            if (rs == null) {

                return null;

            }

            if (rs.next()) {

                User user = new User();

                user.setUsername(rs.getString("username"));

                user.setPassword(rs.getString("password"));

                user.setAge(rs.getInt("age"));

                user.setGender(rs.getString("gender"));

                return user;

            } else {

                return null;

            }

        } catch (Exception e) {

            throw new RuntimeException(e);

        } finally {

            //关闭资源,倒关

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (con != null) con.close();  //必须要关

            } catch (Exception e) {

            }

        }

    }

}