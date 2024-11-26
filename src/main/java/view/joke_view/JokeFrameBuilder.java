package view.joke_view;

import data_access.ExplanationDataAccessObject;
import data_access.MockExplanationDataAccessObject;
import use_case.explanation.*;
import use_case.explanation.adapter.ExplanationController;
import use_case.explanation.adapter.ExplanationPresenter;

import javax.swing.*;

public class JokeFrameBuilder {
//    public static final int HEIGHT = 300;
//    public static final int WIDTH = 400;
    // joke/user factory made before
//    private final JokeFactory jokeFactory = new JokeFactory();

    private JokeView jokeView;
    private JokeViewModel jokeViewModel;
    // view doesn't change, so don't need ViewManager(cardPanel, cardLayout, viewManagerModel);

    //TODO change mock
    private final ExplanationDataAccessInterface explanationDataAccessObject = new ExplanationDataAccessObject();

    public JokeFrameBuilder() {
    }

    public JokeFrameBuilder addJokeView() {
        jokeViewModel = new JokeViewModel();
        jokeView = new JokeView(jokeViewModel);
        return this;
    }

    public JokeFrameBuilder setJokeContent(String content) {
        jokeViewModel.getState().setJokeContent(content);
        jokeViewModel.firePropertyChanged();
        return this;
    }

    public JokeFrameBuilder addExplanationUseCase() {
        final ExplanationOutputBoundary explanationOutputBoundary = new ExplanationPresenter(jokeViewModel);
        final ExplanationInputBoundary explanationInteractor = new ExplanationInteractor(
                explanationDataAccessObject, explanationOutputBoundary);

        final ExplanationController explanationController = new ExplanationController(explanationInteractor);
        jokeView.setExplanationController(explanationController);
        return this;
    }

    //TODO do this
    public JokeFrameBuilder addAddToFavUseCase() {
        return this;
    }

    public JFrame build() {
        final JFrame frame = new JFrame("Joke");

        //TODO may need to change
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(jokeView);

        return frame;
    }
}
