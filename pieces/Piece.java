package pieces;
import players.PlayerType;

public abstract class Piece {
    private Coordinate currentCoordinate;
    private Coordinate newCoordinate;
    private PieceType pieceType;
    private PlayerType playerType;

    Piece(PieceType pieceType, PlayerType playerType){
        this.pieceType = pieceType;
        this.playerType = playerType;
    }

    public abstract boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate);
}
