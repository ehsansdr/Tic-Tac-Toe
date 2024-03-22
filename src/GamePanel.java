import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Const.ConstData.Data.*;
public class GamePanel extends JPanel implements MouseListener {

    public GamePanel() {
        setLocation(0,upper_gap);
        setSize(new Dimension(GamePanel_WIDTH,GamePanel_HEIGHT));
        setBackground(gamePanelBackground);
        addMouseListener(this);

        setLayout(null);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(gamePanelLinesBackground);

        //vertical lines
        g.drawLine(0,0,0,GamePanel_HEIGHT);//first vertical line
        for (int i = 1; i <= 2;i++){
            g.drawLine(i * (GamePanel_WIDTH / 3 - 1),0,i * (GamePanel_WIDTH / 3 - 1),GamePanel_HEIGHT);
        }
        g.drawLine(GamePanel_WIDTH - 1,0,GamePanel_WIDTH - 1,GamePanel_HEIGHT);//last vertical line


        //horizontal lines
        g.drawLine(0,0,GamePanel_WIDTH,0);//first horizontal line
        for (int i = 1; i <= 2;i++){
            g.drawLine(0,i * (GamePanel_WIDTH / 3 - 1),GamePanel_WIDTH,i * (GamePanel_WIDTH / 3 - 1));
        }
        g.drawLine(0,GamePanel_HEIGHT - 1,GamePanel_WIDTH - 1,GamePanel_HEIGHT - 1);//last horizontal line

        circleSingDrawing(g);
    }

    public void drawPlayerSing(int player) {

    }

    public void circleSingDrawing(Graphics g) {
        //because i couldn't find the draw-oval method with thickness first
        //i draw full circle ,and then I draw same color circle with game panel background
        //it is back circle
        g.setColor(circleColor);
        g.fillArc(13,13,signWidth,signWidth,0,360);

        //and drawing the front circle to have o form circle with inner blank ,but it is not actually
        g.setColor(gamePanelBackground);
        g.fillOval(13 + signThickness ,13 + signThickness,signWidth - (signThickness * 2) ,signWidth - (signThickness * 2));
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X = " + e.getX() + " Y = " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
