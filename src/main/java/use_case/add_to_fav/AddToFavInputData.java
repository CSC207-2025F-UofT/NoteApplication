package use_case.add_to_fav;

/**
 * The AddToFavInputData class represents the input data
 * for the Add to Favorites use case.
 */
public class AddToFavInputData {
    private final String username;
    private final String jokeId;

    /**
     * Constructs an AddToFavInputData with the specified username and joke ID.
     *
     * @param username the username of the user
     * @param jokeId   the ID of the joke to add to favorites
     */
    public AddToFavInputData(String username, String jokeId) {
        this.username = username;
        this.jokeId = jokeId;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the ID of the joke.
     *
     * @return the joke ID
     */
    public String getJokeId() {
        return jokeId;
    }
}
