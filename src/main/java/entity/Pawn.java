package entity;

import java.util.ArrayList;

public class Pawn extends ChessPiece {
    public Pawn(String color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Returns all possible moves for a pawn from the given position on an 8x8 chessboard.
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    @Override
    public <T> T getValidMoves() {
        final ArrayList<int[]> validMoves = new ArrayList<>();
        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];

        if (this.getColor().equals("White") && x != 7) {
            validMoves.add(new int[]{x + 1, y - 1});
            validMoves.add(new int[]{x + 1, y + 1});
            validMoves.add(new int[]{x + 1, y});
            if (x == 1) {
                validMoves.add(new int[]{x + 2, y});
            }
        } else if (this.getColor().equals("Black") && x != 0) {
            validMoves.add(new int[]{x - 1, y - 1});
            validMoves.add(new int[]{x - 1, y + 1});
            validMoves.add(new int[]{x - 1, y});
            if (x == 6) {
                validMoves.add(new int[]{x - 2, y});
            }
        }

        return (T) validMoves;
    }
}
