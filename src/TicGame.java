import javax.swing.*;
import java.awt.*;
import static Const.ConstData.Data.*;

public class TicGame {
    JFrame frame = new JFrame();
    JPanel bigPanel = new JPanel();
    GamePanel gamePanel = new GamePanel();



    public TicGame() {
        frameCreation();
        bigPanelCreation();
        addingComponents();
    }



    private void bigPanelCreation() {
        bigPanel.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        bigPanel.setLayout(null);
        bigPanel.setBackground(bigPanelBackground);
    }

    private void frameCreation() {
        frame.setTitle("Tic Tac Toe");
        frame.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(frameBackground);
        frame.setVisible(true);

    }
    private void addingComponents() {
        frame.add(bigPanel);
        frame.add(gamePanel);
    }
}
