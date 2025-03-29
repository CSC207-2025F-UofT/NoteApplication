package use_case.daily_puzzle;

import java.util.ArrayList;

/**
 * Output data for the daily puzzle use case.
 */
public class DailyPuzzleOutputData {

    private final ArrayList<String> puzzle;

    private final boolean useCaseFailed;

    public DailyPuzzleOutputData(ArrayList<String> puzzle, boolean useCaseFailed) {
        this.puzzle = puzzle;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<String> getPuzzle() {
        return puzzle;
    }
    // could change later to be board and this or the interactor will call for board generation.
}
