package pieces;

import game.Square;
import players.PlayerType;

public class Pawn extends Piece {
    private PlayerType playerType;
    public Pawn(PlayerType playerType){
        super(PieceType.Pawn, playerType);
    }
    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return isFirstMove(initialSquare, finalSquare) || isCaptureMove(initialSquare, finalSquare) ||
                isRegularMove(initialSquare, finalSquare);
    }

    private boolean isFirstMove(Square initialSquare, Square finalSquare){
        return (playerType == PlayerType.WHITE && initialSquare.getCoordinate().getX() == 6 &&
                (finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY()
                        && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() - 2)
                && isMoveWithoutObstacle(initialSquare, finalSquare))

                || (playerType == PlayerType.BLACK && initialSquare.getCoordinate().getX() == 1 &&
                (finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY()
                        && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() + 2)
                && isMoveWithoutObstacle(initialSquare, finalSquare));
    }

    private boolean isCaptureMove(Square initialSquare, Square finalSquare){
        return (playerType == PlayerType.WHITE && initialSquare.getCoordinate().getX() == 6 &&
                ((finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() + 1 ||
                        finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() - 1)
                        && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() - 1)
                && (finalSquare.isOccupied() && finalSquare.getPiece().getPlayerType() == PlayerType.BLACK))

                || (playerType == PlayerType.BLACK && initialSquare.getCoordinate().getX() == 1 &&
                ((finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() + 1 ||
                        finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY() - 1)
                        && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() + 1)
                && (finalSquare.isOccupied() && finalSquare.getPiece().getPlayerType() == PlayerType.WHITE));
    }

    private boolean isRegularMove(Square initialSquare, Square finalSquare){
        return (playerType == PlayerType.WHITE &&
                (finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY()
                        && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() - 1)
                && isMoveWithoutObstacle(initialSquare, finalSquare))

                || (playerType == PlayerType.BLACK &&
                (finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY()
                        && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX() + 1)
                && isMoveWithoutObstacle(initialSquare, finalSquare));
    }

    public boolean isPromotion(Square initialSquare, Square finalSquare){
        if (isRegularMove(initialSquare, finalSquare)
                && ((playerType == PlayerType.WHITE && finalSquare.getCoordinate().getY() == 0)
                || (playerType == PlayerType.BLACK && finalSquare.getCoordinate().getY() == 7))) {
            System.out.println("THIS IS PROMOTION!!");
            return true;
        }
        return false;
    }
}
