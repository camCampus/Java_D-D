package src.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Panel extends JPanel {

    private float xDelta = 100, yDelta = 100;
    private BufferedImage image;
    private BufferedImage[] afkAnimation;
    private int aniTick, aniIndex, aniSpeed = 15;

    public Panel() {
        importImg();
        loadAnimation();

        setPanelSize();
        addKeyListener(new KeyboardInput(this));
    }

    private void loadAnimation() {
        afkAnimation = new BufferedImage[3];

        for (int i = 0; i < afkAnimation.length; i++) {
            afkAnimation[i] = image.getSubimage(i * 128, 228, 16, 28);
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            image = ImageIO.read(Objects.requireNonNull(is));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(600, 600);
        setPreferredSize(size);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;

    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= afkAnimation.length) {
                aniIndex = 0;
            }
        }
    }

    public void paintComponent(Graphics draw) {
        super.paintComponent(draw);

        updateAnimationTick();
        draw.drawImage(afkAnimation[aniIndex], (int) xDelta, (int) yDelta, 64, 128, null);
    }

}
