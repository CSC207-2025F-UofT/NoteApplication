package use_case.favourite;

public interface FavouriteInputBoundary {

    /**
     * Executes the favourite use case.
     * @param favouriteInputData the input data
     */
    void execute(FavouriteInputData favouriteInputData);

    /**
     * Executes the switch to login view use case.
     */
    void switchToFavouriteView();

    void executeFunniest();
}
