package use_case.add_to_fav;

/**
 * The AddToFavOutputBoundary interface defines the output boundary
 * for the Add to Favorites use case.
 */
public interface AddToFavOutputBoundary {
    /**
     * Prepares a successful response for the operation.
     *
     * @param outputData the data to include in the success response
     * @return a formatted response model
     */
    AddToFavOutputData prepareSuccessResponse(AddToFavOutputData outputData);

    /**
     * Prepares a failure response for the operation.
     *
     * @param errorMessage the error message to include in the response
     * @return a formatted response model
     */
    AddToFavOutputData prepareFailResponse(String errorMessage);
}
