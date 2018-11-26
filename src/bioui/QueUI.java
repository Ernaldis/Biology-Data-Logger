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
class QueUI extends JFrame
{

    //JLabel date = new JLabel("Click to select date range");

    /*
    constructor
    */
    QueUI()
    {
        //set size and default button on close
        //set dimensions for size of frame
        int win_WIDTH = 450;
        int win_HEIGHT = 200;
        setSize(win_WIDTH, win_HEIGHT);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //add listeners to the buttons
        //JButton dates = new JButton("Dates"); //increment grid layout by 1 when ready to use this function
        JButton cells = new JButton("Well Data");
        cells.addActionListener((ActionEvent e) -> new LayoutGrid());
        JButton stuName = new JButton("Student Name");
        stuName.addActionListener((ActionEvent e) -> {
            
        });
        JButton semes = new JButton("Semester");
        semes.addActionListener((ActionEvent e) -> {
            
        });
        
        //add buttons and labels to the grid
        JPanel queryBox = new JPanel(new GridLayout(3, 2));
        queryBox.add(stuName);  //JButton
        //create labels to explain button function
        JLabel student = new JLabel("LSC Username");
        queryBox.add(student);  //JLabel
        queryBox.add(semes);    //JButton
        JLabel semester = new JLabel("Choose a semester");
        queryBox.add(semester); //JLabel
        //queryBox.add(dates);  //for use later
        //queryBox.add(date);   //for use later
        queryBox.add(cells);    //JButton
        JLabel cell = new JLabel("Click to select specific well data");
        queryBox.add(cell);     //JLabel
        
        //add pane to the frame
        add(queryBox);
        
        //make it show up
        setVisible(true);
        setLocationRelativeTo(null);
        //create frame, pane and buttons
        new JFrame();
    }
}
