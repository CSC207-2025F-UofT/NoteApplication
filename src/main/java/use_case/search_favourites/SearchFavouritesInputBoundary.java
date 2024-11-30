package use_case.search_favourites;

public interface SearchFavouritesInputBoundary {
    /**
     * Search for jokes in the user's favourites.
     * @param keyword the keyword to search for.
     */
    void executeSearch(String keyword);
}
