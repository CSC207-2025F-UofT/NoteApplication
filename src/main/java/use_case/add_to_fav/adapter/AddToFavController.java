package use_case.add_to_fav.adapter;

import use_case.add_to_fav.AddToFavInputBoundary;
import use_case.add_to_fav.AddToFavInputData;
import use_case.add_to_fav.AddToFavOutputData;
import use_case.add_to_fav.AddToFavResponseModel;

/**
 * The AddToFavController class handles user requests for adding a joke to their favorites.
 * It delegates the request to the interactor via the input boundary and returns a response
 * to the user interface layer.
 */
public class AddToFavController {
    private final AddToFavInputBoundary interactor;

    /**
     * Constructs an AddToFavController with the specified input boundary (interactor).
     *
     * @param interactor the interactor that handles the business logic for adding to favorites
     */
    public AddToFavController(AddToFavInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Adds a joke to the user's list of favorites.
     *
     * @param username the username of the user
     * @param jokeId   the ID of the joke to add to favorites
     * @return a response model containing the result of the operation
     */
    public AddToFavResponseModel addToFavorites(String username, String jokeId) {
        // Create the input data object for the interactor
        final AddToFavInputData inputData = new AddToFavInputData(username, jokeId);

        // Pass the input data to the interactor
        final AddToFavOutputData outputData = interactor.addToFavorites(inputData);

        // Return the formatted response
        return new AddToFavResponseModel(outputData.getMessage());
    }
}


