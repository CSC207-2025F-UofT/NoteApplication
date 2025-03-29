package use_case.move;

import entity.Board;

import java.util.ArrayList;

public class MoveOutputdata {
    private final ArrayList<int[]> validMoves;
    private final Board board; //This is yet to be changed.

    public MoveOutputdata(ArrayList<int[]> validMoves, Board board) {
        this.validMoves = validMoves;
        this.board = board;
    }

    public ArrayList<int[]> getValidMoves() {
        return validMoves;
    }

    public Board getBoard() {
        return board;
    }
}
