
package core;

public class Player {
    private final String myPieceColor;
    private final boolean myTurn;

    public Player(String myPieceColor, boolean myTurn) {
        this.myPieceColor = myPieceColor;
        this.myTurn = myTurn;
    }

    public String getMyPieceColor() {
        return myPieceColor;
    }

    public boolean isMyTurn() {
        return myTurn;
    }
    
    public void makeMove(Move move, Board board) {}
}
