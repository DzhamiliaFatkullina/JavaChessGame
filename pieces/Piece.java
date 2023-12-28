package pieces;
import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public abstract class Piece {
    private Coordinate currentCoordinate;
    private Coordinate newCoordinate;
    private PieceType pieceType;
    private PlayerType playerType;

    Piece(PieceType pieceType, PlayerType playerType){
        this.pieceType = pieceType;
        this.playerType = playerType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public abstract boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate);
    public abstract BufferedImage getImage();
}
