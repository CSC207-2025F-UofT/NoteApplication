package use_case.add_to_fav;

import entity.Joke;
import entity.JokeFactory;
import entity.User;

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
     */
    @Override
    public void executeAddToFav(AddToFavInputData inputData) {
        final User user = dataAccess.get(dataAccess.getCurrentUsername());
        if (user == null) {
            outputBoundary.prepareFailView("User not found.");
        }
        else {
            JokeFactory jokeFactory = new JokeFactory();
            Joke joke = jokeFactory.create(inputData.getJokeContent(), (int) (Math.random()*100));
            joke.setExplanation(inputData.getExplanation());
            user.getFavorites().add(joke);
            dataAccess.save(user);
            outputBoundary.prepareSuccessView("Added");
        }
    }
}
