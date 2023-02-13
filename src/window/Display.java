package src.window;

public class Display implements Runnable {
    private Panel panel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public Display() {
        panel = new Panel();
        GameWindow gameWindow = new GameWindow(panel);
        panel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
//        double timePerFrame = 1000000000.0 / FPS_SET;
//        long lastFrame = System.nanoTime();
//        long now = System.nanoTime();
//
//        int frames = 0;
//        long lastCheck = System.currentTimeMillis();

//        while (true) {
//
//            now = System.nanoTime();
//            if (now - lastFrame >= timePerFrame) {
//                panel.repaint();
//                lastFrame = now;
//                frames++;
//            }
//
//            if (System.currentTimeMillis() - lastCheck >= 1000) {
//                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS: " + frames);
//                frames = 0;
//            }
//        }

        double drawInterval = 1000000000 / FPS_SET;
        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        double delta = 0;
//
//        long lasTime = System.nanoTime();
//        long currentTime;

        while (gameThread != null) {

//            currentTime = System.nanoTime();
//            delta += (currentTime - lasTime) / drawInterval;
//            lasTime = currentTime;
//            if (delta >= 1) {
//                panel.repaint();
//                delta++;
//            }

            panel.repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
