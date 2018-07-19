/**
 * This class will allow the user to make queries of the data stored in SQL
 */
package bioui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import org.jdatepicker.*;
/**
 *06242018
 * @author Jacquelyn
 */
public class QueryUI extends JFrame
{
    //labels for field input
    JLabel dateFrom = new JLabel("Date From:"); 
    JLabel dateTo = new JLabel("Date To:");
    JLabel studentID = new JLabel("Student ID:");
    JLabel location = new JLabel("Location:");
    JLabel voltageRange = new JLabel("Voltage:");
    
    //fields for input to query
    JTextField dateFrm = new JTextField("mm/dd/yy");
    JTextField dateTO = new JTextField("mm/dd/yy");
    JTextField studID = new JTextField(10);
    String[] locate = {"N/A","1", "2", "3"};
    JComboBox loc = new JComboBox(locate);
    JTextField voltage = new JTextField("xx.xxx", 6);
    
    
    //buttons for submit and quit
    JButton submit = new JButton("Submit");
    JButton quit = new JButton("Quit");
    
    //panel creation
    JPanel query = new JPanel();
    JPanel studInfo = new JPanel();
    JPanel locationInfo = new JPanel();
    JPanel volt = new JPanel();
    JPanel sub = new JPanel();
    
    //set dimensions for size of frame
    final private int win_WIDTH = 450;
    final private int win_HEIGHT = 200;
    
    public QueryUI()
    {
        //assign layout manager and set frame size
        setLayout(new BorderLayout());
        setSize(win_WIDTH, win_HEIGHT);
        
        //set default close operator
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        //assign labels and text fields to locations in layout
        query.add(dateFrom);
        query.add(dateFrm);
        query.add(dateTo);
        query.add(dateTO);
        add(query, BorderLayout.NORTH);
        
        studInfo.add(studentID);
        studInfo.add(studID);
        add(studInfo, BorderLayout.WEST);
        
        locationInfo.add(location);
        locationInfo.add(loc);
        add(locationInfo, BorderLayout.CENTER);
        
        volt.add(voltageRange);
        volt.add(voltage);
        add(volt, BorderLayout.EAST);
        
        sub.add(submit);
        sub.add(quit);
        add(sub, BorderLayout.SOUTH);
        
        //add action listeners to buttons
        submit.addActionListener(new SubmitListener());
        quit.addActionListener(new QuitListener());
        
        //set frame location in the display area
        setLocationRelativeTo(null);
        //make it known
        setVisible(true);
    }
    
    /**
     * This private inner class implements ActionListener and responds to the 
     * button event for a submission towards a query of the SQL database    
    */
    private class SubmitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
    
    /**
     * This private inner class implements ActionListener and responds to the 
     * button event for the quit button.
     */
    private class QuitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
}
