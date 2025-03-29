package entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Queen Class.
 */
public class Queen extends ChessPiece {
    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Returns all possible moves for a bishop from the given position on an 8x8 chessboard.
     *
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    @SuppressWarnings({"checkstyle:CyclomaticComplexity", "checkstyle:MagicNumber", "checkstyle:SuppressWarnings"})
    public <T> T getValidMoves() {
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

        final ArrayList<int[]> upMoves = new ArrayList<>();
        final ArrayList<int[]> downMoves = new ArrayList<>();
        final ArrayList<int[]> leftMoves = new ArrayList<>();
        final ArrayList<int[]> rightMoves = new ArrayList<>();

        for (int j = y - 1; j >= 0; j--) {
            upMoves.add(new int[] {x, j});
        }

        for (int j = y + 1; j < 8; j++) {
            downMoves.add(new int[] {x, j});
        }

        for (int j = x - 1; j >= 0; j--) {
            leftMoves.add(new int[] {j, y});
        }

        for (int j = x + 1; j < 8; j++) {
            rightMoves.add(new int[] {j, y});
        }

        validMoves.add(upMoves);
        validMoves.add(downMoves);
        validMoves.add(leftMoves);
        validMoves.add(rightMoves);
        return (T) validMoves;
    }
}
