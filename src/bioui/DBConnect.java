package bioui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author timothy
 */
public class DBConnect {
    private Connection conn;
    private Statement stat;
    private ResultSet res;

    /**
     * Constructor
     * @throws java.sql.SQLException
     */
    public DBConnect() throws SQLException{
        Statement statement = conn.createStatement();
        
    }
    
    /**
     * Attempt to log into the database
     */
    public void openConnection(){
        try{
            Class.forName("com.mysql.jbdc.Driver");
            String databaseLocation = "jdbc:mysql://localhost:3306/BioDB";
            conn=DriverManager.getConnection(databaseLocation);
            System.out.println("Connection established");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: You are an idiot because:\n"+e.getMessage());
        }
    }

    /**
     * Make a unique transaction number for each form filled.
     * Read the number from DO_NOT_TOUCH.txt & return it. 
     * Replace the number in the file with the next integer. 
     * @return The transaction ID number
     * @throws java.io.FileNotFoundException someone removed the ID file
     */
    public int id() throws FileNotFoundException{

        //Open the file
        String fileName = "DO_NOT_TOUCH.txt";
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
