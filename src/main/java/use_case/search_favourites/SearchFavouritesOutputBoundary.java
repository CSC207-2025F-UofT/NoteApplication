package use_case.search_favourites;

public interface SearchFavouritesOutputBoundary {

    /**
     * Prepares the view for successful search results.
     * @param searchFavouritesOutputData the output data containing the joke content.
     */
    void prepareSuccessView(SearchFavouritesOutputData searchFavouritesOutputData);

    /**
     * Presents an error message if the search fails.
     * @param message the error message.
     */
    void presentFailure(String message);
}
