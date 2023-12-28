package pieces;

import game.Square;
import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Queen extends Piece{
    private PlayerType playerType;
    public Queen(PlayerType playerType){
        super(PieceType.Queen, playerType);
    }
    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return false;
    }
}
