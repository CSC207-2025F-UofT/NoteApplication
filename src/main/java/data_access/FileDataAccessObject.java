package data_access;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Joke;
import entity.JokeFactory;
import entity.User;
import entity.UserFactory;
import use_case.add_to_fav.AddToFavDataAccessInterface;
import use_case.fav_search.FavSearchDataAccessInterface;
import use_case.favourite.FavouriteUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

/**
 * DAO for user data implemented using a File to persist the data.
 */
public class FileDataAccessObject implements SignupUserDataAccessInterface,
        LogoutUserDataAccessInterface,
        AddToFavDataAccessInterface,
        LoginUserDataAccessInterface,
        FavouriteUserDataAccessInterface,
        FavSearchDataAccessInterface {

    private File jsonFile;
    private List<User> users = new ArrayList<>();
    private UserFactory userFactory = new UserFactory();
    private JokeFactory jokeFactory = new JokeFactory();
    private String currentUserName;

    /**
     * Constructs a Data Access Object populated using data from the specified resources file.
     * @param filename the name of the file in resources to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public FileDataAccessObject(String filename) {
        // read the file to get the data to populate things...
        try {

            final String jsonString = Files.readString(
                    Paths.get(getClass().getClassLoader().getResource(filename).toURI()));

            final JSONArray jsonArray = new JSONArray(jsonString);

            // this for loop makes the instance variables what's said in comments
            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject jsonObject = jsonArray.getJSONObject(i);
                final String username = jsonObject.getString("username");
                final String password = jsonObject.getString("password");
                final JSONArray favorites = jsonObject.getJSONArray("favorites");
                final List<Joke> jokeList = new ArrayList<>();
                for (int j = 0; j < favorites.length(); j++) {
                    final JSONObject jokeObject = favorites.getJSONObject(j);
                    final String jokeContent = jokeObject.getString("content");
                    final String jokeExplanation = jokeObject.getString("explanation");
                    final int jokeScore = jokeObject.getInt("score");
                    final Joke joke = jokeFactory.create(jokeContent, jokeScore);
                    joke.setExplanation(jokeExplanation);
                    jokeList.add(joke);
                }
                final User user = userFactory.create(username, password, jokeList);
                users.add(user);
            }

        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void save() {
        final JSONArray jsonArray = new JSONArray();

        // Convert each user into a JSONObject and add to the JSONArray
        for (User user : users) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("Username", user.getName());
            jsonObject.put("Password", user.getPassword());
            jsonObject.put("favorites", user.getFavorites());
            jsonArray.put(jsonObject);
        }

        // Write the JSON array to the file
        try (FileWriter fileWriter = new FileWriter("Users.json")) {
            fileWriter.write(jsonArray.toString());
            System.out.println("Users saved successfully to " + "Users.json");
        }
        catch (IOException ex) {
            System.err.println("Error saving users: " + ex.getMessage());
        }
    }

    // TODO change, update user
    @Override
    public void save(User user) {
        if (this.existsByName(user.getName())) {
            final User currentUser = this.get(user.getName());
            users.remove(currentUser);
        }
        users.add(user);
        this.save();
    }

    public User get(String username) {
        for (int i = 0; i < users.size(); i++) {
            final User currentuser = users.get(i);
            if (currentuser.getName().equals(username)) {
                return currentuser;
            }
        }
        return null;
    }

    @Override
    public boolean existsByName(String username) {
        return this.get(username) != null;
    }

    @Override
    public String getCurrentUsername() {
        return this.currentUserName;
    }

    @Override
    public void setCurrentUsername(String username) {
        this.currentUserName = username;
    }

    @Override
    public List<Joke> getFavourites() {
        return (get(getCurrentUsername()).getFavorites());
    }
}
