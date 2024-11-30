package use_case.explanation.adapter;

import use_case.explanation.ExplanationOutputBoundary;
import use_case.explanation.ExplanationOutputData;
import view.joke_view.JokeState;
import view.joke_view.JokeViewModel;

public class ExplanationPresenter implements ExplanationOutputBoundary {

    private final JokeViewModel jokeViewModel;

    public ExplanationPresenter(JokeViewModel jokeViewModel) {
        this.jokeViewModel = jokeViewModel;
    }

    @Override
    public void prepareSuccessView(ExplanationOutputData explanationOutputData) {
        final JokeState jokeState = jokeViewModel.getState();
        jokeState.setExplanation(explanationOutputData.getExplanation());
        jokeViewModel.setState(jokeState);
        jokeViewModel.firePropertyChanged();
    }

    @Override
    //TODO to be continued
    public void prepareFailView(String errorMessage) {
    }
}
