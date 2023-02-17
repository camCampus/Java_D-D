package src.window;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Animation {

    private BufferedImage[] idleAnim , runAnim , chestAnim, dragonAnim;
    private BufferedImage image, dragonImage;
    private int map = 64;


    public Animation() {
        this.idleAnim = new BufferedImage[3];
        this.runAnim = new BufferedImage[3];
        this.chestAnim = new BufferedImage[2];
        this.dragonAnim = new BufferedImage[7];
    }

    public void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            this.image = ImageIO.read(Objects.requireNonNull(is));
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
    public void importDragon() {
        InputStream is = getClass().getResourceAsStream("/GreatRedWyrmIdleSide.png");
        try {
            this.dragonImage = ImageIO.read(Objects.requireNonNull(is));
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

    public void idleAnim() {
        for (int i = 0; i < idleAnim.length; i++) {
            this.idleAnim[i] = this.image.getSubimage(i * 16 + 128, 228, 16, 28);
        }
    }

    public void runAnim() {
        for (int i = 0; i < runAnim.length; i++) {
            this.runAnim[i] = this.image.getSubimage(i * 16 + 192, 228, 16, 28);
        }
    }

    public void chestAnim() {
        for (int i = 0; i < chestAnim.length; i++) {
            this.chestAnim[i] = this.image.getSubimage(i * 16 + 304, 320, 16, 28);
        }
    }

    public void dragonAnime() {
        for (int i = 0; i < dragonAnim.length; i++) {
            this.dragonAnim[i] = this.dragonImage.getSubimage(i * 16 , 0, 32, 32);
        }
    }

    public BufferedImage[] getDragonAnim() {
        return dragonAnim;
    }

    public BufferedImage getfloorDraw() {
          return  image.getSubimage(16, 64,16,16);
    }
    public BufferedImage getWallDraw() {
        return  image.getSubimage(32, 16,16,16);
    }

    public BufferedImage[] getChestAnim() {
        return chestAnim;
    }

    public BufferedImage dragIMG() {return dragonImage.getSubimage(0,0,32,32);}
    public BufferedImage getTopWallDraw() {
        return  image.getSubimage(16, 0,16,16);
    }
    public BufferedImage getRedBanner() {return image.getSubimage(16,32,16,16);}

    public BufferedImage[] getIdleAnim() {
        return idleAnim;
    }

    public BufferedImage[] getRunAnim() {
        return runAnim;
    }

    public BufferedImage getImage() {
        return image;
    }
}
