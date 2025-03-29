package use_case.daily_puzzle;

import java.util.ArrayList;

/**
 * The daily puzzle interactor.
 */
public class DailyPuzzleInteractor {
    private final PuzzleDataAccessInterface dailyPuzzleDataAccessInterface;
    private final DailyPuzzleOutputBoundary dailyPuzzleOutputBoundary;

    public DailyPuzzleInteractor(PuzzleDataAccessInterface dailyPuzzleDataAccessInterface, DailyPuzzleOutputBoundary dailyPuzzleOutputBoundary) {
        this.dailyPuzzleDataAccessInterface = dailyPuzzleDataAccessInterface;
        this.dailyPuzzleOutputBoundary = dailyPuzzleOutputBoundary;
    }

    /**
     * Executes the use case.
     * @throws RuntimeException if API request fails.
     */
    public void execute() {

        try {

            final ArrayList<String> puzzle = dailyPuzzleDataAccessInterface.getDaily();
            dailyPuzzleOutputBoundary.prepareSuccessView(puzzle);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
