package src.window;

import src.board.cell.Cell;
import src.board.cell.LootCell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class Panel extends JPanel {

    private float xDelta = 0, yDelta = 65;

    private int aniTick, aniIndex, aniSpeed = 15;
    private Animation animation;
    private boolean moving;
    private int map = 66;

    private GameWindow gameWindow;

    private List<Cell> gameBoard;


    public Panel() {
        this.gameBoard = null;
        this.animation = new Animation();
        this.animation.importImg();
        this.animation.importDragon();

        animation.runAnim();
        animation.idleAnim();
        animation.chestAnim();

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
        this.xDelta = value;
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



    public void paintComponent(Graphics draw) {
        super.paintComponent(draw);
        BufferedImage[] select = selectAnimation(this.moving);
        BufferedImage[] chest = animation.getChestAnim();
        BufferedImage[] dragon = animation.getDragonAnim();

        updateAnimationTick(select);
        updateAnimationTick(chest);
        //updateAnimationTick(dragon);

        this.gameWindow.goTo((int) xDelta, 0);


        draw.drawImage(animation.getfloorDraw(), 0, 80, 64, 64, null);
        draw.drawImage(animation.getfloorDraw(), 0, 144, 64, 64, null);
        draw.drawImage(animation.getfloorDraw(), 0, 208, 64, 64, null);
        draw.drawImage(animation.getWallDraw(), 0, 16, 64, 64, null);
        draw.drawImage(animation.getTopWallDraw(), 0, -48, 64, 64, null);
        draw.drawImage(animation.getWallDraw(), 0, 256, 64, 64, null);
        draw.drawImage(animation.getTopWallDraw(), 0, -48 + 240, 64, 64, null);


        for (int i = 0; i < this.map; i++) {
            draw.drawImage(animation.getfloorDraw(), 64 * i, 80, 64, 64, null);
            draw.drawImage(animation.getfloorDraw(), 64 * i, 144, 64, 64, null);
            draw.drawImage(animation.getfloorDraw(), 64 * i, 208, 64, 64, null);
            draw.drawImage(animation.getWallDraw(), 64 * i, 16, 64, 64, null);
            draw.drawImage(animation.getTopWallDraw(), 64 * i, -48, 64, 64, null);
            draw.drawImage(animation.getTopWallDraw(), 64 * i, -48 + 240, 64, 64, null);
            draw.drawImage(animation.getWallDraw(), 64 * i, 256, 64, 64, null);

        }

        draw.drawImage(animation.getRedBanner(), 500, 16, 64, 64, null);
        draw.drawImage(animation.getRedBanner(), 4144, 16, 64, 64, null);



        if (this.gameBoard != null) {
            for (int i=0; i < this.gameBoard.size(); i++) {
                Cell cell = this.gameBoard.get(i);
                if (cell instanceof LootCell) {
                    draw.drawImage(chest[aniIndex], i*64, (int)yDelta, 64, 128, null);
                }
            }
        }

        draw.drawImage(animation.dragIMG(), 4080, 65, 64, 128, null);
        //draw.drawImage(dragon[aniIndex], 4080, (int) yDelta, 64, 128, null);
        draw.drawImage(select[aniIndex], (int) xDelta, (int) yDelta, 64, 128, null);
    }
    public float getxDelta() {
        return xDelta;
    }

    public void setGameBoard(List<Cell> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public boolean getMoving() {
        return this.moving;
    }
}
