
package core;


public class Piece {
    private Position position;
    private boolean king;
    private final String color;

    public Piece(String color, Position position) {
        this.position = position;
        this.color = color;
        this.king = false;
    }

    public Position getPosition() {
        return position;
    }

    public String getColor() {
        return color;
    }

    public boolean isKing() {
        return king;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setKing(boolean king) {
        this.king = king;
    }
}
