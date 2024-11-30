package use_case.generate;

public interface GenerateOuputBoundary {
    /**
     * Prepares the success view for the Note related Use Cases.
     * @param jokeContent the output data
     */
    void prepareSuccessView(GenerateOutputData generateOutputData);

    /**
     * Prepares the failure view.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
