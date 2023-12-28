package pieces;

import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Rook extends Piece{
    private PlayerType playerType;
    public Rook(PlayerType playerType){
        super(PieceType.Rook, playerType);
    }
    @Override
    public BufferedImage getImage() {
        String let = "b";
        if(playerType == PlayerType.WHITE) let = "w";
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(
                    getClass().getResourceAsStream("chess piece images v1.0/" + let + "-rook" + ".png")));
        } catch (IOException e) {
            e.getMessage();
        }
        return image;
    }
    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
