/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import board.Coordinates;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pieces.Move;
import pieces.Piece;
import pieces.Team;
import player.Player;
import tiles.Tile;

/**
 *
 * @author fawad
 */
public class App {

    private final JFrame frame = new JFrame();
    private final JPanel boardPanel = new JPanel();
    private final Game gameHandler = new Game();

    public void start() {
        this.createGameWindow();
        this.createBoardPanel();

        this.gameHandler.board.create();
        this.displayGameBoard();
    }

    private void createGameWindow() {
        frame.setTitle("Checkers");
        frame.setSize(480, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createBoardPanel() {
        boardPanel.setLayout(new GridLayout(8, 8));
        boardPanel.setSize(480, 480);
        frame.add(boardPanel);
    }

    private void displayGameBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile tile = this.gameHandler.board.getTile(i, j);
                JPanel tileGUI = this.createTileGUI(tile);
                this.boardPanel.add(tileGUI);
            }
        }

        this.addClick();
        this.boardPanel.revalidate();
        this.boardPanel.repaint();
    }

    private JPanel createTileGUI(Tile tile) {
        TileGUI tileGUI = new TileGUI(tile.getCoordinates());
        tileGUI.setSize(60, 60);
        switch (tile.getColor()) {
            case WHITE ->
                tileGUI.setBackground(Color.white);
            case BLACK ->
                tileGUI.setBackground(Color.black);
        }

        if (tile.isEmpty()) {
            return tileGUI;
        }

        // Create piece gui
        tileGUI.add(this.createPieceGui(tile.getPiece()));
        return tileGUI;
    }

    private JButton createPieceGui(Piece piece) {
        JButton pieceGUI = new JButton();
        pieceGUI.setPreferredSize(new Dimension(30, 30));
        switch (piece.getTeam()) {
            case RED ->
                pieceGUI.setBackground(Color.red);
            case WHITE ->
                pieceGUI.setBackground(Color.white);
        }
        return pieceGUI;
    }

    private void addClick() {
        for (Component component : this.boardPanel.getComponents()) {
            TileGUI tileGUI = (TileGUI) component;
            if (tileGUI.getComponentCount() < 1) {
                continue;
            }

            JButton pieceGUI = (JButton) tileGUI.getComponent(0);
            Piece piece = this.gameHandler.board.getTile(tileGUI.getCoordinates()).getPiece();
            
            if (gameHandler.getTurn() != piece.getTeam()) {
                continue;
            }

            pieceGUI.addActionListener((ActionEvent e) -> {
                this.hidePreviousLegalMoves();
                piece.clearLegalMoves();
                piece.calculateLegalMoves(this.gameHandler.board.getBoard(), piece.getCoordinates(), true);
                this.showLegalMoves(piece.getLegalMoves());
            });
        }
    }

    private void showLegalMoves(ArrayList<Move> legalMoves) {
        for (Move legalMove : legalMoves) {
            for (Component component : this.boardPanel.getComponents()) {
                TileGUI tileGUI = (TileGUI) component;
                if (tileGUI.matchCoordinates(legalMove.toTileCoordinates) == false) {
                    continue;
                }

                tileGUI.setBackground(Color.green);
                MouseListener m = this.addClickOnLegalMove(tileGUI, legalMove, legalMoves);
                tileGUI.addMouseListener(m);
            }
        }

        this.boardPanel.revalidate();
        this.boardPanel.repaint();
    }

    private void hidePreviousLegalMoves() {
        for (Component component : this.boardPanel.getComponents()) {
            TileGUI tileGUI = (TileGUI) component;
            if (tileGUI.getBackground() == Color.green) {
                tileGUI.setBackground(Color.black);
            }
        }
    }

    private MouseListener addClickOnLegalMove(TileGUI tileGUI, Move selectedMove, ArrayList<Move> legalMoves) {
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tileGUI.getBackground() != Color.green) {
                    return;
                }

                // Make move
                ArrayList<Move> connectedMoves = gameHandler.getConnectedMoves(selectedMove, legalMoves);
                gameHandler.switchTurn();
                for (Move connectedMove : connectedMoves) {
                    gameHandler.board.updateBoard(connectedMove);
                    reRenderBoard();
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        return m;
    }

    private void reRenderBoard() {
        this.boardPanel.removeAll();
        this.displayGameBoard();
    }
}
