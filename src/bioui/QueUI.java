/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Jacquelyn
 */
public class QueUI extends JFrame
{
    //create frame, pane and buttons
    JFrame Que = new JFrame();
    JPanel queryBox = new JPanel(new GridLayout(3,2)); 
    JButton stuName = new JButton("Student Name");
    JButton semes = new JButton("Semester");
    //JButton dates = new JButton("Dates"); //increment grid layout by 1 when ready to use this function
    JButton cells = new JButton("Well Data");
    
    //create labels to explain button function
    JLabel student = new JLabel("LSC Username");
    JLabel semester = new JLabel("Choose a semester");
    JLabel cell = new JLabel("Click to select specific well data");
    //JLabel date = new JLabel("Click to select date range");
    
    //set dimensions for size of frame
    final private int win_WIDTH = 450;
    final private int win_HEIGHT = 200;
    
    /*
    constructor
    */
    public QueUI()
    {
        //set size and default button on close
        setSize(win_WIDTH, win_HEIGHT);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //add listeners to the buttons
        cells.addActionListener((ActionEvent e) -> {
            LayoutGrid layoutGrid = new LayoutGrid();
        });
        stuName.addActionListener((ActionEvent e) -> {
            
        });
        semes.addActionListener((ActionEvent e) -> {
            
        });
        
        //add buttons and labels to the grid
        queryBox.add(stuName);  //JButton
        queryBox.add(student);  //JLabel
        queryBox.add(semes);    //JButton
        queryBox.add(semester); //JLabel
        //queryBox.add(dates);  //for use later
        //queryBox.add(date);   //for use later
        queryBox.add(cells);    //JButton
        queryBox.add(cell);     //JLabel
        
        //add pane to the frame
        add(queryBox);
        
        //make it show up
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
