import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Const.ConstData.Data.*;
public class GamePanel extends JPanel implements MouseListener {
    Graphics2D g2;
    Point mouseClicked = new Point();

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

        for (int i = 0; i < 3;i++){/**   BUG */
            for (int j = 0;j < 3 ;j++){
                if(cellSate[i][j] == 1 || cellSate[i][j] == 2){
                    System.out.println(" i : " + i + "   j : " + j);
                    singDrawing(g2,cellSate[i][j],i,j);
                }
            }
        }
    }


    private void singDrawing(Graphics2D g,int player,int cellRow ,int cellColumn) {
        System.out.println("singDrawing");

        /**BE CAREFUL

        ROWS:
         0
         1
         2
0COLUMN:    0  1  2
         */
        cellRow++;
        cellColumn++;
        int xOfSing = cellRow * (GamePanel_WIDTH / 3) + 27;
        int YOfSing = cellColumn * (GamePanel_HEIGHT / 3) + 27;
        int signWidth = 90;
        // 0 OR 1 OR 2 , NOT 3
        if(player == 2) {
            g.setColor(xColor);
            g.setStroke(new BasicStroke(18));
            g.drawLine(xOfSing, YOfSing, xOfSing + signWidth, YOfSing + signWidth);// \
            g.drawLine(xOfSing, YOfSing + signWidth, xOfSing + signWidth, YOfSing);// /
        }
        else if(player == 1){
            g.setColor(circleColor);
            g.setStroke(new BasicStroke(signThickness));
            g.drawArc(cellRow * (GamePanel_WIDTH / 3) + 22,
                    cellColumn * (GamePanel_HEIGHT / 3) + 22,
                    signWidth, signWidth, 0, 360);
        }
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
        mouseClicked.x = e.getX();
        mouseClicked.y = e.getY();

        if(mouseClicked.x < (GamePanel_WIDTH / 3) - 1 && mouseClicked.y < (GamePanel_WIDTH / 3) - 1){//-1 is beacuse of we dont want to
            //have clicked on white line and get sign in panel just between them
            cellSate[0][0] = 1;
            System.out.println("0 0");
        }

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
