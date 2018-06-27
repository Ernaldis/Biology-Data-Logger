/**
 * This class is the intro GUI for the BioUI project. It allows the user to 
 * select what action they wish to either add data in a new file or modify data
 * in an existing file.
 */
package bioui;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 *07/20/2018
 * @author Jacquelyn
 */
public class Intro extends JFrame
{
    JFrame Intro = new JFrame();
    JPanel Buttons = new JPanel();          //panel for new and addData buttons
    JButton newEntry = new JButton();       //button for new entry
    JButton addData = new JButton();        //button for adding data
    JButton exit = new JButton();           //button to exit program
    JButton query = new JButton();          //button to access queryUI
    private final int WIN_HEIGHT = 150;
    private final int WIN_WIDTH = 300;
    
    /**
     * constructor for the Intro class. Builds the frame, adds the Buttons 
     * panel to the frame, adds the buttons to the Panel, sets pack and makes
     * Frame visible.
     */
    public Intro()
    {   
        //titles buttons
        newEntry.setText("New File");   //set text for newEntry Button
        addData.setText("Add Data to File");    //set text for addData Button
        exit.setText("Quit");           //set text for exit Button
        query.setText("Query");         //set text for queryUI button
        
        //frame sets
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets exit action
        setBackground(Color.LIGHT_GRAY);  //sets background color for frame
        setSize(WIN_WIDTH, WIN_HEIGHT); //sets size of frame
        setLayout(new BorderLayout());  //sets layout for frame
        
        //button event handling
        newEntry.addActionListener(new EntryListener());//see inner class
        addData.addActionListener(new AddListener());   //descriptions for 
        exit.addActionListener(new QuitListener());     //detailed information
        query.addActionListener(new QueryListener());   
        
        //adding content
        Buttons.add(newEntry);  //adds newEntry button to Buttons panel
        Buttons.add(addData);   //adds addData button to Buttons panel
        Buttons.add(query);     //adds queryUI button to Buttons panel
        add(Buttons, BorderLayout.CENTER);  //adds Buttons panel to frame
        add(exit, BorderLayout.SOUTH);  //adds exit button to frame
        
        setLocationRelativeTo(null);
        setVisible(true);   //sets frame to visible for interaction by user
        
    }
    
    /**
     * private inner class for exit button listener
     */
    private class QuitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
    /**
     * private inner class for newEntry button response
     */
    private class EntryListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new InputPane();
        }
    }
    
    /**
     * private inner class for addData button response
     */
    private class AddListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
    
    /**
     * private inner class for query button response. calls and opens the query
     * prompt UI for user interaction.
     */
    private class QueryListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
}
