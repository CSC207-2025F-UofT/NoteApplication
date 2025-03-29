package interface_adapter.checkUsage;

import use_case.checkUsage.CheckUsageInteractor;

/**
 * The controller for the CheckUsage Use Case.
 */

public class CheckUsageController {

    private final CheckUsageInteractor checkUsageUseCaseInteractor;

    public CheckUsageController(CheckUsageInteractor checkUsageUseCaseInteractor) {
        this.checkUsageUseCaseInteractor = checkUsageUseCaseInteractor;
    }

    /**
     * Executes the CheckUsage Use Case.
     */

    public void execute() {
        checkUsageUseCaseInteractor.execute();
    }
}
