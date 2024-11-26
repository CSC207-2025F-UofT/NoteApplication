package use_case.add_to_fav;

/**
 * Represents the output data for the Add to Favorites use case.
 */
public class AddToFavOutputData {
    private final String message;

    /**
     * Constructs an AddToFavOutputData with the specified message.
     *
     * @param message the message describing the result of the operation
     */
    public AddToFavOutputData(String message) {
        this.message = message;
    }

    /**
     * Gets the message describing the result of the operation.
     *
     * @return the result message
     */
    public String getMessage() {
        return message;
    }
}
