package pieces;

import players.PlayerType;

public class Queen extends Piece{
    public Queen(PlayerType playerType){
        super(PieceType.Queen, playerType);
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
