package ui;

import core.Board;
import core.Cell;
import core.Piece;
import core.Position;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardGUI {

    private final Board boardHandler;
    private final JPanel boardPanel;

    public BoardGUI(Board boardHandler, JPanel boardPanel) {
        this.boardHandler = boardHandler;
        this.boardPanel = boardPanel;
    }

    public void displayBoard() {
        Cell[][] board = this.boardHandler.getBoard();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = board[i][j];
                this.boardPanel.add(createGuiCell(cell));
            }

        }
        this.boardPanel.revalidate();
        this.boardPanel.repaint();
    }

    private JPanel createGuiCell(Cell cell) {
        JPanel guiCell = new JPanel();
        guiCell.setPreferredSize(new Dimension(60, 60));
        guiCell.setName(cell.getPosition().toString());

        // Set Gui cell color
        if (cell.getColor().equals("BLACK")) {
            guiCell.setBackground(Color.black);
        } else {
            guiCell.setBackground(Color.white);
        }

        if (cell.isEmpty()) {
            return guiCell;
        }

        // If cell contains a piece, create a gui piece button
        guiCell.add(this.createGuiPiece(cell));
        return guiCell;
    }

    private JButton createGuiPiece(Cell cell) {
        JButton guiPiece = new JButton();
        guiPiece.setPreferredSize(new Dimension(30, 30));
        Piece piece = cell.getPiece();

        // Set Gui cell color
        if (piece.getColor().equals("RED")) {
            guiPiece.setBackground(Color.red);
        } else {
            guiPiece.setBackground(Color.white);
        }
        return guiPiece;
    }

    public void clearBoard(JPanel boardPanel) {
        boardPanel.removeAll();
    }

    public void displayLegalMoves(ArrayList<Position> legalMoves) {
        for (Position legalMove : legalMoves) {
            for (Component component : this.boardPanel.getComponents()) {
                JPanel guiCell = (JPanel) component;
                if (guiCell.getName().equals(legalMove.toString())) {
                    guiCell.setBackground(Color.green);
                    guiCell.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // Make move here
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
                    });
                }
            }
        }
        this.boardPanel.revalidate();
        this.boardPanel.repaint();
    }

    public void hidePreviousLegalMoves() {
        for (Component component : this.boardPanel.getComponents()) {
            JPanel guiCell = (JPanel) component;
            if (guiCell.getBackground().equals(Color.green)) {
                guiCell.setBackground(Color.black);
            }
        }
        
        this.boardPanel.revalidate();
        this.boardPanel.repaint();
    }
}
