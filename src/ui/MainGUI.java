package ui;

import core.Board;
import core.MoveHandler;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI {
    private final JFrame mainFrame = new JFrame();
    private final JPanel boardPanel = new JPanel();
    private final JPanel playerPanel = new JPanel();
    
    // Logic classes
    private final Board boardHandler = new Board();
    private final MoveHandler moveHandler = new MoveHandler(boardHandler);
    
    // UI classes
    private final BoardGUI boardGUI = new BoardGUI(boardHandler, boardPanel);
    private final GuiActions guiActionHandler = new GuiActions(moveHandler, boardGUI);
    
    
    public void start() {
        this.setupGameWindow();
        boardHandler.createBoard();
        boardGUI.displayBoard();
        guiActionHandler.addClickListenersOnPieces(boardPanel);
    }
    
    private void setupGameWindow() {
        // setup jframe
        mainFrame.setTitle("Checkers - Fawad Imran");
        mainFrame.setSize(480, 480);
        mainFrame.setVisible(true);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // TODO: setup player panel
        // setup board panel
        boardPanel.setLayout(new GridLayout(8, 8));
        mainFrame.add(boardPanel, BorderLayout.CENTER);
    }
}
