import pieces.Bishop;
import pieces.Coordinate;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import players.PlayerType;

public class Board {
    private Square[][] squares = new Square[8][8];

    Board(){
        setSquares();
        setWhitePieces();
        setBlackPieces();
    }
    private void setSquares(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                squares[i][j] = new Square(new Coordinate(i, j));
            }
        }
    }

    private void setWhitePieces(){
        squares[7][0].setPiece(new Rook(PlayerType.WHITE));
        squares[7][1].setPiece(new Knight(PlayerType.WHITE));
        squares[7][2].setPiece(new Bishop(PlayerType.WHITE));
        squares[7][3].setPiece(new Queen(PlayerType.WHITE));
        squares[7][4].setPiece(new King(PlayerType.WHITE));
        squares[7][5].setPiece(new Bishop(PlayerType.WHITE));
        squares[7][6].setPiece(new Knight(PlayerType.WHITE));
        squares[7][7].setPiece(new Rook(PlayerType.WHITE));
        for (int i = 0; i<8; i++){
            squares[6][i].setPiece(new Pawn(PlayerType.WHITE));
        }
    }

    private void setBlackPieces(){
        squares[0][0].setPiece(new Rook(PlayerType.BLACK));
        squares[0][1].setPiece(new Knight(PlayerType.BLACK));
        squares[0][2].setPiece(new Bishop(PlayerType.BLACK));
        squares[0][3].setPiece(new Queen(PlayerType.BLACK));
        squares[0][4].setPiece(new King(PlayerType.BLACK));
        squares[0][5].setPiece(new Bishop(PlayerType.BLACK));
        squares[0][6].setPiece(new Knight(PlayerType.BLACK));
        squares[0][7].setPiece(new Rook(PlayerType.BLACK));
        for (int i = 0; i<8; i++){
            squares[1][i].setPiece(new Pawn(PlayerType.BLACK));
        }
    }

    public void update(){
        /*
        updated the board after valid move is made
         */
    }
}
