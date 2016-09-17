package slidingpuzzle.tilecreation;

import javax.swing.*;
import java.awt.*;
import slidingpuzzle.logic.Tile;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileCreator {

    private BufferedImage image;
    private ImageManipulator imageManipulator;

    public final static File standardImage = new File("src/slidingpuzzle/tilecreation/standard_image.jpg");
    public final static File emptyTileImage = new File("src/slidingpuzzle/tilecreation/standard_empty_tile.jpg");

    private final static Random rand = new Random();

    public TileCreator() {
        this(standardImage);
    }

    public TileCreator(File file) {
        try {
            image = ImageIO.read(file);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("FILE READ ERROR\n" + ex.getMessage());
        }
        imageManipulator = new ImageManipulator(image);
    }

    public TileCreator(BufferedImage image) {
        this.image = image;
        imageManipulator = new ImageManipulator(image);
    }

    public Tile[][] create() {
        Tile[][] tiles = new Tile[4][];
        for(int r = 0; r < 4; r++) {
            tiles[r] = new Tile[4];
        }

        List<Integer> coordinates = new ArrayList<Integer>();
        for(int c = 0; c < 16; c++) {
            coordinates.add(c);
        }

        for(int x = 0; x < 4; x++) {

            for(int y = 0; y < 4; y++) {
                int newCoor = rand.nextInt(coordinates.size());
                tiles[x][y] = new Tile(x+1, y+1, coordinates.get(newCoor)/4 + 1, coordinates.get(newCoor)%4 +1, image);
                coordinates.remove(newCoor);
            }

        }

        return tiles;
    }

    public Image getImage() {
        return image;
    }

    public ImageManipulator getImageManipulator() {
        return imageManipulator;
    }

}
