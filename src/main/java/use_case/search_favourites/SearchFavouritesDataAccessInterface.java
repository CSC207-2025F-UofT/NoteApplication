package use_case.search_favourites;

import entity.Joke;

import java.util.List;

public interface SearchFavouritesDataAccessInterface {
    /**
     * Get the user's favourites list.
     * @return a list of jokes marked as favourites.
     */
    List<Joke> getFavourites();
}
