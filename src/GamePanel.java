import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Const.ConstData.Data.*;
public class GamePanel extends JPanel implements MouseListener {
    Graphics2D g2;

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
        g2 = (Graphics2D) g;

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

        OSingDrawing(g2);
        XSingDrawing(g2,2,2);
    }


    private void XSingDrawing(Graphics2D g,int cellRow,int cellColumn) {
        /**BE CAREFUL

        ROWS:
         0
         1
         2
COLUMN:    0  1  2
         */
        // 0 OR 1 OR 2 , NOT 3


        int xOfSing = cellRow * (GamePanel_WIDTH / 3) + 27;
        int YOfSing = cellColumn * (GamePanel_HEIGHT / 3) + 27;
        int signWidth = 90;
        g.setColor(xColor);
        g.setStroke(new BasicStroke(18));
        g.drawLine(xOfSing,YOfSing,xOfSing + signWidth,YOfSing + signWidth);// \
        g.drawLine(xOfSing ,YOfSing + signWidth ,xOfSing + signWidth,YOfSing);// /
    }

    public void drawPlayerSing(int player) {

    }

    public void OSingDrawing(Graphics2D g) {

        g.setColor(circleColor);
        g.setStroke(new BasicStroke(signThickness));
        g.drawArc(22, 22, signWidth, signWidth, 0, 360);
    }




    @Override
    public void mouseClicked(MouseEvent e) {

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
