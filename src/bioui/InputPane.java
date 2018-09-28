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
    private JTextField studentFirstName; // the student's first name
    private JTextField studentLastName; // the student's last name
    private JTextField student_user; // the student's unique username
    private JTextField locationDescription; // description of where it came from
    private JTextField voltage; //the electrical output of the experiment
    private JButton submit; // for a button to submit the completed form
    private JButton Return; // save plate data
    private final int WINDOW_HEIGHT=300;
    private final int WINDOW_WIDTH=1000;
    private final int TABLE_WIDTH=12;
    private final int TABLE_HEIGHT=8;
    JComboBox[][] grid=new JComboBox[TABLE_HEIGHT][TABLE_WIDTH]; //make an array of combo boxes with the same dimantions as the table
    int[][] arryData = new int[TABLE_HEIGHT][TABLE_WIDTH];
    
    
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
        studentFirstName = new JTextField("First Name");
        studentLastName = new JTextField("Last Name");
        student_user = new JTextField("LoneStar Username");
        voltage = new JTextField("Voltage");
        locationDescription=  new JTextField("Location");
        submit = new JButton("Submit");
        Return = new JButton("Return");
        
        
        
        //add listener for the submit button
        submit.addActionListener(new submitButtonListener());
        
        //add listener for the save button
        Return.addActionListener(new returnButtonListener());
                
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
        top.add(studentFirstName);
        top.add(studentLastName);
        top.add(student_user);
        top.add(locationDescription);
        top.add(voltage);
        end.add(submit);
        end.add(Return);
        
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
        if(!(studentFirstName.getText().equals("")||student_user.getText().equals("")
                ||studentFirstName.getText().equals(""))){
            if(!(isNumber(studentFirstName.getText())||isNumber(locationDescription.getText()))
                    ||isNumber(studentLastName.getText())){
                if(isNumber(student_user.getText())||isNumber(voltage.getText())){
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
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(validation())){
                JOptionPane.showMessageDialog(null,"Error:\nplease fill all"
                        + " requiered fields");
            }
            else {
                for(int x=0; x<TABLE_HEIGHT; x++){
                    for(int y=0; y<TABLE_WIDTH; y++){
                        if (grid[x][y].getSelectedItem()=="No data"){
                            arryData[x][y]=-1;
                        }
                        else if (grid[x][y].getSelectedItem()=="Negative"){
                            arryData[x][y]=0;
                        }
                        else if (grid[x][y].getSelectedItem()=="Borderline"){
                            arryData[x][y]=1;
                        }
                        else if (grid[x][y].getSelectedItem()=="Positive"){
                            arryData[x][y]=2;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * saveButtonListener is an action listener for the save button
     */
    private class returnButtonListener implements ActionListener{
        /**
         * The actionPreformed method executes when the submit button is clicked
         * @param e the event object
         */
        
        @Override
        public void actionPerformed(ActionEvent e){
            Intro intro = new Intro();
        }
    }
}