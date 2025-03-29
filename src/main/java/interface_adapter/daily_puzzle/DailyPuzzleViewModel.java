package interface_adapter.daily_puzzle;

import interface_adapter.ViewModel;

/**
 * ViewModel for daily puzzle.
 */
public class DailyPuzzleViewModel extends ViewModel<DailyPuzzleState> {
    public DailyPuzzleViewModel() {
        super("daily puzzle");
        setState(new DailyPuzzleState());
    }
}
