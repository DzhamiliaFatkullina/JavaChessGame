package pieces;

import players.PlayerType;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{
    public Bishop(PlayerType playerType){
        super(PieceType.Bishop, playerType);
        if(playerType == PlayerType.BLACK){
        BufferedImage image = getImage("chess piece images v1.0/b-bishop");}
        else {
            BufferedImage image = getImage("chess piece images v1.0/w-bishop");
        }
    }

    @Override
    public boolean isValidMove(Coordinate currentCoordinate, Coordinate newCoordinate) {
        return false;
    }
}
