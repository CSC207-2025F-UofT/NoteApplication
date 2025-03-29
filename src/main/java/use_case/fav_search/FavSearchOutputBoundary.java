package use_case.fav_search;

public interface FavSearchOutputBoundary {

    /**
     * Prepares the view for successful search results.
     * @param searchFavouritesOutputData the output data containing the joke content.
     */
    void prepareSuccessView(FavSearchOutputData searchFavouritesOutputData);

    /**
     * Presents an error message if the search fails.
     * @param message the error message.
     */
    void presentFailure(String message);
}
