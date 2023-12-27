package pieces;

import players.PlayerType;

public class Knight extends Piece{
    Knight(PlayerType playerType){
        super(PieceType.Knight, playerType);
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
