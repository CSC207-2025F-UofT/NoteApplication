package use_case.add_to_fav;

/**
 * The AddToFavInputData class represents the input data
 * for the Add to Favorites use case.
 */
public class AddToFavInputData {
    private final String jokeContent;
    private final String explanation;

    /**
     * Constructs an AddToFavInputData with the specified username and joke ID.
     *
     * @param jokeContent the username of the user
     * @param explanation   the ID of the joke to add to favorites
     */
    public AddToFavInputData(String jokeContent, String explanation) {
        this.jokeContent = jokeContent;
        this.explanation = explanation;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user
     */
    public String getJokeContent() {
        return jokeContent;
    }

    /**
     * Gets the ID of the joke.
     *
     * @return the joke ID
     */
    public String getExplanation() {
        return explanation;
    }
}
