/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import board.Board;
import board.Coordinates;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import pieces.Move;
import pieces.Piece;

/**
 *
 * @author fawad
 */
public class PieceGUI extends JButton {
    private Coordinates coordinates;
    private static final Board board = new Board();

    public PieceGUI(Piece piece, BoardGUI boardGui) {
        this.coordinates = piece.getCoordinates();
        this.setPreferredSize(new Dimension(30, 30));
        
        // Set piece gui color
        switch(piece.getTeam()) {
            case WHITE -> {
                this.setBackground(Color.white);
            }
            
            case RED -> {
                this.setBackground(Color.red);
            }
        }
        
        this.addActionListener((ActionEvent evt) -> {
            // Calculate legal moves
            piece.calculateLegalMoves(board.getBoard(), coordinates, true);
            
            // Display legal moves
            boardGui.displayLegalMoves(piece.getLegalMoves());
        });
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }  
    
}
