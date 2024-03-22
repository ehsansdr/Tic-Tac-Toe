import javax.swing.*;
import java.awt.*;
import static Const.ConstData.Data.*;

public class TicGame implements Runnable {
    JFrame frame = new JFrame();
    JPanel bigPanel = new JPanel();
    GamePanel gamePanel = new GamePanel();

    private int fps = 120;
    private int UPS = 120;
    Thread gameLoopThread;


    public TicGame() {
        frameCreation();
        bigPanelCreation();
        addingComponents();


        gameLoopThread = new Thread(this);
        gameLoopThread.start();

    }
    @Override
    public void run(){
        double timePerFrame = 1000000000.0 / fps;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                //put your statement in this part

                //

                /** DO NOT OMIT THESE TWO STATEMENT*/
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {//for Fps
                //put your statement in this part


                //

                /** DO NOT OMIT THESE TWO STATEMENT*/
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {//every 1 sec
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames +" | " + updates );
                frames = 0;
                updates = 0;
            }
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
        frame.add(gamePanel);
    }
}
