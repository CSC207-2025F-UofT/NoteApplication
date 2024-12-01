package use_case.favourite.adapter;

import use_case.favourite.FavouriteOutputBoundary;
import use_case.favourite.FavouriteOutputData;
import view.favourite_view.FavouriteState;
import view.favourite_view.FavouriteViewModel;

public class FavouritePresenter implements FavouriteOutputBoundary {

    private final FavouriteViewModel favouriteViewModel;

    public FavouritePresenter(FavouriteViewModel favouriteViewModel) {
        this.favouriteViewModel = favouriteViewModel;
    }

    @Override
    public void prepareSuccessView(FavouriteOutputData favouriteOutputData) {
        final FavouriteState favouriteState = favouriteViewModel.getState();
        favouriteState.setFavourites(favouriteOutputData.getFavouriteJokeList());
        favouriteViewModel.setState(favouriteState);
        favouriteViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }

    @Override
    public void prepareFailureView(String errormessage) {

    }
}