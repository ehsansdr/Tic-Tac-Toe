import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Const.ConstData.Data.*;
public class Cells extends JPanel implements MouseListener {
    public int playerTurn = 1;
    Graphics2D g2;
    Point mouseClicked = new Point();

    public Cells() {
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

        //I added this becuase we have setStroke(); in bigPanel and
        //that effect on this class paining
        ((Graphics2D) g).setStroke(new BasicStroke(1));

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
                if(cellSate[i][j] == 1 || cellSate[i][j] == 2) {
                    //System.out.println(" i : " + i + "   j : " + j);
                    singDrawing(g2, 2, i, j);
                }
            }
        }
    }


    private void singDrawing(Graphics2D g,int player,int cellRow ,int cellColumn) {
        //System.out.println("singDrawing");

        /**BE CAREFUL

        ROWS:
         0
         1
         2
0COLUMN:    0  1  2
         */
        //cellRow++;
        //cellColumn++;

        /**  BE CAREFUL ABOUT THIS Y IS ABOUT ROWS NOT COLUMN AND X ABOUT ROWS  */
        int xOfSing = cellColumn * (GamePanel_WIDTH / 3) + 27;
        int YOfSing = cellRow * (GamePanel_HEIGHT / 3) + 27;
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

        if(mouseClicked.x < (1 * (GamePanel_WIDTH / 3)) - 1             //x 1 . 2 . 3
                && mouseClicked.y < (1 * (GamePanel_WIDTH / 3)) - 1)    //. 1 . 2 . 3
        {                                                               //. 1 . 2 . 3
            //-1 is beacuse of we dont want to
           //have clicked on white line and get sign in panel just between them
            cellSate[0][0] = playerTurn;
            System.out.println("1 1");
        }else if(  mouseClicked.x > (1 * (GamePanel_WIDTH / 3)) - 1       //. 1 x 2 . 3
                && mouseClicked.x < (2 * (GamePanel_WIDTH / 3)) - 1     //. 1 . 2 . 3
                && mouseClicked.y < (1 * (GamePanel_WIDTH / 3)) - 1)    //. 1 . 2 . 3
        {
            cellSate[0][1] = playerTurn;
            System.out.println("1 2");
        }else if(  mouseClicked.x > (2 * (GamePanel_WIDTH / 3)) - 1       //. 1 . 2 x 3
                && mouseClicked.x < (3 * (GamePanel_WIDTH / 3)) - 1     //. 1 . 2 . 3
                && mouseClicked.y < (1 * (GamePanel_WIDTH / 3)) - 1)    //. 1 . 2 . 3
        {
            cellSate[0][2] = playerTurn;
            System.out.println("1 3");
        }else if(//mouseClicked.x > (1 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                   mouseClicked.y > (1 * (GamePanel_WIDTH / 3)) - 1     //x  .  .
                && mouseClicked.y < (2 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.x < (1 * (GamePanel_WIDTH / 3)) - 1)
        {
            cellSate[1][0] = playerTurn;
            System.out.println("2 1");
        }else if(  mouseClicked.x > (1 * (GamePanel_WIDTH / 3)) - 1       //.  .  .
                && mouseClicked.y > (1 * (GamePanel_WIDTH / 3)) - 1     //.  x  .
                && mouseClicked.x < (2 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.y < (2 * (GamePanel_WIDTH / 3)) - 1)
        {
            cellSate[1][1] = playerTurn;
            System.out.println("2 2");
        }else if(  mouseClicked.x > (2 * (GamePanel_WIDTH / 3)) - 1       //.  .  .
                && mouseClicked.y > (1 * (GamePanel_WIDTH / 3)) - 1     //.  .  x
                && mouseClicked.x < (3 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.y < (2 * (GamePanel_WIDTH / 3)) - 1)
        {
            cellSate[1][2] = playerTurn;
            System.out.println("2 3");
        }else if(  mouseClicked.x > (0 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.y > (2 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.x < (1 * (GamePanel_WIDTH / 3)) - 1     //x  .  .
                && mouseClicked.y < (3 * (GamePanel_WIDTH / 3)) - 1)
        {
            cellSate[2][0] = playerTurn;
            System.out.println("3 1");
        }else if(  mouseClicked.x > (1 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.y > (2 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.x < (2 * (GamePanel_WIDTH / 3)) - 1     //.  x  .
                && mouseClicked.y < (3 * (GamePanel_WIDTH / 3)) - 1)
        {
            cellSate[2][1] = playerTurn;
            System.out.println("3 2");
        }else if(  mouseClicked.x > (2 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.y > (2 * (GamePanel_WIDTH / 3)) - 1     //.  .  .
                && mouseClicked.x < (3 * (GamePanel_WIDTH / 3)) - 1     //.  .  x
                && mouseClicked.y < (3 * (GamePanel_WIDTH / 3)) - 1)
        {
            cellSate[2][2] = playerTurn;
            System.out.println("3 3");
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
