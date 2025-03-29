package use_case.add_to_fav.adapter;

import use_case.add_to_fav.*;

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
     * @param jokeContent the username of the user
     * @param explanation   the ID of the joke to add to favorites
     * @return a response model containing the result of the operation
     */
    public void execute(String jokeContent, String explanation) {
        final AddToFavInputData inputData = new AddToFavInputData(jokeContent, explanation);
        interactor.executeAddToFav(inputData);
    }
}
