package use_case.favourite;

public interface FavouriteOutputBoundary {
    /**
     * Prepares the success view for the Note related Use Cases.
     * @param favouriteOutputData the output data
     */
    void prepareSuccessView(FavouriteOutputData favouriteOutputData);

    /**
     * Prepares the failure view.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    void prepareFailureView(String errormessage);
}
