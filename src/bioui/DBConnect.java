package bioui;
import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
/**
 *
 * @author timothy
 */
public class DBConnect {
    private Connection conn;
    private Statement stat;
    private ResultSet res;
    
    final private String databaseLocation="jdbc:mysql://localhost:3306/BioDB";
    
    Statement statement;
    
    /**
     * Constructor
     * @throws java.sql.SQLException
     */
    public DBConnect() throws SQLException{
        this.statement = conn.createStatement();
        
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
