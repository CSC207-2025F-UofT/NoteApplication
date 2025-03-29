package use_case.showProfile;

import entity.User;

/**
 * DAO for the ShowProfile Use Case.
 */
public interface ShowProfileUserDataAccessInterface {

    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);

    /**
     * Returns the user with the given username.
     * @param username the username to look up
     * @return the user with the given username
     */
    User get(String username);

}
