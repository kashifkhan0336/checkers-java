/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import board.Board;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author fawad
 */
public class App {
    private final JFrame frame = new JFrame();
    private final JPanel boardPanel = new JPanel(new GridLayout(8,8));
    private final JPanel playersPanel = new JPanel();
    private final Board board = new Board();
    
    private final BoardGUI boardGUI = new BoardGUI(boardPanel);
    
    public void start() {
        board.create();
        this.createGameWindow();
        boardGUI.displayBoard();
    }
    
    private void createGameWindow() {
        frame.setTitle("Checker 4.0");
        frame.setSize(480, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.add(boardPanel);
        frame.setVisible(true);
    }    
}
