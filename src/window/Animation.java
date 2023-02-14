package src.window;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Animation {

    private BufferedImage[] idleAnim , runAnim;
    private BufferedImage image;
    private int map = 64;
    public BufferedImage[] getIdleAnim() {
        return idleAnim;
    }

    public BufferedImage[] getRunAnim() {
        return runAnim;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Animation() {
        this.idleAnim = new BufferedImage[3];
        this.runAnim = new BufferedImage[3];
    }

    public void importImg() {
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

    public void idleAnim() {
        for (int i = 0; i < idleAnim.length; i++) {
            idleAnim[i] = image.getSubimage(i * 16 + 128, 228, 16, 28);
        }
    }

    public void runAnim() {
        for (int i = 0; i < runAnim.length; i++) {
            runAnim[i] = image.getSubimage(i * 16 + 192, 228, 16, 28);
        }
    }

    public BufferedImage getfloorDraw() {
          return  image.getSubimage(16, 64,16,16);
    }
    public BufferedImage getWallDraw() {
        return  image.getSubimage(32, 16,16,16);
    }

    public BufferedImage getTopWallDraw() {
        return  image.getSubimage(16, 0,16,16);
    }
    public BufferedImage getRedBanner() {return image.getSubimage(16,32,16,16);}
}
