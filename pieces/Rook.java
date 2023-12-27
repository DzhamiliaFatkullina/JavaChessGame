package pieces;

import players.PlayerType;

public class Rook extends Piece{
    Rook(PlayerType playerType){
        super(PieceType.Rook, playerType);
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
