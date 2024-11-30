package entity;

import java.util.List;

/**
 * Factory for creating users.
 */
public class UserFactory {
    /**
     * Creates a new User.
     *
     * @param name      the name of the new user
     * @param password  the password of the new user
     * @param favorites the list of user's favourite joke(s)
     * @return the new user
     */
    User create(String name, String password, List<Joke> favorites) {
        return new User(name, password, favorites);
    }

    User create(String name, String password) {
        return new User(name, password);
    }

}
