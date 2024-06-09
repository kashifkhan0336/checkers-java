package gui;

import board.Board;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import pieces.Move;
import tiles.Tile;

public class BoardGUI {

    private final Board board = new Board();
    private final JPanel boardPanel;

    public BoardGUI(JPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
    
    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                
                Tile tile = board.getTile(i, j);
                TileGUI tileGui;
                
                if (tile.isEmpty()) {
                    tileGui = new TileGUI(tile);
                } else {
                    tileGui = new TileGUI(tile, new PieceGUI(tile.getPiece(), this));
                }
                boardPanel.add(tileGui);
            }
        }
        
        boardPanel.revalidate();
        boardPanel.repaint();
    }
    
    public void reRenderBoard() {
        this.boardPanel.removeAll();
        this.displayBoard();
    }
    
    public void displayLegalMoves(ArrayList<Move> legalMoves) {
        for (Component component : boardPanel.getComponents()) {
            for (Move legalMove : legalMoves) {
                TileGUI tileGui = (TileGUI) component;
                if(tileGui.matchCoordinates(legalMove.toTileCoordinates)) {
                    tileGui.setBackground(Color.green);
                }
            }
        }
        
        boardPanel.revalidate();
        boardPanel.repaint();
    }
    
}
