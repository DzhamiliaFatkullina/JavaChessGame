package pieces;

import players.PlayerType;

public class Bishop extends Piece{
    public Bishop(PlayerType playerType){
        super(PieceType.Bishop, playerType);
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
