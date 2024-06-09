/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

import board.Coordinates;
import java.util.ArrayList;
import tiles.Tile;

/**
 *
 * @author fawad
 */
public abstract class Piece {

    protected Coordinates coordinates;
    protected Team team;
    protected ArrayList<Move> legalMoves = new ArrayList();

    public Piece(Coordinates coordinates, Team team) {
        this.coordinates = coordinates;
        this.team = team;
    }

    /**
     * Finds diagonal tiles of the piece w.r.t it's coordinates
     * @param initialCoordinates
     * @return List of Coordinates(row, col)
     */
    protected abstract ArrayList<Coordinates> getDiagonalTiles(Coordinates initialCoordinates);

    /**
     * Finds the next diagonal tile of currently given tile. It is used to get
     * the coordinates of the tile on which the piece will jump in order to kill
     * an enemy team piece
     *
     * @param currentPosition
     * @param initialPosition
     * @return A single Coordinate(row, col)
     */
    protected abstract Coordinates getNextDiagonalTile(Coordinates currentPosition, Coordinates initialPosition);

    /**
     * Calculates all legal moves of the piece depending upon its position
     *
     * @param board
     * @param initialPosition
     * @param checkEmpty
     */
    public abstract void calculateLegalMoves(Tile[][] board, Coordinates initialPosition, boolean checkEmpty);

    public void clearLegalMoves() {
        legalMoves.clear();
    }

    public ArrayList<Move> getLegalMoves() {
        return legalMoves;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Team getTeam() {
        return team;
    }

    protected boolean isValidCoordinates(Coordinates coordinates) {
        if (coordinates.row > 7
                || coordinates.row < 0
                || coordinates.col > 7
                || coordinates.col < 0) {
            return false;
        }

        return true;
    }
    
    protected boolean isEnemyPiece(Team pieceTeam) {
        return this.team != pieceTeam;
    }
}
