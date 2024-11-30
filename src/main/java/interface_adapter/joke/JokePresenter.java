package interface_adapter.joke;

import interface_adapter.ViewManagerModel;
import use_case.joke.JokeOutputBoundary;
import use_case.joke.JokeOutputData;

/**
 * The Presenter for the Joke Use Case.
 */
public class JokePresenter implements JokeOutputBoundary {

    private final JokeViewModel jokeViewModel;
    private final ViewManagerModel viewManagerModel;

    public JokePresenter(ViewManagerModel viewManagerModel, JokeViewModel jokeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.jokeViewModel = jokeViewModel;
    }

    @Override
    public void prepareSuccessView(JokeOutputData response) {
        // Update the JokeState with the new joke
        JokeState jokeState = jokeViewModel.getState();
        jokeState.setJokeText(response.getJokeText());
        jokeState.setFavoriteStatus(response.isFavorite());
        jokeViewModel.setState(jokeState);
        jokeViewModel.firePropertyChanged();

        viewManagerModel.setState(jokeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        JokeState jokeState = jokeViewModel.getState();
        jokeState.setErrorMessage(error);
        jokeViewModel.setState(jokeState);
        jokeViewModel.firePropertyChanged("error");
    }
}
