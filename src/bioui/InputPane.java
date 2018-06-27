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
    private JTextField locationDescription; // description of where it came from
    private JTextField voltage; //the electrical output of the experiment
    private JButton submit; // for a button to submit the completed form
    private JButton save; // save plate data
    private final int WINDOW_HEIGHT=300;
    private final int WINDOW_WIDTH=1000;
    private final int TABLE_WIDTH=12;
    private final int TABLE_HEIGHT=8;
    JComboBox[][] grid=new JComboBox[TABLE_HEIGHT][TABLE_WIDTH]; //make an array of combo boxes with the same dimantions as the table
    
    
    
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
        setLocationRelativeTo(null);    //centers window location in display
        setVisible(true); //make sure the window is visible
    }

    
    private void buildPanel() {
        //create components
        studentName = new JTextField("Student Name");
        studentID = new JTextField("Student ID");
        voltage = new JTextField("Voltage");        
        locationDescription=  new JTextField("Description of location");
        submit = new JButton("Submit");
        save = new JButton("Save");
        
        
        
        //add listener for the submit button
        submit.addActionListener(new submitButtonListener());
        
        //add listener for the save button
        save.addActionListener(new saveButtonListener());
                
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
        top.add(locationDescription);
        top.add(voltage);
        end.add(submit);
        end.add(save);
        
        //add the sub panels to the main panel
        panel.add(top, BorderLayout.NORTH);
        panel.add(end, BorderLayout.SOUTH);
        panel.add(plate, BorderLayout.CENTER);
    }
    
    public boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            try{
                Double.parseDouble(str);
                return true;
            }
            catch (NumberFormatException ex){
                return false;
            }
        }
    }
    
    public boolean validation(){
        if(!(studentName.getText().equals("")||studentID.getText().equals(""))){
            if(!(isNumber(studentName.getText())||isNumber(locationDescription.getText()))){
                if(isNumber(studentID.getText())||isNumber(voltage.getText())){
                    for(int x=0; x<TABLE_HEIGHT; x++){
                        for(int y=0; y<TABLE_WIDTH; y++){
                            if (grid[x][y].getSelectedItem()==wells[x]+", "+(y+1)){
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * submitButtonListener is an action listener for the submit button
     */
    private class submitButtonListener implements ActionListener{
        /**
         * The actionPreformed method executes when the submit button is clicked
         * @param e the event object
         */
        
        public void actionPerformed(ActionEvent e) {
            if (!(validation())){
                JOptionPane.showMessageDialog(null,"Error:\nplease fill all"
                        + " requiered fields");
            }
            else{
                //magic
            }
        }
    }
    
    /**
     * saveButtonListener is an action listener for the save button
     */
    private class saveButtonListener implements ActionListener{
        /**
         * The actionPreformed method executes when the submit button is clicked
         * @param e the event object
         */
        
        public void actionPerformed(ActionEvent e){
            
        }
    }
}