package interface_adapter.daily_puzzle;

import java.util.ArrayList;

import use_case.daily_puzzle.DailyPuzzleOutputBoundary;

/**
 * The presenter for daily puzzles.
 */
public class DailyPuzzlePresenter implements DailyPuzzleOutputBoundary {

    private final DailyPuzzleViewModel dailyPuzzleViewModel;

    public DailyPuzzlePresenter(DailyPuzzleViewModel dailyPuzzleViewModel) {
        this.dailyPuzzleViewModel = dailyPuzzleViewModel;
    }

    /**
     * Prepares the success view for the daily puzzle use case.
     * @param puzzleData contains puzzle setup and solution.
     */
    @Override
    public void prepareSuccessView(ArrayList<String> puzzleData) {

    }

    /**
     * Prepares failure view for daily puzzle.
     * @param errorMessage Explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        dailyPuzzleViewModel.getState().setError(errorMessage);
        dailyPuzzleViewModel.firePropertyChanged();
    }
}
