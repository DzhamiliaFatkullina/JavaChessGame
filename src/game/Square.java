package src.game;

import src.pieces.Coordinate;
import src.pieces.Piece;

/**
 * <b>Class Square representing a single Square of a Chess Game.</b>
 * <p>When Constructor is called the Square is initialized with values
 * for Coordinate and Piece (if Square is empty, piece is set to null).</p>
 * <p>The class has getters and setters for both piece and coordinate</p>
 * <p>Boolean methods:</p>
 * <p> - isOcupied - returns  </p>
 * @author Dzhamilia Fatkullina
 */

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
