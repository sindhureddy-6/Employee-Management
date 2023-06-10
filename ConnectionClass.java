package Employee_management;
import java.sql.*;

public class ConnectionClass {
    Connection con;
    Statement stm;

    ConnectionClass(){
        try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "sindhu2004");
      stm=con.createStatement();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ConnectionClass(); 
    }
}
