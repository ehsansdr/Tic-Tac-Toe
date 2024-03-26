import javax.swing.*;
import java.awt.*;

import static Const.ConstData.Data.*;

public class BigPanel extends JPanel {

    Cells cells;
    Graphics2D g2;
    public int timerDuration = 10;//how many second timer should take a long

    BasicStroke timerStroke = new BasicStroke(7);
    JLabel player1Label = new JLabel();
    JLabel player2Label = new JLabel();



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

        player2LabelScore.setText(player2Score + "");
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

        //this if statements so the line that shows the player turn
        int XOfLine = 0;
        g2.setStroke(new BasicStroke(4));
        if (playerTurn == 2){

            XOfLine = 10;
            g2.setColor(circleColor);
            g2.drawLine(XOfLine,90, XOfLine + 65,90);
            xColor.darker();
        } else if (playerTurn == 1) {

            XOfLine = 363;
            g2.setColor(xColor);
            g2.drawLine(XOfLine,90, XOfLine + 63,90);
            circleColor.darker();
        }

        TimerClock(g2);

        g2.setColor(new Color(0x4F606C));
        g2.setFont(new Font("Source Code Pro",Font.BOLD,40));

        g2.drawString((timerMonitor <= 9 ? "0"+timerMonitor+"" : timerMonitor+""),193,62);
    }

    private void TimerClock(Graphics2D g2) {
        //if the time is almost running out the color goes to reddish
        //we calculate that base on angle and arc not by time because have calculation more
        if (currentTimerPosition >= 280){
            g2.setColor(new Color(0xA20000));
        }else{
            g2.setColor(timerOuterCircle);
        }
        g2.setStroke(timerStroke);
        g2.drawArc(185,15 ,70,70,90,(int) -currentTimerPosition);
    }

    private void bigPanelCreation() {
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setLayout(null);
        this.setBackground(bigPanelBackground);
    }


}
