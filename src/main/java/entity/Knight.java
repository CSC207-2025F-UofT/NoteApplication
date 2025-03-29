package entity;

import java.util.ArrayList;


/**
 * Knight piece.
 */
public class Knight extends ChessPiece {
    public Knight(String color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Returns all possible moves for a knight from the given position on an 8x8 chessboard.
     *
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    @Override
    public <T> T getValidMoves() {
        final ArrayList<int[]> validMoves = new ArrayList<>();
        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];

        final int[][] potentialMoves = {
                {x + 2, y + 1}, {x + 2, y - 1},
                {x - 2, y + 1}, {x - 2, y - 1},
                {x + 1, y + 2}, {x + 1, y - 2},
                {x - 1, y + 2}, {x - 1, y - 2}
        };

        // Add valid moves within board boundaries (0 to 7)
        for (int[] move : potentialMoves) {
            if (move[0] >= 0 && move[0] < 8 && move[1] >= 0 && move[1] < 8) {
                validMoves.add(move);
            }
        }

        return (T) validMoves;
    }
}
