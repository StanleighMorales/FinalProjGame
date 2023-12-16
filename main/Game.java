package main;

public class Game implements Runnable{
    private GameWindow gamewindow;
    private GamePanel gamepanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    public Game() {


        gamepanel = new GamePanel();
        gamewindow = new GameWindow(gamepanel);
        gamepanel.requestFocus();
        startGameLoop();

    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 /FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frameRate = 0;
        long lastCheck = System.currentTimeMillis();

        while (true){

            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){

                gamepanel.repaint();
                lastFrame = now;
                frameRate++;

            }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: "+frameRate);
                frameRate = 0;
            }
        }
    }
}
