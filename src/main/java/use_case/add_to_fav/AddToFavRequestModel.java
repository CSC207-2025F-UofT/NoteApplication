package use_case.add_to_fav;

/**
 * The AddToFavRequestModel class represents the input data
 * for the Add to Favorites use case.
 */
public class AddToFavRequestModel {
    private final String username;
    private final String jokeId;

    /**
     * Constructs an AddToFavRequestModel with the specified username and joke ID.
     *
     * @param username the username of the user
     * @param jokeId   the ID of the joke to add to favorites
     */
    public AddToFavRequestModel(String username, String jokeId) {
        this.username = username;
        this.jokeId = jokeId;
    }

    public String getUsername() {
        return username;
    }

    public String getJokeId() {
        return jokeId;
    }
}
