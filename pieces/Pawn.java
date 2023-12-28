package pieces;

import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Pawn extends Piece {
    private PlayerType playerType;
    public Pawn(PlayerType playerType){
        super(PieceType.Pawn, playerType);
    }
    @Override
    public BufferedImage getImage() {
        String let = "b";
        if(playerType == PlayerType.WHITE) let = "w";
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(
                    getClass().getResourceAsStream("chess piece images v1.0/" + let + "-pawn" + ".png")));
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
