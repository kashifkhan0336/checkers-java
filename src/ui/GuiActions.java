package ui;

import core.MoveHandler;
import core.Position;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiActions {

    private final MoveHandler moveHandler;
    private final BoardGUI boardGUI;

    public GuiActions(MoveHandler moveHandler, BoardGUI boardGUI) {
        this.moveHandler = moveHandler;
        this.boardGUI = boardGUI;
    }

    public void addClickListenersOnPieces(JPanel boardPanel) {
        for (Component component : boardPanel.getComponents()) {
            JPanel guiCell = (JPanel) component;
            
            // if guiCell has a piece, then add the actionListener
            if (guiCell.getComponentCount() > 0) {
                JButton pieceGUI = (JButton) guiCell.getComponent(0);
                pieceGUI.addActionListener(this.showLegalMoves(guiCell.getName()));
            }
        }
    }

    public ActionListener showLegalMoves(String positionStr) {
        return (ActionEvent e) -> {
            // Clear and Un-render previous legal moves
            moveHandler.clearLegalMoves();
            boardGUI.hidePreviousLegalMoves();
            
            // Find and display new legal moves
            ArrayList<Position> legalMoves = moveHandler.getLegalMoves(positionStr);
            boardGUI.displayLegalMoves(legalMoves);
        };
    }
}
