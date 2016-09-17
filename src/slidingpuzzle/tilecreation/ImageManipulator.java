package slidingpuzzle.tilecreation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.io.File;

public class ImageManipulator {

    private final BufferedImage image;

    private final int removedTileX;
    private final int removedTileY;

    private final static Random rand = new Random();

    public ImageManipulator(BufferedImage image) {
        this.image = image;
        removedTileX = rand.nextInt(4) +1;
        removedTileY = rand.nextInt(4) +1;
        createNewImage();
    }

    private void createNewImage() {
        Graphics2D graphics = image.createGraphics();
        try {
            graphics.drawImage(ImageIO.read(TileCreator.emptyTileImage), (removedTileX-1)*100, (removedTileY-1)*100 ,null);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR ON MISSING IMAGE PIECE CREATION\n" + ex.getMessage());
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getRemovedTileX() {
        return removedTileX;
    }

    public int getRemovedTileY() {
        return removedTileY;
    }

}
