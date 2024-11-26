package use_case.add_to_fav.adapter;

import use_case.add_to_fav.AddToFavOutputBoundary;
import use_case.add_to_fav.AddToFavOutputData;

/**
 * The AddToFavPresenter class formats the output of the Add to Favorites use case
 * for the view layer.
 */
public class AddToFavPresenter implements AddToFavOutputBoundary {

    /**
     * Prepares a success response for the Add to Favorites use case.
     *
     * @param outputData the output data containing the success message
     * @return the formatted output data
     */
    @Override
    public AddToFavOutputData prepareSuccessResponse(AddToFavOutputData outputData) {
        // Simply return the output data for success cases (can format further if needed)
        return outputData;
    }

    /**
     * Prepares a failure response for the Add to Favorites use case.
     *
     * @param errorMessage the error message describing the failure
     * @return the formatted output data with the error message
     */
    @Override
    public AddToFavOutputData prepareFailResponse(String errorMessage) {
        // Return an output data object with the error message
        return new AddToFavOutputData(errorMessage);
    }
}
