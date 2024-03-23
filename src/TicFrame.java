import javax.swing.*;
import java.awt.*;

import static Const.ConstData.Data.*;
import static Const.ConstData.Data.frameBackground;

public class TicFrame extends JFrame {
    JPanel bigPanel;
    GamePanel gamePanel;
    public TicFrame(GamePanel gamePanel, JPanel bigPanel) {
//        super(gc);
        this.bigPanel = bigPanel;
        this.gamePanel = gamePanel;

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
        this.setTitle("Tic Tac Toe");
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(frameBackground);
        this.setVisible(true);

    }
    private void addingComponents() {
        this.add(bigPanel);
        this.add(gamePanel);
    }
}
