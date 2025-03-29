package Hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;
    public Conn() {
        try {
            Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_Management_System","root","75148623");
            statement = Connection.createStatement();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
