/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiles;

import board.Coordinates;
import pieces.Piece;

/**
 *
 * @author fawad
 */
public class Tile {

    protected Colors color;
    protected Coordinates coordinates;
    protected Piece piece;

    public Tile(Colors color, Coordinates coordinates, Piece piece) {
        this.color = color;
        this.coordinates = coordinates;
        this.piece = piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Colors getColor() {
        return this.color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}
