import javax.swing.*;
import java.awt.*;

import static Const.ConstData.Data.*;

public class Frame extends JFrame {
    BigPanel bigPanel;
    Cells cells = new Cells();

    JLabel player1Label = new JLabel();
    JLabel player1LabelScore = new JLabel();
    int player1Score = 0;
    JLabel player2Label = new JLabel();
    JLabel player2LabelScore = new JLabel();
    int player2Score = 0;
    public Frame(BigPanel bigPanel, Cells cells) throws HeadlessException {
        this.bigPanel = bigPanel;
        this.cells = cells;


        frameCreation();

        player1Label.setText("o");
        player1Label.setFont(new Font("Monospaced",Font.PLAIN,40));
        player1Label.setLocation(52,40);
        player1Label.setSize(180,50);
        player1Label.setForeground(circleColor.darker());
        player1Label.setOpaque(false);
        
        player1LabelScore.setText(player1Score + "");
        player1LabelScore.setFont(new Font("Monospaced",Font.BOLD,80));
        player1LabelScore.setLocation(10,5);
        player1LabelScore.setSize(180,70);
        player1LabelScore.setForeground(circleColor);
        player1LabelScore.setOpaque(false);

        player2Label.setText("x");
        player2Label.setFont(new Font("Source Code Pro",Font.PLAIN,40));
        player2Label.setLocation(360,40);
        player2Label.setSize(250,50);
        player2Label.setForeground(xColor.darker());
        player2Label.setOpaque(false);
        
        player2LabelScore.setText(player1Score + "");
        player2LabelScore.setFont(new Font("Monospaced",Font.BOLD,80));
        player2LabelScore.setLocation(380,1);
        player2LabelScore.setSize(250,70);
        player2LabelScore.setForeground(xColor);
        player2LabelScore.setOpaque(false);




        addingComponents();

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

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(new Color(0xF0FF3A));
        g.drawString("fff",50,100);
    }

    private void addingComponents() {
        this.add(cells);
        this.add(player1Label);
        this.add(player2Label);
        this.add(player1LabelScore);
        this.add(player2LabelScore);
        this.add(bigPanel);
    }
}
