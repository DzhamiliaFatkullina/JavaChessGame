package pieces;

import game.Square;
import players.PlayerType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Rook extends Piece {
    private PlayerType playerType;

    public Rook(PlayerType playerType) {
        super(PieceType.Rook, playerType);
    }

    @Override
    public boolean isValidMove(Square initialSquare, Square finalSquare) {
        return ((finalSquare.getCoordinate().getY() == initialSquare.getCoordinate().getY()
                && finalSquare.getCoordinate().getX() != initialSquare.getCoordinate().getX())

                || (finalSquare.getCoordinate().getY() != initialSquare.getCoordinate().getY()
                && finalSquare.getCoordinate().getX() == initialSquare.getCoordinate().getX()))

                && isMoveWithoutObstacle(initialSquare, finalSquare);
    }

    @Override
    public boolean isCaptureMove(Square initialSquare, Square finalSquare) {
        return isValidMove(initialSquare, finalSquare) && finalSquare.isOccupied() &&
                finalSquare.getPiece().getPlayerType() != initialSquare.getPiece()
                        .getPlayerType();
    }
}
