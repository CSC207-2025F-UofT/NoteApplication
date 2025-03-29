package use_case.fav_search;

import entity.Joke;

import java.util.List;

public interface FavSearchDataAccessInterface {
    /**
     * Get the user's favourites list.
     * @return a list of jokes marked as favourites.
     */
    List<Joke> getFavourites();
}
