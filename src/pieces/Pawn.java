package src.pieces;

import src.game.Square;
import src.players.PlayerType;

public class Pawn extends Piece {
    public Pawn(PlayerType playerType) {
        super(PieceType.Pawn, playerType);
    }

    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        if (isFirstMove(initialSquare, finalSquare) || isCaptureMove(initialSquare, finalSquare) ||
                isRegularMove(initialSquare, finalSquare)) {
            return true;
        }
        return false;
    }

    private boolean isFirstMove(Square initialSquare, Square finalSquare) {
        return (this.getPlayerType() == PlayerType.WHITE && initialSquare.getCoordinate().getY() == 6 &&
                (finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX()
                        && finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() - 2)
                && isMoveWithoutObstacle(initialSquare, finalSquare))

                || (this.getPlayerType() == PlayerType.BLACK && initialSquare.getCoordinate().getY() == 1 &&
                (finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX()
                        && finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() + 2)
                && isMoveWithoutObstacle(initialSquare, finalSquare));
    }

    public boolean isCaptureMove(Square initialSquare, Square finalSquare) {
        return (this.getPlayerType() == PlayerType.WHITE &&
                ((finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() + 1 ||
                        finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() - 1)
                        && finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() - 1)
                && (finalSquare.isOccupied() && finalSquare.getPiece().getPlayerType() == PlayerType.BLACK))

                || (this.getPlayerType() == PlayerType.BLACK &&
                ((finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() + 1 ||
                        finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() - 1)
                        && finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() + 1)
                && (finalSquare.isOccupied() && finalSquare.getPiece().getPlayerType() == PlayerType.WHITE));
    }

    private boolean isRegularMove(Square initialSquare, Square finalSquare) {
        return (this.getPlayerType() == PlayerType.WHITE &&
                (finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX()
                        && finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() - 1)
                && isMoveWithoutObstacle(initialSquare, finalSquare))
                || (this.getPlayerType() == PlayerType.BLACK &&
                (finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX()
                        && finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() + 1)
                && isMoveWithoutObstacle(initialSquare, finalSquare));
    }
}
