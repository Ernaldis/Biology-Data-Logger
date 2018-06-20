package bioui;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author timothy
 */
public class DBConnect {
    private Connection conn;
    private Statement stat;
    private ResultSet res;
    
    final private String databaseLocation="jdbc:mysql://localhost:3306/BioDB";
    
    /**
     * Constructor
     */
    public DBConnect(){
        
    }
    
    /**
     * Attempt to log into the database
     */
    public void openConnection(){
        try{
            Class.forName("com.mysql.jbdc.Driver");
            conn=DriverManager.getConnection(databaseLocation);
            System.out.println("Connection established");
        }
        catch(Exception e){
            System.out.println("Error: You are an idiot because:\n"+e.getMessage());
        }
    }
    
    /**
     * Close the connection to the database
     */
    public void closeConnection(){
        try {
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
