package gui;

import board.Board;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import pieces.Move;
import tiles.Tile;

public class BoardGUI {
    private final JPanel boardPanel;

    public BoardGUI(JPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
    
    public void displayBoard(Tile[][] gameBoard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                
                Tile tile = gameBoard[i][j];
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
    
//    public void reRenderBoard() {
//        this.boardPanel.removeAll();
//        this.displayBoard();
//    }
    
    private void hidePreviousLegalMoves() {
//        for (Component component : boardPanel.getComponents()) {
//            if (component.getBackground().equals(Color.green)){
//                component.setBackground(Color.black);
//            }
//        }
    }
    
    public void displayLegalMoves(ArrayList<Move> legalMoves) {
//        this.hidePreviousLegalMoves();
//        
//        for (Component component : boardPanel.getComponents()) {
//            for (Move legalMove : legalMoves) {
//                TileGUI tileGui = (TileGUI) component;
//                if(tileGui.matchCoordinates(legalMove.toTileCoordinates)) {
//                    tileGui.setBackground(Color.green);
//                    // add an event listener that updates the board state when
//                    // player makes a move
//                    tileGui.addMouseListener(new MouseListener() {
//                        @Override
//                        public void mouseClicked(MouseEvent e) {
//                            board.makeMove(legalMove);
//                            reRenderBoard();
//                        }
//
//                        @Override
//                        public void mousePressed(MouseEvent e) {
//                        }
//
//                        @Override
//                        public void mouseReleased(MouseEvent e) {
//                        }
//
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//                        }
//
//                        @Override
//                        public void mouseExited(MouseEvent e) {
//                        }
//                    });
//                }
//            }
//        }
//        
//        boardPanel.revalidate();
//        boardPanel.repaint();
    }
    
}
