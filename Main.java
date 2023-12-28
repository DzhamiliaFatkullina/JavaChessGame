import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class Main {
    public static void main(String[] args) {

        final int WINDOW_HEIGHT = 800;
        final int WINDOW_WIDTH = 800;

        JFrame frame = new JFrame();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Chess game for two");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton chessboard = new JButton();
        chessboard.setLayout(new GridLayout(8, 8));
        frame.add(chessboard);

        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                JButton button = new JButton();
                if ((i + j) % 2 == 0) {
                    button.setBackground(Color.decode("#261300"));
                } else {
                    button.setBackground(Color.decode("#FFFFEC"));
                }
                chessboard.add(button);
            }
        }

        ImageIcon logo = new ImageIcon("OIP.jpg");
        frame.setIconImage(logo.getImage());
    }
}
