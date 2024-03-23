import javax.swing.*;
import java.awt.*;

import static Const.ConstData.Data.*;

public class BigPanel extends JPanel {

    Cells cells;
    Graphics2D g2;


    public BigPanel(Cells cells) {
//        super(gc);
        this.cells = cells;


        bigPanelCreation();
    }

    @Override /**  IT DOESN'T WORK  */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        g2.setColor(circleColor);
        g2.drawString("Player1 : " , 20 , 20);
        System.out.println("hhh");
    }

    private void bigPanelCreation() {
        this.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setLayout(null);
        this.setBackground(bigPanelBackground);
    }


}
