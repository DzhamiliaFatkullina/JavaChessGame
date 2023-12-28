package game;

import players.PlayerType;

public class ChessGame {
    private PlayerType playerTurn = PlayerType.WHITE;

    public PlayerType getPlayerTurn() {
        return playerTurn;
    }

    public void changePlayerTurn() {
        if(playerTurn == PlayerType.WHITE){
            this.playerTurn = PlayerType.BLACK;
        } else {
            this.playerTurn = PlayerType.WHITE;
        }
    }

    public boolean promote(){
        /*
        promotes pawn to higher figure if needed
         */
        return false;
    }

    public boolean isValidPromotion(){
        /*
        checks if there is pawn to promote in any given second
         */
        return false;
    }

    public boolean isGameOver(){
        if(isCheckMate(PlayerType.BLACK) || isCheckMate(PlayerType.WHITE)){
            return true;
        } return false;
    }

    public boolean isCheckMate(PlayerType player){
        /*
        checks if there is checkmate for every given moment
         */
        return false;
    }
    public boolean move(Square initialSquare, Square finalSquare){
        /*
        updates the board from initial coordinate to final coordinate
         */
        return false;
    }

    public boolean isValidCastling(Square king, Square rook){
        /*
        checks if Castling is valid
         */
        return false;
    }

    public boolean castle(Square king, Square rook){
        /*
        make move
         */
        return false;
    }

    public boolean isValidEnpassant(Square initialSquare, Square finalSquare){
        /*
        checks if able to do Enpassant
         */
        return false;

    }

    public boolean Enpassant(Square pawn, Square victim){
        /*
        makes enpassant
         */
        return false;
    }

    public boolean isCheckMove(Square initialSquare, Square finalSquare){
        /*
        checks if current move makes check
         */
        return false;
    }

    public boolean isCheck(){
        /*
        checks if there is check for current player
         */
        return false;
    }


}
