/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pieces;

import board.Board;
import board.Coordinates;
import java.util.ArrayList;
import tiles.Tile;

/**
 *
 * @author fawad
 */
public class RegularPiece extends Piece {
    
    private static final Board board = new Board();

    public RegularPiece(Coordinates coordinates, Team team) {
        super(coordinates, team);
    }

    @Override
    protected ArrayList<Coordinates> getDiagonalTiles(Coordinates initialCoordinates) {
        ArrayList<Coordinates> diagonals = new ArrayList();

        // Get diagonals for regular piece
        int frow;

        if (this.team == Team.WHITE) {
            frow = initialCoordinates.row + 1;
        } else {
            frow = initialCoordinates.row - 1;
        }

        int fcol = initialCoordinates.col - 1;
        int scol = initialCoordinates.col + 1;

        Coordinates diagonal1 = new Coordinates(frow, fcol);
        Coordinates diagonal2 = new Coordinates(frow, scol);
        diagonals.add(diagonal1);
        diagonals.add(diagonal2);

        return diagonals;
    }

    @Override
    protected Coordinates getNextDiagonalTile(Coordinates currentPosition, Coordinates initialPosition) {
        int next_row;
        int next_col;

        int currentRow = currentPosition.row;
        int currentCol = currentPosition.col;
        int initialRow = initialPosition.row;
        int initialCol = initialPosition.col;

        if (currentRow < initialRow && currentCol < initialCol) {
            next_row = currentRow - 1;
            next_col = currentCol - 1;
        } else if (currentRow < initialRow && currentCol > initialCol) {
            next_row = currentRow - 1;
            next_col = currentCol + 1;
        } else if (currentRow > initialRow && currentCol < initialCol) {
            next_row = currentRow + 1;
            next_col = currentCol - 1;
        } else {
            next_row = currentRow + 1;
            next_col = currentCol + 1;
        }

        return new Coordinates(next_row, next_col);

    }

    @Override
    public void calculateLegalMoves(Tile[][] gameBoard, Coordinates initialPosition, boolean checkEmpty) {        
        // Calculate new legal moves
        ArrayList<Coordinates> diagonals = this.getDiagonalTiles(initialPosition);
        for (Coordinates diagonal : diagonals) {
            
            // Validate  diagonal tile
            if (this.isValidCoordinates(diagonal) == false) {
                continue;
            }

            // If diagonal is empty, add it in legal moves
            // Here, checkEmpty is used to make sure that we don't add any
            // empty tiles in legal moves when we are calculating legal moves 
            // recursively, because it will be calculating moves which could only
            // be made when a piece steps over its enemy piece and during this
            // piece is not allowed to move to an empty tile which is diagonal to its
            // current tile, instead it can only step over other enemy pieces if
            // possible
            Tile diagonalTile = board.getTile(diagonal);
            if (diagonalTile.isEmpty()) {
                if (checkEmpty) {
                    Move move = new Move(diagonal, this.coordinates);
                    legalMoves.add(move);
                }
                continue;
            }

            // If diagonal is not empty and contains an enemy piece, then get
            // the tile next to current diagonal tile, if that next tile
            // is empty then add it to legal moves because our piece can jump over
            // the enemy piece
            Piece pieceOnDiagonal = diagonalTile.getPiece();

            if (pieceOnDiagonal.isEnemyPiece(this.team)) {
                Coordinates nextTileCoordinates = this.getNextDiagonalTile(diagonal, initialPosition);
                if (this.isValidCoordinates(nextTileCoordinates) == false) {
                    continue;
                }
                
                Tile nextTile = board.getTile(nextTileCoordinates);
                if (nextTile.isEmpty()
                        && nextTile.matchCoordinates(initialPosition) == false) {
                    Move move = new Move(nextTileCoordinates, initialPosition);
                    legalMoves.add(move);
                    calculateLegalMoves(gameBoard, nextTileCoordinates, false);
                }

            }

        }
    }

}
