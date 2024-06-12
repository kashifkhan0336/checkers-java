/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import board.Coordinates;
import javax.swing.JPanel;

/**
 *
 * @author fawad
 */
public class TileGUI extends JPanel {
    private Coordinates coordinates;

    public TileGUI(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    
    public boolean matchCoordinates(Coordinates c) {
        return this.coordinates.toString().equals(c.toString());
    }
    
}
