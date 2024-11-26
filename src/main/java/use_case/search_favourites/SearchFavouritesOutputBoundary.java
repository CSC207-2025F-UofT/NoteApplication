package use_case.search_favourites;

/**
 * Output boundary for the Search Favourites use case.
 */
public interface SearchFavouritesOutputBoundary {
    void presentFavouritesSearchResult(String result);
    void presentFavouritesSearchError(String error);
}
