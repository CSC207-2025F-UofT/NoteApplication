package entity;

import java.util.ArrayList;

/**
 * The class that defines the rook piece.
 */
public class Rook extends ChessPiece {
    public Rook(String color, int x, int y) {
        super(color, x, y);
    }
    /**
     * Return valid moves.
     */

    @Override
    public <T> T getValidMoves() {
        final ArrayList<ArrayList<int[]>> validMoves = new ArrayList<>();

        ArrayList<int[]> upMoves = new ArrayList<>();
        ArrayList<int[]> downMoves = new ArrayList<>();
        ArrayList<int[]> leftMoves = new ArrayList<>();
        ArrayList<int[]> rightMoves = new ArrayList<>();

        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];

        for (int i = y - 1; i >= 0; i--) {
            upMoves.add(new int[] {x, i});
        }

        for (int i = y + 1; i < 8; i++) {
            downMoves.add(new int[] {x, i});
        }

        for (int i = x - 1; i >= 0; i--) {
            leftMoves.add(new int[] {i, y});
        }

        for (int i = x + 1; i < 8; i++) {
            rightMoves.add(new int[] {i, y});
        }

        validMoves.add(upMoves);
        validMoves.add(downMoves);
        validMoves.add(leftMoves);
        validMoves.add(rightMoves);

        return (T) validMoves;
    }

}
