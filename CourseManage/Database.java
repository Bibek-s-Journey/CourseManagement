
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection con = null;
    public static Connection Connect() {
        try{
                String url = "jdbc:MySQL://localhost:3306/Course_management";
                String username = "root";
                String password = "";
                con = DriverManager.getConnection(url, username, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
