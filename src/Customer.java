import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


    public class Customer extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取客户信息
            String id = req.getParameter("id");
            String password = req.getParameter("password");
            int count = 0;
            //JDBC
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dingyu?serverTimezone=UTC", "root", "DingYu,!199000521");
                String sql = "insert into zhanghu(id,password) values(?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, password);

                count = ps.executeUpdate();

            } catch (Exception e) {

            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            //保存成功跳转到欢迎界面
            if (count > 0) {
                resp.sendRedirect(req.getContextPath() + "/" + "list.jsp");
            }
        }
    }

