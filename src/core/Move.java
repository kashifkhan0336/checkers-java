
package core;


public class Move {
    public int toRow;
    public int toCol;
    public int fromRow;
    public int fromCol;

    public Move(int toRow, int toCol, int fromRow, int fromCol) {
        this.toRow = toRow;
        this.toCol = toCol;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
    }
}
