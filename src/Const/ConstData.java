package Const;

import java.awt.*;

public class ConstData {
     public static class Data{
         public static int[][] cellSate = { //0 is emty ir null, 1 is O , 2 is X
                 {0,0,0},
                 {0,0,0},
                 {0,0,0}
         };
         public int playerTurn = 1;
         public static int timerDuration = 10;//how many second timer should take a long
         public static int timerMonitor = timerDuration - (timerDuration / 10) ;
         public static float clockTimePart;
         public static float currentTimerPosition = 0;
         public static final int FRAME_WIDTH = 450;
         public static final int FRAME_HEIGHT = 600;

         public static final int GamePanel_WIDTH = FRAME_WIDTH - 16;
         public static final int GamePanel_HEIGHT = FRAME_WIDTH - 14;

         public static final int upper_gap = 125;
         public static final Color frameBackground = new Color(0x000000);
         public static final Color bigPanelBackground = new Color(0x151F2A);
         public static final Color gamePanelBackground = new Color(0x043565);
         public static final Color gamePanelLinesBackground = new Color(0xFF9F9F9F, true);
         public static final int signWidth = 100;
         public static final int signThickness = 15;
         public static final Color xColor = new Color(0x9A0A0D);
         public static final Color circleColor = new Color(0x1F7A8C);
         public static final Color timerInnerCircle = new Color(0xF0FF3A);
         public static final Color timerOuterCircle = new Color(0xFFC300);



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
