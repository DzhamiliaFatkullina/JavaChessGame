package pieces;

import game.Square;
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
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return false;
    }

}
