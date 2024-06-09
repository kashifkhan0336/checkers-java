/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

import board.Coordinates;

/**
 *
 * @author fawad
 */
public class Move {
    public Coordinates toTileCoordinates;
    public Coordinates fromTileCoordinates;

    public Move(Coordinates toTileCoordinates, Coordinates fromTileCoordinates) {
        this.toTileCoordinates = toTileCoordinates;
        this.fromTileCoordinates = fromTileCoordinates;
    }
    
}
