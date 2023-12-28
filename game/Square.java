package game;

import pieces.Coordinate;
import pieces.Piece;

public class Square {
    private Coordinate coordinate;
    private Piece piece = null;

    Square(Coordinate coordinate, Piece piece){
        this.coordinate = coordinate;
        this.piece = piece;
    }

    Square(Coordinate coordinate){
        this(coordinate, null);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }
    public boolean isOccupied(){
        if (piece == null) return false;
        return true;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
