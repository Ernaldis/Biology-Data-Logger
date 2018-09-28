package bioui;
import java.sql.*;
import java.sql.Statement;
import java.io.*;
import java.util.Scanner;
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
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: You are an idiot because:\n"+e.getMessage());
        }
    }
    
    final String fileName = "DO_NOT_TOUCH.txt";
    
    /**
     * Make a unique transaction number for each form filled.
     * Read the number from DO_NOT_TOUCH.txt & return it. 
     * Replace the number in the file with the next integer. 
     * @return 
     * @throws java.io.FileNotFoundException
     */
    public int id() throws FileNotFoundException{
        
        //Create a scanner object for koyboard input
        Scanner keyboard = new Scanner(System.in);
        
        //Open the file
        File file = new File(fileName);
        int ID;
        //Read the number
        try (Scanner inputFile = new Scanner(file)) {
            //Read the number
            String line = inputFile.nextLine();
            //Parse number into ID integer
            ID = Integer.parseInt(line);
            //Close the file
        }
        
        //Replace number in DO_NOT_TOUCH.txt with the next integer
        try ( //Open the file
                PrintWriter outputFile = new PrintWriter(fileName)) {
            //Replace number in DO_NOT_TOUCH.txt with the next integer
            outputFile.print(ID+1);
            //Close the file
        }
        
        //Output the ID number
        return ID;
        
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
