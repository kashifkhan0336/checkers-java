/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import board.Board;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pieces.Piece;
import static tiles.Colors.BLACK;
import static tiles.Colors.WHITE;
import tiles.Tile;

/**
 *
 * @author fawad
 */
public class BoardGUI {
    private final JPanel panel = new JPanel(new GridLayout(8, 8));
    private final Board board = new Board();
    
    public void displayBoard(JFrame mainFrame) {
        board.create();
        this.createBoardGui();
        mainFrame.add(panel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    public void reRenderBoard() {}
    
    private void createBoardGui() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel tileGui = createTileGui(board.getTile(i, j));
                panel.add(tileGui);
            }
        }
    }
    
    private JPanel createTileGui(Tile tile) {
        JPanel tileGui = new JPanel();
        tileGui.setPreferredSize(new Dimension(60, 60));
        
        switch (tile.getColor()) {
            case WHITE -> {
                tileGui.setBackground(Color.white);
            }
            case BLACK -> {
                tileGui.setBackground(Color.black);
            }
        }
        
        // If tile does not have any piece, then return an empty tile
        if (tile.isEmpty()) {
            return tileGui;
        }
        
        // Create a jbutton for representing piece in gui
        JButton pieceGui = createPieceGui(tile.getPiece());
        tileGui.add(pieceGui);
        return tileGui;
    }
    
    private JButton createPieceGui(Piece piece) {
        JButton pieceGui = new JButton();
        pieceGui.setPreferredSize(new Dimension(30, 30));
        
        switch (piece.getTeam()) {
            case WHITE -> {
                pieceGui.setBackground(Color.white);
            }
            case RED -> {
                pieceGui.setBackground(Color.red);
            }
        }
        
        return pieceGui;
    }
    
    private void clearBoard() {
        panel.removeAll();
    }
    
}
