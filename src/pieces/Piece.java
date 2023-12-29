package src.pieces;

import src.game.Square;
import src.players.PlayerType;

public abstract class Piece {
    private Coordinate currentCoordinate;
    private Coordinate newCoordinate;
    private PieceType pieceType;
    private PlayerType playerType;

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
        return true; //TODO write function
    }
}
