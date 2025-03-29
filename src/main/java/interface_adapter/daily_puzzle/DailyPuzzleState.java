package interface_adapter.daily_puzzle;

import entity.Board;

/**
 * The state for a daily puzzle.
 */
public class DailyPuzzleState {
    private static final String ROOK = "♖";
    private static final String BISHOP = "♗";
    private static final String QUEEN = "♕";
    private static final String KING = "♔";
    private static final String KNIGHT = "♘";
    private static final String PAWN = "♙";
    private Board board;
    private String error;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
