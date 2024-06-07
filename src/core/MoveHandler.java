package core;

import java.util.ArrayList;

public class MoveHandler {

    private final Board boardHandler;
    private final ArrayList<Position> legalMoves = new ArrayList();

    public MoveHandler(Board boardHandler) {
        this.boardHandler = boardHandler;
    }

    private ArrayList<Position> getDiagonals(Piece piece, Position initialPosition) {
        ArrayList<Position> diagonals = new ArrayList();
        int row = initialPosition.row;
        int col = initialPosition.col;

        if (piece.isKing()) {
            // Get diagonals for king piece
            int frow = row - 1;
            int srow = row + 1;
            int fcol = col - 1;
            int scol = col + 1;

            Position diagonal1 = new Position(frow, fcol);
            Position diagonal2 = new Position(frow, scol);
            Position diagonal3 = new Position(srow, fcol);
            Position diagonal4 = new Position(srow, scol);
            diagonals.add(diagonal1);
            diagonals.add(diagonal2);
            diagonals.add(diagonal3);
            diagonals.add(diagonal4);
        } else {
            // Get diagonals for regular piece
            int frow;

            if (piece.getColor().equals("WHITE")) {
                frow = row + 1;
            } else {
                frow = row - 1;
            }

            int fcol = col - 1;
            int scol = col + 1;

            Position diagonal1 = new Position(frow, fcol);
            Position diagonal2 = new Position(frow, scol);
            diagonals.add(diagonal1);
            diagonals.add(diagonal2);
        }

        return diagonals;
    }

    private Position getNextCorrespondingDiagonal(Position currentPosition, Position initialPosition) {
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

        Position next_pos = new Position(next_row, next_col);
        return next_pos;
    }

    private void findLegalMoves(Cell[][] board, Piece piece, Position initialPosition, boolean checkEmpty) {
        ArrayList<Position> diagonals = getDiagonals(piece, initialPosition);

        for (Position diagonal : diagonals) {
            // If the diagonal is out of the game board, then ignore it
            if (diagonal.row > 7
                    || diagonal.row < 0
                    || diagonal.col > 7
                    || diagonal.col < 0) {
                continue;
            }

            // If diagonal is empty, add it in legal moves
            Cell cellAtDiagonal = board[diagonal.row][diagonal.col];
            if (cellAtDiagonal.isEmpty()) {
                if (checkEmpty) {
                    legalMoves.add(diagonal);
                }
                continue;
            }

            // If diagonal is not empty and contains piece of opposite color,
            Piece pieceOnDiagonal = cellAtDiagonal.getPiece();

            if (pieceOnDiagonal.getColor().equals(piece.getColor()) == false) {
                // Then get the diagonal next to current diagonal
                Position nextDiagonalPosition = getNextCorrespondingDiagonal(diagonal, initialPosition);
                if (nextDiagonalPosition.row > 7
                        || nextDiagonalPosition.row < 0
                        || nextDiagonalPosition.col > 7
                        || nextDiagonalPosition.col < 0) {
                    continue;
                }

                // Check if this next diagonal is empty or not
                Cell nextDiagonalCell = board[nextDiagonalPosition.row][nextDiagonalPosition.col];
                String nextDiagonalPositionStr = nextDiagonalPosition.toString();
                String initialPositionStr = initialPosition.toString();
                if (nextDiagonalCell.isEmpty()
                        && nextDiagonalPositionStr.equals(initialPositionStr) == false) {
                    legalMoves.add(nextDiagonalPosition);
                    findLegalMoves(board, piece, nextDiagonalPosition, false);
                }

            }

        }
    }

    public ArrayList<Position> getLegalMoves(String positionStr) {
        Cell[][] board = this.boardHandler.getBoard();
        
        String[] splitName = positionStr.split("x");
        int row = Integer.parseInt(splitName[0]);
        int col = Integer.parseInt(splitName[1]);
        
        // Get cell from board
        Cell cell = board[row][col];
        
        // Find legal moves w.r.t cell
        this.findLegalMoves(board, cell.getPiece(), cell.getPosition(), true);
        return legalMoves;
    }

    public void clearLegalMoves() {
        legalMoves.clear();
    }
}
