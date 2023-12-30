package src.pieces;

import src.game.Square;
import src.players.PlayerType;

/**
 * @author Dzhamilia Fatkullina
 */

public class Rook extends Piece {
    private PlayerType playerType;

    public Rook(PlayerType playerType) {
        super(PieceType.Rook, playerType);
    }

    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return ((finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY()
                && finalSquare.getCoordinate().getX() != initialSquare.getCoordinate().getX())

                || (finalSquare.getCoordinate().getY() != initialSquare.getCoordinate().getY()
                && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX()))

                && isMoveWithoutObstacle(initialSquare, finalSquare);
    }

    @Override
    public boolean isCaptureMove(Square initialSquare, Square finalSquare) {
        return isValidMove(initialSquare, finalSquare) && finalSquare.isOccupied() &&
                finalSquare.getPiece().getPlayerType() != initialSquare.getPiece()
                        .getPlayerType();
    }
}
