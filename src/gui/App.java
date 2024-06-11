/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import board.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author fawad
 */
public class App {
    private final JFrame frame = new JFrame();
    private final JPanel boardPanel = new JPanel();
    private final JPanel playersPanel = new JPanel();
    private final Board board = new Board();
    
    private final BoardGUI boardGUI = new BoardGUI(boardPanel);
    private final PlayerGUI playerGUI = new PlayerGUI(playersPanel);
    
    public void start() {
        this.createGameWindow();
        this.setupBoardPanel();
        this.setupPlayerPanel();
        
        board.create();
        boardGUI.displayBoard();
        playerGUI.displayPlayers();
    }
    
    private void createGameWindow() {
        frame.setTitle("Checkers");
        frame.setSize(480, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void setupBoardPanel() {
        boardPanel.setLayout(new GridLayout(8,8));
        boardPanel.setPreferredSize(new Dimension(480, 480));
        frame.add(boardPanel, BorderLayout.NORTH);
    }
    
    private void setupPlayerPanel() {
        playersPanel.setLayout(new BorderLayout());
        playersPanel.setPreferredSize(new Dimension(480, 50));
        frame.add(playersPanel, BorderLayout.SOUTH);
    }
}
