
package use_case.add_to_fav;

import entity.Joke;
import entity.User;

/**
 * The AddToFavDataAccessInterface defines methods for accessing
 * user and joke data in the data storage layer.
 */
public interface AddToFavDataAccessInterface {
    /**
     * Retrieves a user by username.
     *
     * @param username the username of the user
     * @return the User object, or null if not found
     */
    User get(String username);

    String getCurrentUsername();
    /**
     * Saves the updated user to the data storage.
     *
     * @param user the User object to save
     */

    void save(User user);
}