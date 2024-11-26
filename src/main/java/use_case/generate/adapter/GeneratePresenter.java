package use_case.generate.adapter;

import entity.Joke;
import use_case.generate.GenerateOuputBoundary;
import use_case.generate.GenerateOutputData;
import use_case.note.NoteOutputBoundary;
import view.joke_view.JokeFrameBuilder;
import view.joke_view.JokeViewModel;

import javax.swing.*;

public class GeneratePresenter implements GenerateOuputBoundary {
    // not a typical presenter, more similar to main

    private final JokeFrameBuilder jokeFrameBuilder;

    public GeneratePresenter(JokeFrameBuilder jokeFrameBuilder) {
        this.jokeFrameBuilder = jokeFrameBuilder;
    }

    /**
     * Prepares the success view for the Note related Use Cases.
     *
     * @param generateOutputData the output data
     */
    @Override
    public void prepareSuccessView(GenerateOutputData generateOutputData) {
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(generateOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase()
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Prepares the failure view for the Note related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    //TODO implement
    @Override
    public void prepareFailView(String errorMessage) {
//        jokeViewModel.getState().setError(errorMessage);
//        jokeViewModel.firePropertyChanged();
    }
}
