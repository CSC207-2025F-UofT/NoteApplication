package use_case.add_to_fav;

import entity.User;
import entity.Joke;

/**
 * The AddToFavInteractor class implements the business logic for adding jokes
 * to a user's favorites list. It communicates with the data access layer to
 * retrieve and save data, and uses the output boundary (presenter) to format
 * the response.
 */
public class AddToFavInteractor implements AddToFavInputBoundary {
    private final AddToFavDataAccessInterface dataAccess;
    private final AddToFavOutputBoundary outputBoundary;

    /**
     * Constructs an AddToFavInteractor with the specified data access interface
     * and output boundary (presenter).
     *
     * @param dataAccess     the interface for accessing user and joke data
     * @param outputBoundary the presenter that formats output data
     */
    public AddToFavInteractor(AddToFavDataAccessInterface dataAccess, AddToFavOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Handles the business logic for adding a joke to a user's favorites list.
     *
     * @param inputData the input data containing the username and joke ID
     * @return a response model indicating the result of the operation
     */
    @Override
    public AddToFavOutputData addToFavorites(AddToFavInputData inputData) {
        // Retrieve the user by username
        final User user = dataAccess.getUser(inputData.getUsername());
        if (user == null) {
            return outputBoundary.prepareFailResponse("User not found.");
        }

        // Retrieve the joke by joke ID
        final Joke joke = dataAccess.getJoke(inputData.getJokeId());
        if (joke == null) {
            return outputBoundary.prepareFailResponse("Joke not found.");
        }

        // Attempt to add the joke to the user's favorites
        if (user.addToFavorites()) {
            // Save the updated user in the data store
            dataAccess.saveUser(user);

            // Prepare a success response
            return outputBoundary.prepareSuccessResponse(
                    new AddToFavOutputData("Joke added to favorites successfully!")
            );
        }
        else {
            // Joke was already in the favorites list
            return outputBoundary.prepareFailResponse("Joke is already in the favorites list.");
        }
    }
}
