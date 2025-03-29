package use_case.checkUsage;

/**
 * The output boundary for the Translate Text Use Case.
 */
public interface CheckUsageOutputBoundary {
    /**
     * Prepares the success view for the CheckUsage related Use Cases.
     * @param checkUsageOutputData the output data
     */
    void prepareSuccessView(CheckUsageOutputData checkUsageOutputData);

    /**
     * Prepares the failure view for the CheckUsage related Use Cases.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
