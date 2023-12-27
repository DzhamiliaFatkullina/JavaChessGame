package pieces;

import players.PlayerType;

public class King extends Piece{
    King(PlayerType playerType){
        super(PieceType.King, playerType);
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
