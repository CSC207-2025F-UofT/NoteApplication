package use_case.move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import entity.Bishop;
import entity.ChessPiece;
import entity.Game;
import entity.King;
import entity.Knight;
import entity.Queen;
import entity.Rook;

/**
 * Move interactor who handles the business logic of move.
 */
public class MoveInteractor implements MoveInputBoundary {
    private final MoveDataAccessInterface moveDataAccessObject;
    private final MoveOutputBoundary moveOutPutBoundary;
    private final Game game;

    public MoveInteractor(MoveDataAccessInterface moveDataAccessObject,
                          MoveOutputBoundary moveOutPutBoundary,
                          Game game) {
        this.moveDataAccessObject = moveDataAccessObject;
        this.moveOutPutBoundary = moveOutPutBoundary;
        this.game = game;
    }

    /**
     * Return a list of valid moves based on the chess game.
     *
     * @param chessPiece the piece
     * @return return valid moves
     */
    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:SuppressWarnings"})
    private ArrayList<int[]> validmoves(ChessPiece chessPiece) {
        final ArrayList<int[]> validList;
        final ArrayList<ArrayList<int[]>> listed;
        if (chessPiece instanceof Knight || chessPiece instanceof King) {
            validList = chessPiece.getValidMoves();
            final Iterator<int[]> iterator = validList.iterator();

            while (iterator.hasNext()) {
                final int[] pos = iterator.next();
                if (game.getBoard().getPiece(pos) != null) {
                    if (game.getBoard().getPiece(pos).getColor().equals(chessPiece.getColor())) {
                        iterator.remove();
                    }
                }
            }
        }
        else if (chessPiece instanceof Bishop || chessPiece instanceof Rook) {
            validList = new ArrayList<>();
            listed = chessPiece.getValidMoves();

            for (int i = 0; i <= 3; i++) {
                for (int[] pos:listed.get(i)) {
                    if (game.getBoard().getPiece(pos) != null) {
                        if (game.getBoard().getPiece(pos).getColor().equals(chessPiece.getColor())) {
                            break;
                        }
                        else {
                            validList.add(pos);
                            break;
                        }
                    }
                    else {
                        validList.add(pos);
                    }
                }
            }

        }
        else if (chessPiece instanceof Queen) {
            validList = new ArrayList<>();
            listed = chessPiece.getValidMoves();
            for (int i = 0; i <= 7; i++) {
                for (int[] pos:listed.get(i)) {
                    if (game.getBoard().getPiece(pos) != null) {
                        if (game.getBoard().getPiece(pos).getColor().equals(chessPiece.getColor())) {
                            break;
                        }
                        else {
                            validList.add(pos);
                            break;
                        }
                    }
                    else {
                        validList.add(pos);
                    }
                }
            }

        }
        else {
            validList = chessPiece.getValidMoves();

            if (game.getBoard().getPiece(validList.get(2)) != null) {
                validList.remove(2);
                if (validList.size() == 3) {
                    validList.remove(2);
                }
            }
            if (validList.get(1)[1] > 7 || validList.get(1)[1] < 0) {
                validList.remove(1);
            }
            else if (game.getBoard().getPiece(validList.get(1)) != null) {
                if (game.getBoard().getPiece(validList.get(1)).getColor().equals(chessPiece.getColor())) {
                    validList.remove(1);
                }
            }
            else {
                validList.remove(1);
            }
            if (validList.get(0)[1] > 7 || validList.get(0)[1] < 0) {
                validList.remove(0);
            }
            else if (game.getBoard().getPiece(validList.get(0)) != null) {
                if (game.getBoard().getPiece(validList.get(0)).getColor().equals(chessPiece.getColor())) {
                    validList.remove(0);
                }
            }
            else {
                validList.remove(0);
            }
        }
        return validList;
    }

    @Override
    public void execute(MoveInputdata position) {
        final int[] pos = position.getPosition();
        if (game.getGameMode()) {
            select(pos);
        }
        else {
            move(pos);
        }
        if (game.getBoard().over().equals("White")) {
            // display white lost
        }
        else if (game.getBoard().over().equals("Black")) {
            // display black lost
        }

    }

    /**
     * Executes the usecase when a piece is selected.
     * @param position the position of the selected piece.
     */
    private void select(int[] position) {
        final ChessPiece piece = game.getBoard().getPiece(position);
        if (piece == null || game.getCurrentPlayer() && game.getBoard().getPiece(position).getColor().equals("Black")
                || !game.getCurrentPlayer() && game.getBoard().getPiece(position).getColor().equals("White")) {
            // Nothing happens since no piece selected
            final MoveOutputdata nulldata = new MoveOutputdata(new ArrayList<>(), game.getBoard());
            moveOutPutBoundary.prepareMove(nulldata);
        }
        else {
            game.setChesspiece_to_move(piece);
            game.switchMode();
            final MoveOutputdata selectdata = new MoveOutputdata(validmoves(piece), game.getBoard());
            moveOutPutBoundary.prepareMove(selectdata);
        }
    }

    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:SuppressWarnings"})
    private void move(int[] pos) {
        final ArrayList<int[]> validmoves = validmoves(game.getChesspiece_to_move());

        if (containsArray(validmoves, pos)) {
            // Move the chess piece to location
            game.getBoard().moveToLocation(pos, game.getChesspiece_to_move());
            final MoveOutputdata movedata = new MoveOutputdata(new ArrayList<>(), game.getBoard());
            moveOutPutBoundary.prepareMove(movedata);
            game.switchMode();
            game.switchTurn();
        }
        else if (game.getBoard().getPiece(pos) instanceof Rook
                && game.getBoard().getPiece(new int[] {pos[0], pos[1] - 1}) == null
                && game.getBoard().getPiece(new int[] {pos[0], pos[1] - 2}) == null
                && game.getBoard().getPiece(new int[] {pos[0], pos[1] - 3}) instanceof King) {
            final ChessPiece temp = game.getBoard().getPiece(pos);
            game.getBoard().moveToLocation(new int[] {pos[0], pos[1] - 1}, game.getChesspiece_to_move());
            game.getBoard().moveToLocation(new int[] {pos[0], pos[1] - 2}, temp);
            final MoveOutputdata movedata = new MoveOutputdata(new ArrayList<>(), game.getBoard());
            moveOutPutBoundary.prepareMove(movedata);
            game.switchMode();
            game.switchTurn();
        }
        else {
            // Attempt to move to a invalid square
            final MoveOutputdata nulldata = new MoveOutputdata(new ArrayList<>(), game.getBoard());
            moveOutPutBoundary.prepareMove(nulldata);
            game.switchMode();

        }
    }

    /**
     * Executes the usecase when a piece is selected.
     * @param list The list of integer arrays to search through.
     * @param target The target array to search for in the list.
     * @return {@code true} if the target array is found in the list, {@code false} otherwise.
     */
    public static boolean containsArray(ArrayList<int[]> list, int[] target) {
        if (list == null || target == null) {
            return false;
        }
        for (int[] array : list) {
            if (Arrays.equals(array, target)) {
                return true;
            }
        }
        return false;
    }
}

