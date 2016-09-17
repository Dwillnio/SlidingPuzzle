package slidingpuzzle.gui;

import slidingpuzzle.logic.Tile;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {

    private Tile[][] tiles;

    public DrawingBoard(Tile[][] tiles) {
        this.tiles = tiles;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for(Tile[] tileRow: tiles) {
            for(Tile tile: tileRow) {
                tile.draw(graphics);
            }
        }
    }

    public void update() {
        super.repaint();
    }

}
