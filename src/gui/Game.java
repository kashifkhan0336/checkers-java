package gui;


import board.Board;
import pieces.Team;
import player.Player;
import tiles.Tile;


public class Game {
    public final Board board = new Board();
    public final Player playerOne = new Player("Player 1", Team.RED);
    public final Player playerTwo = new Player("Player 2", Team.WHITE);
    private int turn = 1;
    
    public void switchTurn() {
        if (this.turn == 1) {
            this.turn = 2;
        } else {
            this.turn = 1;
        }
    }
    
    public Player checkWinner() {
        if (this.hasLostAllPieces(playerOne)) {
            return playerTwo;
        } else if (this.hasLostAllPieces(playerTwo)) {
            return playerOne;
        }
        
        return null;
    }
    
    private boolean hasLostAllPieces(Player p) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile tile = board.getTile(i, j);
                if (tile.isEmpty() == false && tile.getPiece().getTeam() == p.getTeam()) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public int getTurn() {
        return turn;
    }
    
}
