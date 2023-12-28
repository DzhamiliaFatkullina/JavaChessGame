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

    public abstract boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate);

    public BufferedImage getImage(String imagePath){
        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
        } catch (Exception e){
            e.getMessage();
        }
        return image;
    }
}
