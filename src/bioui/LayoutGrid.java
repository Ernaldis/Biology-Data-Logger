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
public final class LayoutGrid extends JFrame 
{
        private JPanel box;
        private final int TABLE_HEIGHT = 8;
        private final int TABLE_WIDTH = 12;
        private final int WIN_HEIGHT = 300;
        private final int WIN_WIDTH = 1000;
        //Letters to denote wells
        private final String[] wells = {"A", "B", "C", "D", "E", "F", "G", "H"};
        //Labels to nest checkboxes in
        private final JButton[][] buttonArry = new JButton[TABLE_HEIGHT][TABLE_WIDTH];
        //Boolean array to denote if a button is clicked or not
        private final boolean[][] clicked = new boolean[TABLE_HEIGHT][TABLE_WIDTH];
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
                    buttonArry[x][y] = new JButton(wells[x]+", "+(y+1));
                    buttonArry[x][y].addActionListener((ActionEvent e) -> {
                        Font bold = new Font("Serif", Font.BOLD, 20);
                        Font normal = new Font("SansSerif", Font.BOLD, 12);
                        JButton button = (JButton) e.getSource();

                        if(!button.getFont().equals(bold)){
                            button.setFont(bold);
                            //toggle value in clicked[][]
                        } else {
                            button.setFont(normal);
                        }
                    });
                    box.add(buttonArry[x][y]);                   
                }
            }
    }

}