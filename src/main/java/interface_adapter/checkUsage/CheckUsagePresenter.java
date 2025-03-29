package interface_adapter.checkUsage;

import use_case.checkUsage.CheckUsageOutputBoundary;
import use_case.checkUsage.CheckUsageOutputData;

/**
 * The presenter for the checkUsage program.
 */
public class CheckUsagePresenter implements CheckUsageOutputBoundary {

    private final CheckUsageViewModel checkUsageViewModel;

    public CheckUsagePresenter(CheckUsageViewModel checkUsageViewModel) {
        this.checkUsageViewModel = checkUsageViewModel;
    }

    /**
     * Prepares the success view for the checking usage related Use Cases.
     *
     * @param checkUsageOutputData the output data
     */
    @Override
    public void prepareSuccessView(CheckUsageOutputData checkUsageOutputData) {
        checkUsageViewModel.getState().setCharacterCount(checkUsageOutputData.getCharacterCount());
        checkUsageViewModel.getState().setCharacterLimit(checkUsageOutputData.getCharacterLimit());
        checkUsageViewModel.getState().setError(null);
        checkUsageViewModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the Translate related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        checkUsageViewModel.getState().setError(errorMessage);
        checkUsageViewModel.firePropertyChanged();
    }
}

