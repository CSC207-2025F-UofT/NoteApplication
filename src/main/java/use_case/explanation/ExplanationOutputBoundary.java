package use_case.explanation;

public interface ExplanationOutputBoundary {
    /**
     * Prepares the success view for the Note related Use Cases.
     * @param explanationOutputData the output data
     */
    void prepareSuccessView(ExplanationOutputData explanationOutputData);

    /**
     * Prepares the failure view.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
