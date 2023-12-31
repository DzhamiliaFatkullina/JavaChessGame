package src.game;

import src.pieces.Bishop;
import src.pieces.Coordinate;
import src.pieces.King;
import src.pieces.Knight;
import src.pieces.Pawn;
import src.pieces.PieceType;
import src.pieces.Queen;
import src.pieces.Rook;
import src.players.PlayerType;

/**
 * This is Board class. When Board object is created it sets pieces on their initial positions.
 * <p>This class is used to create and make all changes the game supports. Update method is used to check validity of
 * a move and make a move if it's valid. Other methods are secondary, designed to be used within update method.</p>
 * @author Dzhamilia Fatkullina
 */

public class Board {
    private Square[][] squares = new Square[8][8];
    private PlayerType playerTurn = PlayerType.WHITE;

    Board() {
        setSquares();
        setWhitePieces();
        setBlackPieces();
    }

    /**
     * Creates squares array
     */
    private void setSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[j][i] = new Square(new Coordinate(j, i));
            }
        }
    }

    /**
     * Sets white peices to their initial position
     */
    private void setWhitePieces() {
        squares[0][7].setPiece(new Rook(PlayerType.WHITE));
        squares[1][7].setPiece(new Knight(PlayerType.WHITE));
        squares[2][7].setPiece(new Bishop(PlayerType.WHITE));
        squares[3][7].setPiece(new Queen(PlayerType.WHITE));
        squares[4][7].setPiece(new King(PlayerType.WHITE));
        squares[5][7].setPiece(new Bishop(PlayerType.WHITE));
        squares[6][7].setPiece(new Knight(PlayerType.WHITE));
        squares[7][7].setPiece(new Rook(PlayerType.WHITE));
        for (int i = 0; i < 8; i++) {
            squares[i][6].setPiece(new Pawn(PlayerType.WHITE));
        }
    }

    /**
     * Sets black pieces to their initial position
     */
    private void setBlackPieces() {
        squares[0][0].setPiece(new Rook(PlayerType.BLACK));
        squares[1][0].setPiece(new Knight(PlayerType.BLACK));
        squares[2][0].setPiece(new Bishop(PlayerType.BLACK));
        squares[3][0].setPiece(new Queen(PlayerType.BLACK));
        squares[4][0].setPiece(new King(PlayerType.BLACK));
        squares[5][0].setPiece(new Bishop(PlayerType.BLACK));
        squares[6][0].setPiece(new Knight(PlayerType.BLACK));
        squares[7][0].setPiece(new Rook(PlayerType.BLACK));
        for (int i = 0; i < 8; i++) {
            squares[i][1].setPiece(new Pawn(PlayerType.BLACK));
        }
    }

    public Square[][] getSquares() {
        return squares;
    }

    /**
     * if correct player is making a move and player doesn't have checkMate, statement detects type of valid move made,
     * updates squares array accordingly, and returns true.
     * if move isn't valid, prints error on terminal, returns false.
     * @param previouslySelectedCoordinate - Coordinate value of first button clicked,
     *                                     if there is no previously clicked button, it's value is null.
     * @param newlySelectedCoordinate - Coordinate value of second button clicked
     * @return boolean value of whether the board was updated
     */
    public boolean update(Coordinate previouslySelectedCoordinate, Coordinate newlySelectedCoordinate) {
        /*
        updated the board after valid move is made
         */
        if (previouslySelectedCoordinate == null || newlySelectedCoordinate == null) {
            System.out.println("Trouble with coordinates");
            return false;
        }

        Square initialSquare =
                this.getSquares()[previouslySelectedCoordinate.getX()][previouslySelectedCoordinate.getY()];
        Square finalSquare = this.getSquares()[newlySelectedCoordinate.getX()][newlySelectedCoordinate.getY()];

        if (!initialSquare.isOccupied()) {
            return false;
        }

        if (initialSquare.equals(finalSquare)) {
            System.out.println("Initial square equals to final square");
            return false;
        }
        if (playerTurn == initialSquare.getPiece().getPlayerType() && !isCheckMate(playerTurn)) {
            if (initialSquare.getPiece().isCaptureMove(initialSquare, finalSquare)) {
                capture(initialSquare, finalSquare);
                changePlayerTurn();
                return true;
            }
            if (isEnpassant(initialSquare, finalSquare)) {
                enpassant(initialSquare, finalSquare);
                changePlayerTurn();
                return true;
            }
            if (isPromotion(initialSquare, finalSquare)) {
                promote();
                changePlayerTurn();
                return true;
            }
            if (isCastling(initialSquare, finalSquare)) {
                castle();
                changePlayerTurn();
                return true;
            }
            if (initialSquare.getPiece().isValidMove(initialSquare, finalSquare)) {
                this.getSquares()[finalSquare.getCoordinate().getX()][finalSquare.getCoordinate().getY()].setPiece(
                        initialSquare.getPiece());
                this.getSquares()[initialSquare.getCoordinate().getX()][initialSquare.getCoordinate().getY()].setPiece(
                        null);
                changePlayerTurn();
                return true;
            }
        } else if (isCheckMate(playerTurn)){

        } else  {
            System.out.println("Wrong player");
            return false;
        }
        System.out.println("Wrong move for " + playerTurn);
        return false;
    }

    /**
     * Changes Player turn
     */
    void changePlayerTurn() {
        if (playerTurn == PlayerType.WHITE) {
            this.playerTurn = PlayerType.BLACK;
        } else {
            this.playerTurn = PlayerType.WHITE;
        }
    }

    boolean isPromotion(Square initialSquare, Square finalSquare) {
        if (initialSquare.getPiece().isValidMove(initialSquare, finalSquare)
                && ((initialSquare.getPiece().getPlayerType() == PlayerType.WHITE &&
                finalSquare.getCoordinate().getY() == 0)
                || (initialSquare.getPiece().getPlayerType() == PlayerType.BLACK &&
                finalSquare.getCoordinate().getY() == 7))
                && initialSquare.getPiece().getPieceType() == PieceType.Pawn) {
            System.out.println("THIS IS PROMOTION!!");
            return true;
        }
        return false;
    }

    boolean isEnpassant(Square initialSquare, Square finalSquare) {
        /*
        checks if able to do Enpassant
         */
        return false;

    }

    void capture(Square initialSquare, Square finalSquare) {
        this.getSquares()[finalSquare.getCoordinate().getX()][finalSquare.getCoordinate().getY()].setPiece(
                initialSquare.getPiece());
        this.getSquares()[initialSquare.getCoordinate().getX()][initialSquare.getCoordinate().getY()].setPiece(null);
    }

    boolean promote() {
        /*
        promotes pawn to higher figure if needed
         */
        return false;
    }

    public boolean isGameOver() {
        if (isCheckMate(PlayerType.BLACK) || isCheckMate(PlayerType.WHITE)) {
            return true;
        }
        return false;
    }

    boolean isCheckMate(PlayerType player) {
        /*
        checks if there is checkmate for every given moment
         */
        return false;
    }

    boolean isCastling(Square initialSquare, Square finalSquare) {
        return false;
    }

    boolean castle() {
        /*
        make move
         */
        return false;
    }

    boolean enpassant(Square pawn, Square victim) {
        /*
        makes enpassant
         */
        return false;
    }

    boolean isCheckMove(Square initialSquare, Square finalSquare) {
        /*
        checks if current move makes check
         */
        return false;
    }

    boolean isCheck() {
        /*
        checks if there is check for current player
         */
        return false;
    }

}
