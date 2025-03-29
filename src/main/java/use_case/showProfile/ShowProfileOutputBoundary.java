package use_case.showProfile;

/**
 * The output boundary for the ShowProfile Use Case.
 */
public interface ShowProfileOutputBoundary {

    /**
     * Prepares the success view for the ShowProfile Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(ShowProfileOutputData outputData);

    /**
     * Prepares the failure view for the ShowProfile Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
