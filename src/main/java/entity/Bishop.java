package entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The bishop class.
 */
public class Bishop extends ChessPiece {
    public Bishop(String color, int xCoord, int yCoord) {
        super(color, xCoord, yCoord);
    }

    /**
     * Returns all possible moves for a bishop from the given position on an 8x8 chessboard.
     *
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    @SuppressWarnings({"unchecked", "checkstyle:MagicNumber", "checkstyle:SuppressWarnings"})
    @Override
    public <T> T getValidMoves() {
        // Create an ArrayList to hold four ArrayLists (one for each direction)
        final ArrayList<ArrayList<int[]>> validMoves = new ArrayList<>();

        // Initialize four ArrayLists for each diagonal direction
        final ArrayList<int[]> upLeft = new ArrayList<>();
        final ArrayList<int[]> upRight = new ArrayList<>();
        final ArrayList<int[]> downLeft = new ArrayList<>();
        final ArrayList<int[]> downRight = new ArrayList<>();

        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];

        // Up-Left Diagonal
        int i = 1;
        while (x - i >= 0 && y - i >= 0) {
            upLeft.add(0, new int[]{x - i, y - i});
            i++;
        }

        // Up-Right Diagonal
        i = 1;
        while (x + i < 8 && y - i >= 0) {
            upRight.add(0, new int[]{x + i, y - i});
            i++;
        }

        // Down-Left Diagonal
        i = 1;
        while (x - i >= 0 && y + i < 8) {
            downLeft.add(0, new int[]{x - i, y + i});
            i++;
        }

        // Down-Right Diagonal
        i = 1;
        while (x + i < 8 && y + i < 8) {
            downRight.add(0, new int[]{x + i, y + i});
            i++;
        }
        Collections.reverse(upLeft);
        Collections.reverse(upRight);
        Collections.reverse(downLeft);
        Collections.reverse(downRight);
        validMoves.add(upLeft);
        validMoves.add(upRight);
        validMoves.add(downLeft);
        validMoves.add(downRight);

        return (T) validMoves;
    }
}
