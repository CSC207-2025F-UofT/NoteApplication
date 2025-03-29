package use_case.favourite;

import entity.Joke;

import java.util.List;

/**
 * The "Use Case Interactor" for getting user's favourite
 */
public class FavouriteInteractor implements FavouriteInputBoundary {

    private final FavouriteUserDataAccessInterface favouriteUserDataAccessInterface;
    private final FavouriteOutputBoundary favouriteOutputBoundary;

    public FavouriteInteractor(FavouriteUserDataAccessInterface favouriteUserDataAccessInterface, FavouriteOutputBoundary favouriteOutputBoundary) {
        this.favouriteUserDataAccessInterface = favouriteUserDataAccessInterface;
        this.favouriteOutputBoundary = favouriteOutputBoundary;
    }

    @Override
    public void execute(FavouriteInputData favouriteInputData) {
        final List<Joke> jokeList = favouriteInputData.getUser().getFavorites();
        // interactor gets input data and outputs output data
        final FavouriteOutputData favouriteOutputData = new FavouriteOutputData(jokeList);

        favouriteOutputBoundary.prepareSuccessView(favouriteOutputData);
    }
    @Override
    public void switchToFavouriteView() {
        favouriteOutputBoundary.switchToFavouriteView();
    }

    @Override
    public void switchToMainView() {
        favouriteOutputBoundary.switchToMainView();
    }
}
