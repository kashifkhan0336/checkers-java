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
class Move {
    public Coordinates toTileCoordinate;
    public Coordinates fromTileCoordinate;

    public Move(Coordinates toTileCoordinate, Coordinates fromTileCoordinate) {
        this.toTileCoordinate = toTileCoordinate;
        this.fromTileCoordinate = fromTileCoordinate;
    }
    
}
