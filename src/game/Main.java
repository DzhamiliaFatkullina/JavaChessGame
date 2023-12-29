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

    public static void GameGUI() {
        final int WINDOW_HEIGHT = 800;
        final int WINDOW_WIDTH = 800;

        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Chess src.game for two");
        frame.setLocationRelativeTo(null);

        ChessSetUp chessSetUp = new ChessSetUp(board.getSquares());
        frame.add(chessSetUp);
        frame.pack();

        ImageIcon logo = new ImageIcon("game/OIP.jpg");
        frame.setIconImage(logo.getImage());

        chessSetUp.setVisible(true);
        frame.setVisible(true);

    }

    static class MyActionListener implements ActionListener {
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
