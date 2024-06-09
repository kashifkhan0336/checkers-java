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
public class KingPiece extends Piece {

    public KingPiece(Coordinates coordinates, Team team) {
        super(coordinates, team);
    }
    
    @Override
    protected ArrayList<Coordinates> getDiagonalTiles() {
        ArrayList<Coordinates> diagonals = new ArrayList();

            // Get diagonals for king piece
            int frow = this.coordinates.row - 1;
            int srow = this.coordinates.row + 1;
            int fcol = this.coordinates.col - 1;
            int scol = this.coordinates.col + 1;

            Coordinates diagonal1 = new Coordinates(frow, fcol);
            Coordinates diagonal2 = new Coordinates(frow, scol);
            Coordinates diagonal3 = new Coordinates(srow, fcol);
            Coordinates diagonal4 = new Coordinates(srow, scol);
            diagonals.add(diagonal1);
            diagonals.add(diagonal2);
            diagonals.add(diagonal3);
            diagonals.add(diagonal4);

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
    public void calculateLegalMoves(Tile[][] board, Coordinates initialPosition, boolean checkEmpty) {
        ArrayList<Coordinates> diagonals = this.getDiagonalTiles();
        System.out.println(diagonals);

        for (Coordinates diagonal : diagonals) {
            // If the diagonal is out of the game board, then ignore it
            if (diagonal.row > 7
                    || diagonal.row < 0
                    || diagonal.col > 7
                    || diagonal.col < 0) {
                continue;
            }

            // If diagonal is empty, add it in legal moves
            Tile cellAtDiagonal = board[diagonal.row][diagonal.col];
            if (cellAtDiagonal.isEmpty()) {
                if (checkEmpty) {
                    Move move = new Move(diagonal, this.coordinates);
                    legalMoves.add(move);
                }
                continue;
            }

            // If diagonal is not empty and contains piece of opposite color,
            Piece pieceOnDiagonal = cellAtDiagonal.getPiece();

            if (pieceOnDiagonal.team != this.team) {
                // Then get the diagonal next to current diagonal
                Coordinates nextDiagonalCoordinates = this.getNextDiagonalTile(diagonal, initialPosition);
                if (nextDiagonalCoordinates.row > 7
                        || nextDiagonalCoordinates.row < 0
                        || nextDiagonalCoordinates.col > 7
                        || nextDiagonalCoordinates.col < 0) {
                    continue;
                }

                // Check if this next diagonal is empty or not
                Tile nextDiagonalCell = board[nextDiagonalCoordinates.row][nextDiagonalCoordinates.col];
                String nextDiagonalPositionStr = nextDiagonalCoordinates.toString();
                String initialPositionStr = initialPosition.toString();
                if (nextDiagonalCell.isEmpty()
                        && nextDiagonalPositionStr.equals(initialPositionStr) == false) {
                    Move move = new Move(nextDiagonalCoordinates, initialPosition);
                    legalMoves.add(move);
                    calculateLegalMoves(board, nextDiagonalCoordinates, false);
                }

            }
        }
    }
    
}
