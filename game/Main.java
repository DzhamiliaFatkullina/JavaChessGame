package game;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        GameGUI();
    }

    public static void GameGUI(){
        final int WINDOW_HEIGHT = 800;
        final int WINDOW_WIDTH = 800;

        JFrame frame = new JFrame();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Chess game for two");
        frame.setLocationRelativeTo(null);

        ChessSetUp chessSetUp = new ChessSetUp(new Board().getSquares());
        JPanel allButtons = chessSetUp.getButtons();
        frame.add(allButtons);

        ImageIcon logo = new ImageIcon("game/OIP.jpg");
        frame.setIconImage(logo.getImage());

        frame.setVisible(true);
    }
}

class MyActionListener implements ActionListener {

    public void updateBoard(){
        /*
        updates the board representation after board has been updated
         */

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class ChessSetUp extends JButton {
    private final JPanel allButtons = new JPanel();
    public JPanel getButtons(){
        return allButtons;
    }
    ChessSetUp(Square[][] squares){
        allButtons.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                JButton button = new JButton();
                if ((i + j) % 2 != 0) {
                    button.setBackground(Color.decode("#261300"));
                } else {
                    button.setBackground(Color.decode("#FFFFEC"));
                }
                Square square = squares[i][j];
                if(square.isOccupied()){
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

                allButtons.add(button);
            }
        }
    }
}
