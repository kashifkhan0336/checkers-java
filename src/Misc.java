/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fawad
 */
public class Misc {
        
//    public void makeMove(Move move) {
//        Coordinates to = move.toTileCoordinates;
//        Coordinates from = move.fromTileCoordinates;
//        
//        // Check if piece is stepping over it's enemy piece
//        if (to.row - from.row == 2 || to.row - from.row == -2) {
//            Coordinates s = this.getStepOverTile(to, from);
//            gameBoard[s.row][s.col] = new Tile(Colors.BLACK, from, null);
//        }
//        
//        Piece fromPiece = this.getTile(from.row, from.col).getPiece();
//        gameBoard[to.row][to.col] = new Tile(Colors.BLACK, to, new RegularPiece(to, fromPiece.getTeam()));
//        gameBoard[from.row][from.col] = new Tile(Colors.BLACK, from, null);
//    }
//    
//    private Coordinates getStepOverTile(Coordinates to, Coordinates from) {
//        int row = from.row - 1;
//        int col;
//        if (to.col - from.col == 2) {
//            col = from.col + 1;
//        } else {
//            col = from.col - 1;
//        }
//        
//        return new Coordinates(row, col);
//    }
//    
//        
//    private void findConnectedMove(Move selectedMove, ArrayList<Move> connectedMovesArrray, ArrayList<Move> legalMoves) {
//        for (Move legalMove : legalMoves) {
//            String str1 = legalMove.toTileCoordinates.toString();
//            String str2 = selectedMove.fromTileCoordinates.toString();
//            if (str1.equals(str2)) {
//                connectedMovesArrray.addFirst(legalMove);
//                findConnectedMove(legalMove, connectedMovesArrray, legalMoves);
//            }
//        }
//    }
//    
//    public ArrayList<Move> getConnectedMoves(Move selectedMove, ArrayList<Move> legalMoves) {
//        ArrayList<Move> connectedMoves = new ArrayList();
//        connectedMoves.add(selectedMove);
//        this.findConnectedMove(selectedMove, connectedMoves, legalMoves);        
//        return connectedMoves;
//    }
}
