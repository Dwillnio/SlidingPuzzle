package slidingpuzzle.logic;

import slidingpuzzle.gui.UserInterface;

public class TileMovement {

    private Tile[][] tiles;
    private Tile emptyTile;

    public TileMovement(Tile emptyTile, Tile[][] tiles) {
        this.emptyTile = emptyTile;
        this.tiles = tiles;
    }

    private boolean mouseClickInBounds(int x, int y) {
        return x >= 0 && x <= UserInterface.WIDTH && y >= 0 && y <= UserInterface.HEIGHT;
    }

    private boolean clickNextToEmptyTile(int x, int y) {
        int emptyTileX = (emptyTile.getX()-1) *100;
        int emptyTileY = (emptyTile.getY()-1) *100;
        return ((x >= emptyTileX -100 && x <= emptyTileX +200
                   && y >= emptyTileY && y <= emptyTileY +100 ) ||
                 (x >= emptyTileX  && x <= emptyTileX + 100
                   && y >= emptyTileY - 100 && y <= emptyTileY +200 )) &&
                 !(x >= emptyTileX && x <= emptyTileX +100
                   && y >= emptyTileY && y <= emptyTileY +100 );
    }

    private Tile getClickedTile(int x, int y) {
        x = (x/100) + 1;
        y = (y/100) + 1;

        for(Tile[] tileRow: tiles) {
            for(Tile tile: tileRow) {
                if(tile.intersects(x, y)) {
                    return tile;
                }
            }
        }
        return null;
    }

    private void swapWithEmptyTile(Tile tile) {
        int x = emptyTile.getX();
        int y = emptyTile.getY();

        emptyTile.set(tile.getX(), tile.getY());
        tile.set(x, y);
    }

    public void handleMouseClick(int x, int y) {
        if(mouseClickInBounds(x,y) && clickNextToEmptyTile(x,y)) {
            swapWithEmptyTile(getClickedTile(x, y));
        }
    }

}
