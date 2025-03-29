package use_case.favourite;

public interface FavouriteInputBoundary {

    /**
     * Executes the favourite use case.
     * @param favouriteInputData the input data
     */
    void execute(FavouriteInputData favouriteInputData);

    void switchToFavouriteView();

    void switchToMainView();
}
