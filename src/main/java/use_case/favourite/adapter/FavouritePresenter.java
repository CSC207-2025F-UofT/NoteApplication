package use_case.favourite.adapter;

import entity.Joke;
import use_case.favourite.FavouriteOutputBoundary;
import use_case.favourite.FavouriteOutputData;
import view.ViewManagerModel;
import view.favourite_view.FavouriteState;
import view.favourite_view.FavouriteViewModel;
import view.main.MainViewModel;

import java.util.ArrayList;

public class FavouritePresenter implements FavouriteOutputBoundary {

    private final FavouriteViewModel favouriteViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainViewModel mainViewModel;

    public FavouritePresenter(FavouriteViewModel favouriteViewModel,
                              MainViewModel mainViewModel,
                              ViewManagerModel viewManagerModel) {
        this.favouriteViewModel = favouriteViewModel;
        this.viewManagerModel = viewManagerModel;
        this.mainViewModel = mainViewModel;
    }

    @Override
    public void prepareSuccessView(FavouriteOutputData favouriteOutputData) {
        final FavouriteState favouriteState = favouriteViewModel.getState();
        favouriteState.setFavourites(favouriteOutputData.getFavouriteJokeList());
        favouriteViewModel.setState(favouriteState);
        favouriteViewModel.firePropertyChanged();
        viewManagerModel.setState(favouriteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }

    @Override
    public void switchToFavouriteView() {
        viewManagerModel.setState(favouriteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToMainView() {
        FavouriteState favouriteState = favouriteViewModel.getState();
        favouriteState.setFavourites(new ArrayList<Joke>());
        favouriteViewModel.setState(favouriteState);
        favouriteViewModel.firePropertyChanged();
        viewManagerModel.setState(mainViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}