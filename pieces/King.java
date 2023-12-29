package pieces;

import game.Square;
import players.PlayerType;

public class King extends Piece {
    private PlayerType playerType;

    public King(PlayerType playerType) {
        super(PieceType.King, playerType);
    }

    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return ((Math.abs(finalSquare.getCoordinate().getY() - initialSquare.getCoordinate().getY()) <= 1 &&
                Math.abs(finalSquare.getCoordinate().getX() - initialSquare.getCoordinate().getX()) <= 1)
                //accepted moves
                && (Math.abs(finalSquare.getCoordinate().getY() - initialSquare.getCoordinate().getY()) != 0 &&
                Math.abs(finalSquare.getCoordinate().getX() - initialSquare.getCoordinate().getX()) !=
                        0)); //TODO square.equal() function
        //doesn't stay on the same square
    }

    @Override
    public boolean isCaptureMove(Square initialSquare, Square finalSquare) {
        return isValidMove(initialSquare, finalSquare) && finalSquare.isOccupied() &&
                finalSquare.getPiece().getPlayerType() != initialSquare.getPiece()
                        .getPlayerType();
    }
}
