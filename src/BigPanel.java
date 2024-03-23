import javax.swing.*;
import java.awt.*;

import static Const.ConstData.Data.*;

public class BigPanel extends JPanel {

    Cells cells;
    Graphics2D g2;
    public int timerDuration = 10;//how many second timer should take a long

    BasicStroke timerStroke = new BasicStroke(7);
    JLabel player1Label = new JLabel();
    JLabel player1LabelScore = new JLabel();
    int player1Score = 5;
    JLabel player2Label = new JLabel();
    JLabel player2LabelScore = new JLabel();
    int player2Score = 2;


    public BigPanel(Cells cells) {
//        super(gc);
        this.cells = cells;


        bigPanelCreation();

        player1Label.setText("o");
        player1Label.setFont(new Font("Monospaced",Font.PLAIN,40));
        player1Label.setLocation(52,40);
        player1Label.setSize(180,50);
        player1Label.setForeground(circleColor.darker());
        player1Label.setOpaque(false);

        player1LabelScore.setText(player1Score + "");
        player1LabelScore.setFont(new Font("Source Code Pro",Font.BOLD,80));
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
        player2LabelScore.setFont(new Font("Source Code Pro",Font.BOLD,80));
        player2LabelScore.setLocation(380,1);
        player2LabelScore.setSize(250,70);
        player2LabelScore.setForeground(xColor);
        player2LabelScore.setOpaque(false);

        this.add(player1Label);
        this.add(player2Label);
        this.add(player1LabelScore);
        this.add(player2LabelScore);

        this.add(cells);
    }

    @Override /**  IT DOESN'T WORK  */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g ;

        TimerClock(g2);

        g2.setColor(new Color(0x4F606C));
        g2.setFont(new Font("Source Code Pro",Font.BOLD,40));

        g2.drawString((timerMonitor <= 9 ? "0"+timerMonitor+"" : timerMonitor+""),193,62);
    }

    private void TimerClock(Graphics2D g2) {
        g2.setColor(timerOuterCircle);
        g2.setStroke(timerStroke);
        g2.drawArc(185,15 ,70,70,90,(int) -currentTimerPosition);
        System.out.println(currentTimerPosition);
    }

    private void bigPanelCreation() {
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setLayout(null);
        this.setBackground(bigPanelBackground);
    }


}