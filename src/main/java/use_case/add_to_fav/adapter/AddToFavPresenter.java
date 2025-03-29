package use_case.add_to_fav.adapter;

import use_case.add_to_fav.AddToFavOutputBoundary;
import view.joke_view.JokeState;
import view.joke_view.JokeViewModel;

/**
 * The AddToFavPresenter class formats the output of the Add to Favorites use case
 * for the view layer.
 */
public class AddToFavPresenter implements AddToFavOutputBoundary {

    private final JokeViewModel jokeViewModel;

    public AddToFavPresenter(JokeViewModel jokeViewModel) {
        this.jokeViewModel = jokeViewModel;
    }

    @Override
    public void prepareSuccessView(String added) {
        final JokeState jokeState = jokeViewModel.getState();
        jokeState.setAddToFavText(added);
        jokeViewModel.setState(jokeState);
        jokeViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final JokeState jokeState = jokeViewModel.getState();
        jokeState.setAddToFavText(error);
        jokeViewModel.setState(jokeState);
        jokeViewModel.firePropertyChanged();
    }
}
