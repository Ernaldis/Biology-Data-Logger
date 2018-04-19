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
    private final int WINDOW_WIDTH=400;
    private final int TABLE_WIDTH=12;
    private final int TABLE_HEIGHT=8;
    
    //declare choices for the dropdown menu
    String[] dataStates = {"No data", "Partial change", "Change", "No change"};
    
    //Letters to denote wells
    String[] wells = {"A", "B", "C", "D", "E", "F", "G", "H"};
    
    /**
     * Constructor
     */
    public InputPane(){
        setTitle("Experiment form");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        pack();
        setVisible(true);
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
                
        //create panel
        panel = new JPanel();
        
        //set layout
        panel.setLayout(new BorderLayout());
        
        //make panels for the individual sections
        JPanel top = new JPanel();
        JPanel plate = new JPanel();
        JPanel[] table = new JPanel[3];
        JPanel[] labelList = new JPanel[3];
        JPanel labels = new JPanel(new GridLayout(3,1,0,20));
        JLabel[] wellName = new JLabel[8];
        JPanel end = new JPanel();
        
        //set up the three data tables
        for (int i=0; i<3; i++){
            table[i]=new JPanel();
            table[i].setLayout(new GridLayout(TABLE_HEIGHT,TABLE_WIDTH));
            plate.add(table[i]);
            JComboBox[][] grid=new JComboBox[TABLE_HEIGHT][TABLE_WIDTH];
            for(int x=0; x<TABLE_HEIGHT; x++){
                for(int y=0; y<TABLE_WIDTH; y++){
                    grid[x][y] = new JComboBox(dataStates);
                    table[i].add(grid[x][y]);
                }
            }
        }
        
        //set up lables for the wells
        for (int n=0; n<3; n++){
            labelList[n] = new JPanel();
            labelList[n].setLayout(new GridLayout(8,1));
            for (int w=0; w<8; w++){
                wellName[w] = new JLabel(wells[w]);
                labelList[n].add(wellName[w]);
            }
            labels.add(labelList[n]);
        }
        
        //set layout for the plate's table
        plate.setLayout(new GridLayout(3,1,0,20));
        
        //add the components to the sub panels
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
        panel.add(labels, BorderLayout.WEST);
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