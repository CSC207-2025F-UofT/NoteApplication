package interface_adapter.move;

import interface_adapter.ViewModel;
import view.ChessBoardView;

/**
 * The ViewModel for the MoveView.
 */
public class MoveViewModel extends ViewModel<MoveState> {

    public static final String TITLE_LABEL = "Move View";
    private String[][] piece;
    private final String[][] pieces = {
            {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"}, // Black major pieces
            {"♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"}, // Black pawns
            {null, null, null, null, null, null, null, null}, // Empty row with one Valid move
            {null, null, null, null, null, null, null, null}, // Empty row
            {null, null, null, null, null, null, null, null}, // Empty row
            {null, null, null, null, null, null, null, null}, // Empty row
            {"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"}, // White pawns
            {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"}  // White major pieces
    };

    public MoveViewModel() {
        super("move");
        this.piece = pieces;
        setState(new MoveState());
    }

    public String[][] getPieces() {
        return piece;
    }

    public void setPieces(String[][] input) {
        String[][] oldPieces = this.piece; // Save the current state
        this.piece = input; // Update with new state
        support.firePropertyChange("pieces", oldPieces, input);

    }

}
