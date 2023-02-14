package src.window;

public class DisplayGameAnimation implements Runnable {
    private Panel panel;
    private Thread gameThread;
    private GameWindow gameWindow;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private int scrollPos;


    public DisplayGameAnimation(Panel panel) {
        this.scrollPos = 0;
        this.panel = panel;
        this.gameWindow = new GameWindow(panel);
        panel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

            while (gameThread != null) {
                if (panel.getMoving()) {
                    this.gameWindow.goTo((int)panel.getxDelta(), 0);
                }

                long now = System.currentTimeMillis();
                panel.repaint();
                long afterDraw = System.currentTimeMillis();
                long delta = afterDraw - now;
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
    }
}
