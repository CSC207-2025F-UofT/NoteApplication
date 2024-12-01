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

    public void executeFavourite() {
        try {
            final List<Joke> jokeList = favouriteUserDataAccessInterface.getFavourite();
            // interactor gets input data and outputs output data
            final FavouriteOutputData favouriteOutputData = new FavouriteOutputData(jokeList);

            favouriteOutputBoundary.prepareSuccessView(favouriteOutputData);
        }
        catch (RuntimeException ex) {
            favouriteOutputBoundary.prepareFailView(ex.getMessage());
        }
    }
}
