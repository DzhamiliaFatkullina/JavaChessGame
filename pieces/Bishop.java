package pieces;

import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Bishop extends Piece{
    private PlayerType playerType;
    public Bishop(PlayerType playerType){
        super(PieceType.Bishop, playerType);
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }

    @Override
    public BufferedImage getImage() {
        String let = "b";
        if(playerType == PlayerType.WHITE) let = "w";
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(
                    getClass().getResourceAsStream("chess piece images v1.0/" + let + "-bishop" + ".png")));
        } catch (IOException e) {
            e.getMessage();
        }
        return image;
    }
}
