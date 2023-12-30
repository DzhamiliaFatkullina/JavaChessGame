package src.pieces;

/**
 * @author Dzhamilia Fatkullina
 */

public enum PieceType {
    King("K"),
    Queen("Q"),
    Rook("R"),
    Bishop("B"),
    Knight("N"),
    Pawn("P");

    private String value;

    PieceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
