package slidingpuzzle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import slidingpuzzle.logic.SlidingPuzzle;
import slidingpuzzle.logic.Tile;

public class UserInterface implements Runnable {

    public final static int HEIGHT = 400;
    public final static int WIDTH = 400;

    private JFrame frame;
    private DrawingBoard drawingBoard;

    private Tile[][] tiles;
    private SlidingPuzzle slidingPuzzle;

    public UserInterface(SlidingPuzzle slidingPuzzles, Tile[][] tiles) {
        this.slidingPuzzle = slidingPuzzles;
        this.tiles = tiles;
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Sliding Puzzle");
        frame.setPreferredSize(new Dimension(WIDTH + 6, HEIGHT + 29));
        frame.setResizable(false);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

        //System.out.println(drawingBoard.getHeight() + "|" + drawingBoard.getWidth());
    }

    private void createComponents(Container container) {
        drawingBoard = new DrawingBoard(tiles);
        drawingBoard.addMouseListener(new MouseClickListener());
        container.add(drawingBoard);
    }

    public void update() {
        drawingBoard.update();
    }

    public DrawingBoard getDrawingBoard() {
        return drawingBoard;
    }

    private class MouseClickListener implements java.awt.event.MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            slidingPuzzle.handleMouseClick(e.getX(), e.getY());
            update();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

}
