package use_case.fav_search;

public interface FavSearchInputBoundary {
    /**
     * Search for jokes in the user's favourites.
     * @param keyword the keyword to search for.
     */
    void executeSearch(String keyword);
}
