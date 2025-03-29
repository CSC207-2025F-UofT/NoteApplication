package use_case.funniest.adapter;

import data_access.FileDataAccessObject;
import use_case.funniest.FunniestOutputBoundary;
import use_case.funniest.FunniestOutputData;
import view.joke_view.JokeFrameBuilder;

import javax.swing.*;

public class FunniestPresenter implements FunniestOutputBoundary {

    private final JokeFrameBuilder jokeFrameBuilder;
    private final FileDataAccessObject fileDataAccessObject;

    public FunniestPresenter(JokeFrameBuilder jokeFrameBuilder, FileDataAccessObject fileDataAccessObject) {
        this.fileDataAccessObject = fileDataAccessObject;
        this.jokeFrameBuilder = jokeFrameBuilder;
    }

    @Override
    public void prepareSuccessView(FunniestOutputData funniestOutputData) {
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(funniestOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase(fileDataAccessObject)
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
