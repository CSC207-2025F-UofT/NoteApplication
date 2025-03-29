package interface_adapter.daily_puzzle;

import use_case.daily_puzzle.DailyPuzzleInputboundary;

/**
 * Controller for the daily puzzle use case.
 */
public class DailyPuzzleController {

    private DailyPuzzleInputboundary dailyPuzzleInteractor;

    public DailyPuzzleController(DailyPuzzleInputboundary interactor) {
        this.dailyPuzzleInteractor = interactor;
    }

    /**
     * Executes the daily puzzle use case.
     */
    public void execute() {
        dailyPuzzleInteractor.executeDailyPuzzle();
    }
}
