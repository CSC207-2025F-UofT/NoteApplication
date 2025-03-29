package interface_adapter.move;

import use_case.move.MoveInputBoundary;
import use_case.move.MoveInputdata;
/**
 * The controller for the Move Use Case.
 */

public class MoveController {
    private final MoveInputBoundary moveInteractor;

    public MoveController(MoveInputBoundary moveInteractor) {
        this.moveInteractor = moveInteractor;
    }

    /**
     * Convert the data into ArrayList and delegate the execution to move interactor.
     * @param xcord the horizontal coordinate form 0 to 7
     * @param ycord the horizontal coordinate form 0 to 7
     */
    public void onClick(Integer xcord, Integer ycord) {
        final int[] position = new int[2];
        position[0] = xcord;
        position[1] = ycord;
        final MoveInputdata moveInputdata = new MoveInputdata(position);
        moveInteractor.execute(moveInputdata);
    }
}
