package pieces;

import game.Square;
import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Knight extends Piece{
    private PlayerType playerType;
    public Knight(PlayerType playerType){
        super(PieceType.Knight, playerType);
    }

    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return false;
    }

}
