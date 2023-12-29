package pieces;

import game.Square;
import players.PlayerType;

public class Queen extends Piece{
    private PlayerType playerType;
    public Queen(PlayerType playerType){
        super(PieceType.Queen, playerType);
    }
    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return ((finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY()
                && finalSquare.getCoordinate().getX() != initialSquare.getCoordinate().getX())
                                                                                                // rook moves
                || (finalSquare.getCoordinate().getY() != initialSquare.getCoordinate().getY()
                && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX())

                || (finalSquare.getCoordinate().getY() - initialSquare.getCoordinate().getY()
                        == finalSquare.getCoordinate().getX() - initialSquare.getCoordinate().getX())
                // bishop moves
                || (finalSquare.getCoordinate().getY() - initialSquare.getCoordinate().getY()
                        == initialSquare.getCoordinate().getX() - finalSquare.getCoordinate().getX()))

                && isMoveWithoutObstacle(initialSquare, finalSquare);
    }
    @Override
    public boolean isCaptureMove(Square initialSquare, Square finalSquare) {
        return isValidMove(initialSquare, finalSquare) && finalSquare.isOccupied() && finalSquare.getPiece().getPlayerType() != initialSquare.getPiece()
                .getPlayerType();
    }
}
