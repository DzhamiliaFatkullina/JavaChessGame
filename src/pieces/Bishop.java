package src.pieces;

import src.game.Square;
import src.players.PlayerType;

public class Bishop extends Piece {
    private PlayerType playerType;

    public Bishop(PlayerType playerType) {
        super(PieceType.Bishop, playerType);
    }

    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return ((finalSquare.getCoordinate().getY() - initialSquare.getCoordinate().getY()
                == finalSquare.getCoordinate().getX() - initialSquare.getCoordinate().getX())
                // bishop moves
                || (finalSquare.getCoordinate().getY() - initialSquare.getCoordinate().getY()
                == initialSquare.getCoordinate().getX() - finalSquare.getCoordinate().getX()))

                && isMoveWithoutObstacle(initialSquare, finalSquare);
    }

    @Override
    public boolean isCaptureMove(Square initialSquare, Square finalSquare) {
        return isValidMove(initialSquare, finalSquare) && finalSquare.isOccupied() &&
                finalSquare.getPiece().getPlayerType() != initialSquare.getPiece()
                        .getPlayerType();
    }

}
