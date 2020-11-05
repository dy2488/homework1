import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test_1 {
    public static void main(String[] args) {
        Connection conn = null;
        int count=0;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dingyu?serverTimezone=UTC", "root", "DingYu,!199000521");
            String sql = "insert into zhanghu(id,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "sfsfdfds");
            ps.setString(2, "dvdvddvdvd");
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
        if(count>0){
            System.out.println("hello");
        }
    }

}

