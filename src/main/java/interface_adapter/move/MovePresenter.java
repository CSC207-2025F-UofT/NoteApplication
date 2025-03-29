package interface_adapter.move;

import interface_adapter.ViewManagerModel;
import java.util.ArrayList;
import use_case.move.MoveOutputBoundary;
import use_case.move.MoveOutputdata;

/**
 * The presenter for Move use case.
 */
public class MovePresenter implements MoveOutputBoundary {
    private final MoveViewModel moveViewModel;
    private final ViewManagerModel viewManagerModel;

    public MovePresenter(MoveViewModel moveViewModel, ViewManagerModel viewManagerModel) {
        this.moveViewModel = moveViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareMove(MoveOutputdata input) {
        String[][] pieces = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (input.getBoard().isEmpty(new int[] {i, j})) {
                    pieces[7 - i][j] = null;
                } else {
                    if (input.getBoard().getPiece(new int[] {i, j}) instanceof entity.Bishop) {
                        if (input.getBoard().getPiece(new int[] {i, j}).getColor().equals("White")) {
                            pieces[7 - i][j] = "♗";
                        } else {
                            pieces[7 - i][j] = "♝";
                        }
                    }
                    else if (input.getBoard().getPiece(new int[] {i, j}) instanceof entity.Rook) {
                        if (input.getBoard().getPiece(new int[] {i, j}).getColor().equals("White")) {
                            pieces[7 - i][j] = "♖";
                        } else {
                            pieces[7 - i][j] = "♜";
                        }
                    }
                    else if (input.getBoard().getPiece(new int[] {i, j}) instanceof entity.Knight) {
                        if (input.getBoard().getPiece(new int[] {i, j}).getColor().equals("White")) {
                            pieces[7 - i][j] = "♘";
                        } else {
                            pieces[7 - i][j] = "♞";
                        }
                    }
                    else if (input.getBoard().getPiece(new int[] {i, j}) instanceof entity.Pawn) {
                        if (input.getBoard().getPiece(new int[] {i, j}).getColor().equals("White")) {
                            pieces[7 - i][j] = "♙";
                        } else {
                            pieces[7 - i][j] = "♟";
                        }
                    }
                    else if (input.getBoard().getPiece(new int[] {i, j}) instanceof entity.Queen) {
                        if (input.getBoard().getPiece(new int[] {i, j}).getColor().equals("White")) {
                            pieces[7 - i][j] = "♕";
                        } else {
                            pieces[7-i][j]= "♛";
                        }
                    }
                    else if (input.getBoard().getPiece(new int[] {i, j}) instanceof entity.King) {
                        if (input.getBoard().getPiece(new int[] {i, j}).getColor().equals("White")) {
                            pieces[7 - i][j] = "♔";
                        } else {
                            pieces[7 - i][j] = "♚";
                        }
                    }
                }

            }
        }
        ArrayList<int[]> validMoves = input.getValidMoves();
        for (int[] move : validMoves) {
            pieces[7-move[0]][move[1]] = "Valid";
        }

        moveViewModel.setPieces(pieces);
        // present the select chess board
    }

}
