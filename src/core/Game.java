
package core;

public class Game {
    private Board boardHandler = new Board();
    
    public void setupBoard() {
        boardHandler.createBoard();
    }
    
    public void setupPlayers() {}
    
    public void startGame() {}
    public void checkWinner() {}
    public void switchTurns() {}
    public void endGame() {}
    public void restartGame() {}
}
