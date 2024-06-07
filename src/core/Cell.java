
package core;

public class Cell {
    private Piece piece;
    private final Position position;
    private final String color;

    public Cell(Position position, String color) {
        this.position = position;
        this.color = color;
        this.piece = null;
    }
    
    public Cell(Position position, Piece piece, String color) {
        this.position = position;
        this.piece = piece;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getColor() {
        return color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public boolean isEmpty() {
        return this.piece == null;
    }
    
    
}
