 /*
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

    /**
     * constructor for the Intro class. Builds the frame, adds the Buttons 
     * panel to the frame, adds the buttons to the Panel, sets pack and makes
     * Frame visible.
     */
    public Intro()
    {
        setTitle("Menu");
        //titles buttons
        //button for new entry
        JButton newEntry = new JButton();
        newEntry.setText("New File");   //set text for newEntry Button
        //button for adding data
        JButton addData = new JButton();
        addData.setText("Add Data to File");    //set text for addData Button
        //button to exit program
        JButton exit = new JButton();
        exit.setText("Quit");           //set text for exit Button
        //button to access queryUI
        JButton query = new JButton();
        query.setText("Query");         //set text for queryUI button
        
        //frame sets
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets exit action
        setBackground(Color.LIGHT_GRAY);  //sets background color for frame
        int WIN_HEIGHT = 150;
        int WIN_WIDTH = 300;
        setSize(WIN_WIDTH, WIN_HEIGHT); //sets size of frame
        setLayout(new BorderLayout());  //sets layout for frame
        
        //button event handling
        newEntry.addActionListener((ActionEvent e) -> new InputPane());
        addData.addActionListener((ActionEvent e) -> {
            //submit button code
        });
        exit.addActionListener((ActionEvent) -> System.exit(0));
        query.addActionListener((ActionEvent e) -> new QueUI());
        
        //adding content
        //panel for new and addData buttons
        JPanel buttons = new JPanel();
        buttons.add(newEntry);  //adds newEntry button to Buttons panel
        buttons.add(addData);   //adds addData button to Buttons panel
        buttons.add(query);     //adds queryUI button to Buttons panel
        add(buttons, BorderLayout.CENTER);  //adds Buttons panel to frame
        add(exit, BorderLayout.SOUTH);  //adds exit button to frame
        
        setLocationRelativeTo(null);
        setVisible(true);   //sets frame to visible for interaction by user
        new JFrame();
    }
}
