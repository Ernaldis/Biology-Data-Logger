/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioui;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jacquelyn
 */
public class LayoutGrid extends JFrame 
{
        public JPanel box;
        public JButton[][] button = new JButton[8][12];//Labels to nest checkboxes in
        public final int TABLE_HEIGHT = 8;
        public final int TABLE_WIDTH = 12;
        public final int WIN_HEIGHT = 300;
        public final int WIN_WIDTH = 1000;
        //Letters to denote wells
        public String[] wells = {"A", "B", "C", "D", "E", "F", "G", "H"};
/**
 * constructor
 */ 
    public LayoutGrid() 
        {
            setTitle("Well selection");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(WIN_WIDTH, WIN_HEIGHT);
            
            buildPanel();
            
            add(box);
            setLocationRelativeTo(null);
            //pack();
            setVisible(true);
        }
    
    public void buildPanel()
    {
        box = new JPanel(new GridLayout(TABLE_HEIGHT,TABLE_WIDTH));
        box.setBorder(BorderFactory.createTitledBorder("Select Buttons to compare well Data"));
        
    //loop through the table array
            for(int x=0; x<TABLE_HEIGHT; x++)
            {
                for(int y=0; y<TABLE_WIDTH; y++)
                {
                    button[x][y] = new JButton(wells[x]+", "+(y+1));
                    button[x][y].addActionListener(new ButtonListener());
                    box.add(button[x][y]);                   
                }
            }
    }

    private class ButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e)
            {
                Font font = new Font("Serif", Font.BOLD, 20);
                if(e.getSource() instanceof JButton){
                    ((JButton)e.getSource()).setFont(font);
                    //create secondary boolean array called clicked to hold boolean values
                    //for the buttons being clicked or not
                }
            }
    }
    
    
}
