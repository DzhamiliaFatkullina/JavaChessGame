package pieces;

import game.Square;
import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class King extends Piece{
    private PlayerType playerType;
    public King(PlayerType playerType){
        super(PieceType.King, playerType);
    }
    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return false;
    }
}
