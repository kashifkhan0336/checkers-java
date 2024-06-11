/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import player.Player;

/**
 *
 * @author fawad
 */
public class PlayerGUI {
    private final JPanel playersPanel;
    private final Player p1 = new Player("Fawad");
    private final Player p2 = new Player("Moiz");
    

    public PlayerGUI(JPanel playersPanel) {
        this.playersPanel = playersPanel;
    }
    
    public void displayPlayers() {
        this.playersPanel.add(this.create(p1), BorderLayout.EAST);
        this.playersPanel.add(this.create(p2), BorderLayout.WEST);
        this.playersPanel.revalidate();
        this.playersPanel.repaint();
    }
    
    private JPanel create(Player p) {
        JPanel playerGui = new JPanel(new BorderLayout());
        JLabel name = new JLabel();
        JLabel score = new JLabel();
        JLabel timer = new JLabel();
        
        name.setText(p.getName());
        score.setText("Score: " + String.valueOf(p.getScore()));
        timer.setText("Timer: " + String.valueOf(30));
        
        playerGui.setPreferredSize(new Dimension(100, 50));
        playerGui.add(name, BorderLayout.NORTH);
        playerGui.add(score, BorderLayout.WEST);
        playerGui.add(timer, BorderLayout.SOUTH);
        
        return playerGui;
    }
    
}
