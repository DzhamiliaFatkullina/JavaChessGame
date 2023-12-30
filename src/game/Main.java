package src.game;

import src.pieces.Coordinate;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

/**
 * This is a point where game starts.
 *  <p>Game is active until CheckMate is reached or player closes the window.</p>
 *  <p>Positions of chess figures and their associated pieces on the board are changed as
 *  user selects initial and final position of a piece.</p>
 *  <p>The program won't allow to make a wrong move or make a move when it's the wrong players turn.</p>
 *  <p></p>
 *  <p><b>How the program works?</b></p>
 * <p>Static variable board is created.</p>
 * <p>Method GameGUI creates Chess frame, adds buttons to it and calls ChessSetUp, which sets up icons of chess pieces
 * to their initial positions and adds MyActionListener to each button.</p>
 * @author Dzhamilia Fatkullina
 */

public class Main {
    static JFrame frame = new JFrame();
    static JButton previouslySelected = null;
    static Board board = new Board();
    static JButton[][] allButtons = new JButton[8][8];

    public static JButton[][] getButtons() {
        return allButtons;
    }


    public static void main(String[] args) {
        GameGUI();
    }

    /**
     * Creates frame, calls ChessSetUp
     */
    public static void GameGUI() {
        final int WINDOW_HEIGHT = 800;
        final int WINDOW_WIDTH = 800;
        // make 800*800 frame that stops working when the user closes it, set title, logo, make it centered
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Chess game for two");
        frame.setLocationRelativeTo(null);

        ChessSetUp chessSetUp = new ChessSetUp(board.getSquares());
        frame.add(chessSetUp);
        frame.pack();

        ImageIcon logo = new ImageIcon("src/game/OIP.jpg");
        frame.setIconImage(logo.getImage());

        chessSetUp.setVisible(true);
        frame.setVisible(true);

    }

    /**
     * <p>Class that implements interface ActionListener.</p>
     * <p>This class has two methods - ActionPerformed and update.</p>
     * ActionPerformed method waits until player has selected two squares and sends information about selected squares to board.update().
     * If the board updates, GUI displaying the board updates in update() method of this class.
     */
    static class MyActionListener implements ActionListener {

        /**
         * This method goes through squares on the board and if the square is occupied adds an Icon of a piece to it.
         */
        private void update() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    JButton button = getButtons()[j][i];
                    if ((i + j) % 2 != 0) {
                        button.setBackground(Color.decode("#261300"));
                    } else {
                        button.setBackground(Color.decode("#FFFFEC"));
                    }
                    Square square = board.getSquares()[j][i];
                    if (square.isOccupied()) {
                        Image image = null;
                        try {
                            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(
                                    "chess piece images v1.0/" + square.getPiece().getPlayerType().toString() +
                                            square.getPiece().getPieceType().toString() + ".png")));
                        } catch (IOException ignored) {
                        }
                        assert image != null;
                        button.setIcon(new ImageIcon(image));

                    } else {
                        button.setIcon(null);
                    }
                }
            }
        }

        /**
         * When button is clicked actionPerformed is invoked.
         * <p>If there is no previouslySelected button, method assigns current button to be
         * previouslySelected and waits for another click.</p>
         * <p>If boolean value of board.update(previouslySelectedCoordinate, newlySelectedCoordinate) is true.
         * Method calls update() method of MyActionListener to update GUI representation of the board. </p>
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            Point buttonLocation = new Point();

            Coordinate newlySelectedCoordinate = new Coordinate(button.getLocation(buttonLocation).x / 100,
                    button.getLocation(buttonLocation).y / 100);

            boolean boardUpdated = false;

            if (previouslySelected != null) {
                Coordinate previouslySelectedCoordinate =
                        new Coordinate(previouslySelected.getLocation(buttonLocation).x / 100,
                                previouslySelected.getLocation(buttonLocation).y / 100);
                boardUpdated = board.update(previouslySelectedCoordinate, newlySelectedCoordinate);

                if (boardUpdated) {
                    previouslySelected = null;
                    update();
                } else {
                    previouslySelected = null;
                }
            }
            if (!boardUpdated) {
                previouslySelected = button;
            }
        }
    }


    /**
     * Sets up Chess according to positions on board. Called once in the begging to set up initial positions of pieces.
     */
    static class ChessSetUp extends JButton {
        ChessSetUp(Square[][] squares) {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    gbc.gridx = j;
                    gbc.gridy = i;

                    JButton button = new JButton();
                    allButtons[j][i] = button;

                    button.setBorderPainted(false);
                    button.setPreferredSize(new Dimension(100, 100));

                    if ((i + j) % 2 != 0) {
                        button.setBackground(Color.decode("#261300"));
                    } else {
                        button.setBackground(Color.decode("#FFFFEC"));
                    }
                    Square square = squares[j][i];
                    if (square.isOccupied()) {
                        Image image = null;
                        try {
                            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(
                                    "chess piece images v1.0/" + square.getPiece().getPlayerType().toString() +
                                            square.getPiece().getPieceType().toString() + ".png")));
                        } catch (IOException ignored) {
                        }
                        assert image != null;
                        button.setIcon(new ImageIcon(image));

                    } else {
                        button.setIcon(null);
                    }
                    button.addActionListener(new MyActionListener());
                    add(button, gbc);
                }
            }
        }
    }
}
