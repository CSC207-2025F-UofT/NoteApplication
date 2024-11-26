package entity;

import java.util.List;

/**
 * The representation of a password-protected user for our program.
 */
public class User {

    private final String name;
    private final String password;
    private List<Joke> favorites;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, List<Joke> favorites) {
        this.name = name;
        this.password = password;
        this.favorites = favorites;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Joke> getFavorites() {
        return favorites;
    }

    public void addToFavorites(Joke joke) {
        this.favorites.add(joke);
    }

}
