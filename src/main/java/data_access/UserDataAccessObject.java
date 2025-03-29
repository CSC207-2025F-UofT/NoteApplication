package data_access;

import java.util.HashMap;
import java.util.Map;

import entity.User;
import use_case.login.LoginUserDataAccessInterface;
import use_case.showProfile.ShowProfileUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

/**
 * The DAO for user data.
 */
public class UserDataAccessObject implements LoginUserDataAccessInterface, SignupUserDataAccessInterface,
        ShowProfileUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();
    private String currentUser;

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public void setCurrentUser(String name) {
        this.currentUser = name;
    }

    @Override
    public String getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean existsByName(String username) {
        return users.containsKey(username);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }
}
