/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

    public PlayerGUI(JPanel playersPanel) {
        this.playersPanel = playersPanel;
    }
    
    public void displayPlayers(Player p1, Player p2) {
        this.playersPanel.add(this.create(p1), BorderLayout.EAST);
        this.playersPanel.add(this.create(p2), BorderLayout.WEST);
        this.playersPanel.revalidate();
        this.playersPanel.repaint();
    }
    
    private JPanel create(Player p) {
        JPanel playerGui = new JPanel(new GridLayout(0,1));
        JLabel nameLabel = new JLabel();
        JLabel scoreLabel = new JLabel();
        JLabel timerLabel = new JLabel();
        JLabel teamLabel = new JLabel();
        
        nameLabel.setText(p.getName());
        scoreLabel.setText("Score: " + String.valueOf(p.getScore()));
        timerLabel.setText("Timer: " + String.valueOf(30));
        teamLabel.setText("Team: " +  p.getTeam());
        
        playerGui.setPreferredSize(new Dimension(100, 50));
        playerGui.add(nameLabel);
        playerGui.add(teamLabel);
        playerGui.add(timerLabel);
        playerGui.add(scoreLabel);
        
        return playerGui;
    }
    
}
