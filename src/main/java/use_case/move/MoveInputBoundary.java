package use_case.move;

/**
 * Input Boundary for actions which are related to moving.
 */
public interface MoveInputBoundary {
    /**
     * Executes the move use case.
     * @param moveInputData the input data
     */
    void execute(MoveInputdata moveInputData);
}
