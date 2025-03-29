package use_case.funniest;

public interface FunniestOutputBoundary {
    /**
     * Prepares the success view for the Note related Use Cases.
     * @param funniestOutputData the output data
     */
    void prepareSuccessView(FunniestOutputData funniestOutputData);

    /**
     * Prepares the failure view.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
