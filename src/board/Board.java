/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package board;

import pieces.Move;
import tiles.Colors;
import pieces.Piece;
import pieces.RegularPiece;
import pieces.Team;
import tiles.Tile;

/**
 *
 * @author fawad
 */
public class Board {
    private Tile[][] board = new Tile[8][8];
    
    public void create() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                
                Coordinates coordinates = new Coordinates(i, j);
                
                if ((i + j) % 2 == 0) {
                    // Create an empty white tile
                    board[i][j] = new Tile(Colors.WHITE, coordinates, null);
                    
                } else {                    
                    // Create white pieces for rows 0,1,2
                    if (i >= 0 && i <= 2) {
                        Piece whitePiece = new RegularPiece(coordinates, Team.WHITE);
                        board[i][j] = new Tile(Colors.BLACK, coordinates, whitePiece);
                        continue;
                    }
                    
                    // Create red pieces for rows 5,6,7
                    if (i >= 5 && i <= 7) {
                        Piece redPiece = new RegularPiece(coordinates, Team.RED);
                        board[i][j] = new Tile(Colors.BLACK, coordinates, redPiece);
                        continue;
                    }
                    
                    // Create empty black tiles for rest of the rows
                    Tile emptyBlackTile = new Tile(Colors.BLACK, coordinates, null);
                    board[i][j] = emptyBlackTile;
                }
                
            }
        }
    }
    
    public Tile[][] getBoard() {
        return this.board;
    }
    
    public Tile getTile(Coordinates coordinates) {
        return board[coordinates.row][coordinates.col];
    }
    
    public void updateBoard(Move move) {
        Coordinates to = move.toTileCoordinates;
        Coordinates from = move.fromTileCoordinates;
        
        board[from.row][from.col] = new Tile(Colors.BLACK, from, null);
        board[to.row][to.col] = new Tile(Colors.BLACK, to, this.getTile(from).getPiece());
    }
}
