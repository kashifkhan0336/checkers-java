package core;

public class Board {

    private final Cell[][] board = new Cell[8][8];

    public void createBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                // If the box number is even, create a white cell
                if ((i + j) % 2 == 0) {
                    board[i][j] = new Cell(new Position(i, j), "WHITE");
                } 
                
                // Create black cells
                else {
                    // Create cells with red piece for rows 0,1,2
                    if (i >= 0 && i <= 2) {
                        board[i][j] = createWhitePieceCell(i, j);
                    }
                    
                    // Create cells with white piece for rows 5,6,7
                    else if (i >= 5 && i <= 7) {
                        board[i][j] = createRedPieceCell(i, j);
                    }
                    
                    // Create empty black boxes for rest of the rows
                    else {
                        board[i][j] = new Cell(new Position(i, j), "BLACK");
                    }
                }
            }
        }
    }

    public Cell createRedPieceCell(int i, int j) {
        Position pos = new Position(i, j);
        Cell redPieceCell = new Cell(pos, new Piece("RED", pos), "BLACK");
        return redPieceCell;
    }

    public Cell createWhitePieceCell(int i, int j) {
        Position pos = new Position(i, j);
        Cell whitePieceCell = new Cell(pos, new Piece("WHITE", pos), "BLACK");
        return whitePieceCell;
    }

    public void updateBoard(Move move) {
    }

    public Cell[][] getBoard() {
        return board;
    }
}
