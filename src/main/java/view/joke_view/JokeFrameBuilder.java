package view.joke_view;

import data_access.ExplanationDataAccessObject;
import data_access.FileDataAccessObject;
import data_access.MockExplanationDataAccessObject;
import use_case.add_to_fav.AddToFavDataAccessInterface;
import use_case.add_to_fav.AddToFavInputBoundary;
import use_case.add_to_fav.AddToFavInteractor;
import use_case.add_to_fav.AddToFavOutputBoundary;
import use_case.add_to_fav.adapter.AddToFavController;
import use_case.add_to_fav.adapter.AddToFavPresenter;
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
    private AddToFavDataAccessInterface addToFavDataAccessObject;

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

    public JokeFrameBuilder setExplanation(String explanation) {
        jokeViewModel.getState().setExplanation(explanation);
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

    public JokeFrameBuilder addAddToFavUseCase(AddToFavDataAccessInterface addToFavDataAccessObject) {
        final AddToFavOutputBoundary addToFavOutputBoundary = new AddToFavPresenter(jokeViewModel);
        final AddToFavInputBoundary addToFavInteractor = new AddToFavInteractor(
                addToFavDataAccessObject, addToFavOutputBoundary);

        final AddToFavController addToFavController = new AddToFavController(addToFavInteractor);
        jokeView.setAddController(addToFavController);
        return this;
    }

    public JFrame build() {
        final JFrame frame = new JFrame("Joke");

        frame.add(jokeView);

        return frame;
    }
}
