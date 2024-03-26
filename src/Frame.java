import javax.swing.*;
import java.awt.*;

import static Const.ConstData.Data.*;

public class Frame extends JFrame {
    BigPanel bigPanel;
    Cells cells = new Cells();
    ImageIcon logo = new ImageIcon("tic-tac.1024x1024.png");

    public Frame(BigPanel bigPanel, Cells cells) throws HeadlessException {
        this.bigPanel = bigPanel;
        this.cells = cells;

        frameCreation();

        addingComponents();

    }



    private void frameCreation() {
        this.setTitle("Tic Tac Toe");
        this.setIconImage(logo.getImage());
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(frameBackground);
        this.setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(new Color(0xF0FF3A));
        g.drawString("fff",50,100);
    }

    private void addingComponents() {
        this.add(bigPanel);

    }
}
