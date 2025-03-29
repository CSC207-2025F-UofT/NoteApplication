package use_case.checkUsage;

import entity.CheckUsage;
import use_case.translateText.DataAccessException;

/**
 * The CheckUsage Interactor.
 */
public class CheckUsageInteractor {

    private final CheckUsageDataAccessInterface dataAccessObject;
    private final CheckUsageOutputBoundary checkUsageOutputBoundary;
    private final CheckUsage checkUsage;

    public CheckUsageInteractor(CheckUsageDataAccessInterface checkUsageDataAccessInterface,
                                CheckUsageOutputBoundary checkUsagePresenter,
                                CheckUsage checkUsage) {
        this.dataAccessObject = checkUsageDataAccessInterface;
        this.checkUsageOutputBoundary = checkUsagePresenter;
        this.checkUsage = checkUsage;
    }

    /**
     * Executes the checkUsage use case.
     * @throws DataAccessException when character count and limit is not accessible.
     */
    public void execute() {

        try {
            checkUsage.setCharacterCount(dataAccessObject.getCharacterCount());
            checkUsage.setCharacterLimit(dataAccessObject.getCharacterLimit());

            if (dataAccessObject.getCharacterCount() == null || (dataAccessObject.getCharacterCount().isEmpty())) {
                checkUsageOutputBoundary.prepareFailView("Cannot access the character count");
            }
            else if (dataAccessObject.getCharacterLimit() == null || (dataAccessObject.getCharacterLimit().isEmpty())) {
                checkUsageOutputBoundary.prepareFailView("Cannot access the character limit");
            }

            else {
                checkUsage.getUsage();
                final CheckUsageOutputData checkUsageOutputData = new CheckUsageOutputData(
                        checkUsage.getCharacterCount(), checkUsage.getCharacterLimit());
                checkUsageOutputBoundary.prepareSuccessView(checkUsageOutputData);
            }
        }
        catch (DataAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
