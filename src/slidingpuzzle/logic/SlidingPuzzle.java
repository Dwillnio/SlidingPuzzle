package slidingpuzzle.logic;

import slidingpuzzle.gui.UserInterface;
import slidingpuzzle.tilecreation.TileCreator;

import javax.swing.*;
import java.io.File;

public class SlidingPuzzle {

    private UserInterface userInterface;
    private Tile[][] tiles;
    private TileMovement tileMovement;

    private final static String imagePath = "src/slidingpuzzle/tilecreation/EVA_TEST.png";

    public SlidingPuzzle() {
        TileCreator tileCreator = new TileCreator(new File(imagePath));
        tiles = tileCreator.create();
        tileMovement = new TileMovement(getRemovedTile(tileCreator) , tiles);
    }

    private Tile getRemovedTile(TileCreator tileCreator) {
        for(Tile[] tileRow: tiles) {
            for(Tile tile: tileRow) {
                if(tile.getTargetX() == tileCreator.getImageManipulator().getRemovedTileX()
                        && tile.getTargetY() == tileCreator.getImageManipulator().getRemovedTileY()) {
                    return tile;
                }
            }
        }
        throw new IllegalStateException("EMPTY TILE NOT FOUND");
    }

    public void start() {
        try {
            userInterface = new UserInterface(this, tiles);

            SwingUtilities.invokeLater(userInterface);

            while(userInterface.getDrawingBoard() == null) {
                Thread.sleep(100);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR\n" +  ex.getMessage());
        }
    }

    private boolean checkForWin() {
        for(Tile[] tileRow: tiles) {
            for(Tile tile: tileRow) {
                if(tile.getX() != tile.getTargetX() && tile.getY() != tile.getTargetY()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void handleMouseClick(int x, int y) {
        tileMovement.handleMouseClick(x, y);
        if(checkForWin()) {
            JOptionPane.showMessageDialog(null, "YOU WIN!");
            while(true){
                try {
                    Thread.sleep(200);
                }catch (Exception ex) {}
            }
        }
    }

}
