package bioui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author timothy
 */
public class InputPane extends JFrame {
    private JPanel panel; // where the form will be
    private JTextField studentName; // the student's name
    private JTextField studentID; // the student's ID
    private JTextField GPS; // GPS cords for the dirt
    private JTextField locationDescription; // description of where it came from
    private JTextField voltage; //the electrical output of the experiment
    private JButton submit; // for a button to submit the completed form
    private final int WINDOW_HEIGHT=300;
    private final int WINDOW_WIDTH=1000;
    private final int TABLE_WIDTH=12;
    private final int TABLE_HEIGHT=8;
    
    
    
    //Letters to denote wells
    String[] wells = {"A", "B", "C", "D", "E", "F", "G", "H"};
    
    /**
     * Constructor
     */
    public InputPane(){
        setTitle("Experiment form"); //title of window
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set the exit behavior
        buildPanel(); //run buildPanel()
        add(panel); //add panel to the window
        //pack(); 
        setVisible(true); //make sure the window is visible
    }

    
    private void buildPanel() {
        //create components
        studentName = new JTextField("Student Name");
        studentID = new JTextField("Student ID");
        GPS = new JTextField("GPS cords");
        voltage = new JTextField("Voltage");        
        locationDescription=  new JTextField("Description of location");
        submit = new JButton("Submit");
        
        //add listener for the submit button
        submit.addActionListener(new submitButtonListener());
                
        //create main panel
        panel = new JPanel();
        
        //set layout of the main panel
        panel.setLayout(new BorderLayout());
        
        //make panels for the individual sections
        JPanel top = new JPanel(); //top of the window
        JPanel plate = new JPanel(); //table of experiment data
        JPanel end = new JPanel(); //bottom of the screen for the submit button        
        
        
        plate.setLayout(new GridLayout(TABLE_HEIGHT,TABLE_WIDTH)); //set the dimentions of the table
        plate.setBorder(BorderFactory.createTitledBorder("EcoPlate Results"));
        JComboBox[][] grid=new JComboBox[TABLE_HEIGHT][TABLE_WIDTH]; //make an array of combo boxes with the same dimantions as the table
        //loop through the table array
        for(int x=0; x<TABLE_HEIGHT; x++){
            for(int y=0; y<TABLE_WIDTH; y++){
                //declare choices for the dropdown menu
                String[] dataStates = {wells[x]+", "+(y+1), "No data", "Negative", "Borderline", "Positive"};
                //add the new combo box to the array
                grid[x][y] = new JComboBox(dataStates);
                //add the combo box to the table
                plate.add(grid[x][y]);
            }
        }
        
        //add the components to the appropreate sub panels
        top.add(studentName);
        top.add(studentID);
        top.add(GPS);
        top.add(locationDescription);
        top.add(voltage);
        end.add(submit);
        
        //add the sub panels to the main panel
        panel.add(top, BorderLayout.NORTH);
        panel.add(end, BorderLayout.SOUTH);
        panel.add(plate, BorderLayout.CENTER);
    }
    
    /**
     * submitButtonListener is an action listener for the submit button
     */
    private class submitButtonListener implements ActionListener{
        /**
         * The actionPreformed method executes when the submit button is clicked
         * @param e the event object
         */
        public void actionPerformed(ActionEvent e){
            
        }
    }
}