package pieces;

import players.PlayerType;

public class Pawn extends Piece {
    public Pawn(PlayerType playerType){
        super(PieceType.Pawn, playerType);
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
