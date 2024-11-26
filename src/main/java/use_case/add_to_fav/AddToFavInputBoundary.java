package use_case.add_to_fav;

/**
 * The AddToFavInputBoundary interface defines the input boundary
 * for the Add to Favorites use case.
 */
public interface AddToFavInputBoundary {
    /**
     * Adds a joke to a user's favorites list.
     *
     * @param inputData the input data containing the username and joke ID
     * @return a response model indicating the result of the operation
     */
    AddToFavOutputData addToFavorites(AddToFavInputData inputData);
}
