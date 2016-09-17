package slidingpuzzle;

import slidingpuzzle.gui.UserInterface;
import slidingpuzzle.logic.SlidingPuzzle;
import slidingpuzzle.tilecreation.TileCreator;

import javax.swing.*;
import java.io.File;

public class main {

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        slidingPuzzle.start();
    }

}
