package gui;

import board.Board;
import java.util.ArrayList;
import pieces.Move;
import pieces.Team;
import player.Player;
import tiles.Tile;

public class Game {

    public final Board board = new Board();
    public final Player playerOne = new Player("Player 1", Team.RED);
    public final Player playerTwo = new Player("Player 2", Team.WHITE);
    private Team turn = Team.RED;

    public void switchTurn() {
        if (this.turn == Team.RED) {
            this.turn = Team.WHITE;
        } else {
            System.out.println("switch to red");
            this.turn = Team.RED;
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

    public Team getTurn() {
        return turn;
    }

    private void findConnectedMove(Move selectedMove, ArrayList<Move> connectedMovesArrray, ArrayList<Move> legalMoves) {
        for (Move legalMove : legalMoves) {
            String str1 = legalMove.toTileCoordinates.toString();
            String str2 = selectedMove.fromTileCoordinates.toString();
            if (str1.equals(str2)) {
                connectedMovesArrray.addFirst(legalMove);
                findConnectedMove(legalMove, connectedMovesArrray, legalMoves);
            }
        }
    }

    public ArrayList<Move> getConnectedMoves(Move selectedMove, ArrayList<Move> legalMoves) {
        ArrayList<Move> connectedMoves = new ArrayList();
        connectedMoves.add(selectedMove);
        this.findConnectedMove(selectedMove, connectedMoves, legalMoves);
        return connectedMoves;
    }

}
