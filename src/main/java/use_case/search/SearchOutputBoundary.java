package use_case.search;

public interface SearchOutputBoundary {
    /**
     * Prepares the success view.
     * @param jokeContent the joke we want to present.
     */
    void prepareSuccessView(SearchOutputData jokeContent);

    /**
     * Prepares the failure view.
     * @param errormessage a message when fails.
     */
    void prepareFailureView(String errormessage);
    // How to determine what is failure or success, depends on the format of API return_value
}
