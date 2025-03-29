package entity;

import java.util.ArrayList;


/**
 * King piece.
 */
public class King extends ChessPiece {
    public King(String color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Returns all possible moves for a king from the given position on an 8x8 chessboard.
     *
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    @Override
    public <T> T getValidMoves() {
        final ArrayList<int[]> validMoves = new ArrayList<>();
        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];
        validMoves.add(new int[]{x + 1, y});
        validMoves.add(new int[]{x - 1, y});
        validMoves.add(new int[]{x, y - 1});
        validMoves.add(new int[]{x, y + 1});
        validMoves.removeIf(move -> move[0] < 0 || move[0] >= 8 || move[1] < 0 || move[1] >= 8);
        return (T) validMoves;

    }
}
