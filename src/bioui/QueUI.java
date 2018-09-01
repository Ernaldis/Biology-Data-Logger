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
    JPanel queryBox = new JPanel(new GridLayout(4,2));
    JButton stuName = new JButton("Student Name");
    JButton semes = new JButton("Semester");
    JButton dates = new JButton("Dates");
    JButton cells = new JButton("Well Data");
    
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
        
        //add buttons to the grid
        queryBox.add(stuName);
        queryBox.add(semes);
        queryBox.add(dates);
        queryBox.add(cells);
        
        //add pane to the frame
        add(queryBox);
        
        //make it show up
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    
}
