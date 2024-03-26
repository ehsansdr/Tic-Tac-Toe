import javax.swing.*;
import java.awt.*;
import static Const.ConstData.Data.*;

public class GameLoop implements Runnable {
    Frame frame;
    BigPanel bigPanel;
    Cells cells = new Cells();
    private int fps = 40;
    private int UPS = 120;
    private int timerDurationFPS = 120;//we use this var to control upper timer of our bigPanel
    Thread gameLoopThread;

    public GameLoop() {
        bigPanel = new BigPanel(cells);
        frame = new Frame(bigPanel,cells);

        gameLoopThread = new Thread(this);
        gameLoopThread.start();

        clockTimePart = timerDuration * timerDurationFPS;
    }
    @Override
    public void run(){
        double timePerFrame = 1000000000.0 / fps;
        double timePerUpdate = 1000000000.0 / UPS;
        double perTimerDuration = 1000000000.0 / timerDurationFPS;

        long previousTime = System.nanoTime();



        int frames = 0;
        int updates = 0;
        int timerDurationIfController = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;
        double deltaTimer = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            deltaTimer += (currentTime - previousTime) / perTimerDuration;
            previousTime = currentTime;

//            if (deltaU >= 1) {
//                //put your statement in this part
//
//                //
//
//                /** DO NOT OMIT THESE TWO STATEMENT*/
//                updates++;
//                deltaU--;
//            }

            if (deltaTimer >= 1) {//for Fps of timer
                //put your statement in this part
                currentTimerPosition += 360 /  clockTimePart;
                cells.repaint();
                bigPanel.repaint();

                //

                /** DO NOT OMIT THESE TWO STATEMENT*/
                deltaTimer--;
            }

            //this if control the number that show in timer and player time chance
            if (System.currentTimeMillis() - lastCheck > 1000) {//every 1 sec
                lastCheck = System.currentTimeMillis();

                timerMonitor--;

                if (timerMonitor < 1){
                    currentTimerPosition = 0;
                    timerMonitor = timerDuration;
                    currentTimerPosition = 0;

                    //if player lost his time the turn goes to another player
                    if (playerTurn == 1){
                        playerTurn = 2;
                        System.out.println("player 1 lost his time");
                        System.out.println("CURRENT playerTurn : " + playerTurn);
                    }else if (playerTurn == 2){
                        playerTurn = 1;
                        System.out.println("player 1 lost his time");
                        System.out.println("CURRENT playerTurn : " + playerTurn);
                    }

                    //if all cells is full and no one won after time duration new match begin
                    if (cells.turnTimeCounter >= 9){
                        System.out.println("\nDRAW\n");
                        cells.newRound();
                    }

                }


            }
//            if (System.currentTimeMillis() - lastCheck >= 1000) {//every 1 sec
//                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS: " + frames +" | " + updates );
//                frames = 0;
//                updates = 0;
//            }
        }
    }
    private void bigPanelCreation() {
        bigPanel.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        bigPanel.setLayout(null);
        bigPanel.setBackground(bigPanelBackground);
    }
    private void frameCreation() {
        frame.setTitle("Tic Tac Toe");
        frame.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(frameBackground);
        frame.setVisible(true);

    }
    private void addingComponents() {
        frame.add(bigPanel);
        frame.add(cells);
    }


}
