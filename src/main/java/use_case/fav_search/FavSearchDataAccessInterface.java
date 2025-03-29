package use_case.fav_search;

import java.util.List;

import entity.Joke;

/**
 * Interface for accessing favorite jokes data.
 */
public interface FavSearchDataAccessInterface {
    /**
     * Get the user's favorites list.
     *
     * @return a list of jokes marked as favorites.
     */
    List<Joke> getFavourites();
}
