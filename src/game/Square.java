package src.game;

import src.pieces.Coordinate;
import src.pieces.Piece;

public class Square {
    private Coordinate coordinate;
    private Piece piece = null;

    Square(Coordinate coordinate, Piece piece) {
        this.coordinate = coordinate;
        this.piece = piece;
    }

    Square(Coordinate coordinate) {
        this(coordinate, null);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public boolean equals(Square square) {
        if (square.getCoordinate().equals(coordinate)) {
            return true;
        }
        return false;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
