/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import board.Coordinates;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import static tiles.Colors.BLACK;
import static tiles.Colors.WHITE;
import tiles.Tile;

/**
 *
 * @author fawad
 */
public class TileGUI extends JPanel {
    private final Coordinates coordinates;

    public TileGUI(Tile tile) {
        this.setSize(60, 60);
        this.coordinates = tile.getCoordinates();
        
        switch (tile.getColor()) {
            case WHITE -> {
                this.setBackground(Color.white);
            }
            case BLACK -> {
                this.setBackground(Color.black);
            }
        }
    }
    
    public TileGUI(Tile tile, JButton pieceGui) {
        this.setSize(60, 60);
        this.coordinates = tile.getCoordinates();
        
        switch (tile.getColor()) {
            case WHITE -> {
                this.setBackground(Color.white);
            }
            case BLACK -> {
                this.setBackground(Color.black);
            }
        }
        
        this.add(pieceGui);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    
    public boolean matchCoordinates(Coordinates coordinates) {
        return this.coordinates.toString().equals(coordinates.toString());
    }
    
}
