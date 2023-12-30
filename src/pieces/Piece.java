package src.pieces;

import src.game.Square;
import src.players.PlayerType;

/**
 * Abstract class Piece with two abstract methods: isValidMove, isCaptureMove, getters for pieceType and playerType of an object.
 * @author Dzhamilia Fatkullina
 */
public abstract class Piece {
    private PieceType pieceType;
    private PlayerType playerType;

    /**
     * Constructor for Piece
     * @param pieceType - PieceType value of a piece
     * @param playerType - PlayerType value of a piece
     */
    Piece(PieceType pieceType, PlayerType playerType) {
        this.pieceType = pieceType;
        this.playerType = playerType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public abstract boolean isValidMove(Square initialSquare, Square finalSquare);

    public abstract boolean isCaptureMove(Square initialSquare, Square finalSquare);

    boolean isMoveWithoutObstacle(Square initialSquare, Square finalSquare) {
        return true;
    }
}
