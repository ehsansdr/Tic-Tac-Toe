package Const;

import java.awt.*;

public class ConstData {
     public static class Data{
         public static int[][] cellSate = { //0 is emty ir null, 1 is O , 2 is X
                 {0,1,0},
                 {0,2,2},
                 {1,1,0}
         };

         public static final int FRAME_WIDTH = 450;
         public static final int FRAME_HEIGHT = 600;

         public static final int GamePanel_WIDTH = FRAME_WIDTH - 16;
         public static final int GamePanel_HEIGHT = FRAME_WIDTH - 14;

         public static final int upper_gap = 125;
         public static final Color frameBackground = new Color(0x000000);
         public static final Color bigPanelBackground = new Color(0x2A343D);
         public static final Color gamePanelBackground = new Color(0x14213D);
         public static final Color gamePanelLinesBackground = new Color(0xE5E5E5);
         public static final int signWidth = 100;
         public static final int signThickness = 15;
         public static final Color xColor = new Color(0xA4161A);
         public static final Color circleColor = new Color(0x1F7A8C);



     }
 //UIManager.put("activeCaption", new javax.swing.plaf.ColorUIResource(
//                Color.gray));
//        JDialog.setDefaultLookAndFeelDecorated(true);


//        UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.black ));
//        UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.WHITE));
//        UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 11));


    //FlatLightLaf.setup(); //setting the look and feel
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23,180,252));
//        frame.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);

//        frame.setDefaultLookAndFeelDecorated(true);
//        frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23,180,252));
//        frame.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);

}
