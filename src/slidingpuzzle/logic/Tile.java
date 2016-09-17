package slidingpuzzle.logic;

import javax.swing.*;
import java.awt.*;

public class Tile {

    private int x;
    private int y;

    private int targetX;
    private int targetY;

    private Image image;

    public Tile(int x, int y, int targetX, int targetY, Image image) {
        this.x = x;
        this.y = y;
        this.targetX = targetX;
        this.targetY = targetY;
        this.image = image;
    }

    public boolean onTarget() {
        return x == targetX && y == targetY;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != getClass()) {
            return false;
        }
        return x == ((Tile)obj).x && y == ((Tile)obj).y && targetX == ((Tile)obj).targetX
                && targetY == ((Tile)obj).targetY;
    }

    public boolean intersects(Tile tile) {
        return x == tile.x && y == tile.y;
    }

    public boolean intersects(int x, int y) {
        return this.x == x && this.y == y;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.drawImage(image, (x-1)*100, (y-1)*100,(x-1)*100 + 100, (y-1)*100 + 100,
                                   (targetX-1)*100, (targetY-1)*100,
                                   (targetX-1)*100 + 100, (targetY-1)*100 + 100 ,null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
