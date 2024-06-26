package Const;

import javax.swing.*;
import java.awt.*;

public class ConstData {
     public static class Data{
         public static int[][] cellSate = { //0 is emty ir null, 1 is O , 2 is X
                 {0,0,0},
                 {0,0,0},
                 {0,0,0}
         };
         public static int playerTurn = 2;//0 is for waiting or no one playing,1 means it player 1 turn ,2 is for player 2
         public static int player1Score = 0;
         public static JLabel player1LabelScore = new JLabel();
         public static int timerDuration = 10;//how many second timer should take a long
         public static int player2Score = 0;
         public static JLabel player2LabelScore = new JLabel();
         public static int timerMonitor = timerDuration;
         public static float clockTimePart;
         public static float currentTimerPosition = 0;
         public static final int FRAME_WIDTH = 450;
         public static final int FRAME_HEIGHT = 600;

         public static final int GamePanel_WIDTH = FRAME_WIDTH - 16;
         public static final int GamePanel_HEIGHT = FRAME_WIDTH - 14;

         public static final int upper_gap = 125;
         public static final Color frameBackground = new Color(0x000000);
         public static final Color bigPanelBackground = new Color(0xDEE2E6);
         public static final Color gamePanelBackground = new Color(0xDEE2E6);
         public static final Color gamePanelLinesBackground = new Color(0xFF212529, true);
         public static final int signWidth = 100;
         public static final int signThickness = 15;
         public static final Color xColor = new Color(0x6C757D);
         public static final Color circleColor = new Color(0x6C757D);
         public static final Color timerInnerCircle = new Color(0x343A40);
         public static final Color timerOuterCircle = new Color(0x212529);



     }
}
