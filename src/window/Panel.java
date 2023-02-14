package src.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Panel extends JPanel {

    private float xDelta = 0, yDelta = 65;

    private int aniTick, aniIndex, aniSpeed = 15;
    private Animation animation;
    private boolean moving;
    private int map = 64;
    private int dice = 0;
    private int count = 0;

    public Panel() {
        this.animation = new Animation();
        this.animation.importImg();

        animation.runAnim();
        animation.idleAnim();

        this.setPanelSize();
        addKeyListener(new KeyboardInput(this));
    }


    /**
     * Definit la taille de la fenetre d'affichage
     */
    private void setPanelSize() {
        Dimension size = new Dimension(this.map * 64, 5 * 64);
        setPreferredSize(size);
    }

    /**
     * Change la position de la frame du joueur sur l'axe X
     *
     * @param value
     */
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

    //Actualise les sprites pour jouer une animation (RUN ou IDLE)
    private void updateAnimationTick(BufferedImage[] anim) {

        this.aniTick++;
        if (this.aniTick >= this.aniSpeed) {
            this.aniTick = 0;
            this.aniIndex++;
            if (this.aniIndex >= anim.length) {
                this.aniIndex = 0;
            }
        }
    }

    /**
     * Definit si l'animation doit être RUN ou IDLE
     *
     * @param moving
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * Selectionne l'annimation en fonction de moving true ou false
     *
     * @param moving
     * @return
     */
    private BufferedImage[] selectAnimation(Boolean moving) {
        BufferedImage[] select;
        if (moving) {
            select = animation.getRunAnim();
        } else {
            select = animation.getIdleAnim();
        }
        return select;
    }

    private void updatePose() {
        if (moving) {
            for (int i = 1; i <= this.dice; i++) {
                xDelta += 16;
            }
        }
    }

    public void paintComponent(Graphics draw) {
        super.paintComponent(draw);
        BufferedImage[] select = selectAnimation(this.moving);
        updateAnimationTick(select);
        updatePose();
        if (this.count > this.dice) {
            this.moving = false;
            this.count = 1;
        }
        this.count++;
        draw.drawImage(animation.getfloorDraw(), 0, 80, 64, 64, null);
        draw.drawImage(animation.getfloorDraw(), 0, 144, 64, 64, null);
        draw.drawImage(animation.getfloorDraw(), 0, 208, 64, 64, null);
        draw.drawImage(animation.getWallDraw(), 0, 16, 64, 64, null);
        draw.drawImage(animation.getTopWallDraw(), 0, -48, 64, 64, null);
        draw.drawImage(animation.getWallDraw(), 0, 256, 64, 64, null);
        draw.drawImage(animation.getTopWallDraw(), 0, -48 + 240, 64, 64, null);


        for (int i = 1; i < this.map; i++) {
            draw.drawImage(animation.getfloorDraw(), 64 * i, 80, 64, 64, null);
            draw.drawImage(animation.getfloorDraw(), 64 * i, 144, 64, 64, null);
            draw.drawImage(animation.getfloorDraw(), 64 * i, 208, 64, 64, null);
            draw.drawImage(animation.getWallDraw(), 64 * i, 16, 64, 64, null);
            draw.drawImage(animation.getTopWallDraw(), 64 * i, -48, 64, 64, null);
            draw.drawImage(animation.getTopWallDraw(), 64 * i, -48 + 240, 64, 64, null);
            draw.drawImage(animation.getWallDraw(), 64 * i, 256, 64, 64, null);

        }

        draw.drawImage(animation.getRedBanner(), 500, 16, 64, 64, null);
        draw.drawImage(animation.getRedBanner(), 3000, 16, 64, 64, null);
        draw.drawImage(select[aniIndex], (int) xDelta, (int) yDelta, 64, 128, null);

    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public float getxDelta() {
        return xDelta;
    }

    public int getDice() {
        return dice;
    }
    public boolean getMoving () {
        return this.moving;
    }
}
