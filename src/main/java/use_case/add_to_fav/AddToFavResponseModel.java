package use_case.add_to_fav;

/**
 * The AddToFavResponseModel class represents the output data
 * for the Add to Favorites use case.
 */
public class AddToFavResponseModel {
    private final String message;

    /**
     * Constructs an AddToFavResponseModel with the specified message.
     *
     * @param message the message describing the result of the operation
     */
    public AddToFavResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
