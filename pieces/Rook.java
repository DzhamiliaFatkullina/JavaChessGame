package pieces;

import game.Square;
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
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return false;
    }
}
