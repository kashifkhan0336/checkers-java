/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.JFrame;

/**
 *
 * @author fawad
 */
public class App {
    private final JFrame frame = new JFrame();
    private final BoardGUI boardGui = new BoardGUI();
    
    public void start() {
        this.setupFrame();
        boardGui.displayBoard(frame);
    }
    
    private void setupFrame() {
        frame.setTitle("Checker 4.0");
        frame.setSize(480, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
