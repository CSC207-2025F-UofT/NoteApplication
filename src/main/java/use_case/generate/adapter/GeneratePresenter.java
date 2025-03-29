package use_case.generate.adapter;

import data_access.FileDataAccessObject;
import use_case.generate.GenerateOuputBoundary;
import use_case.generate.GenerateOutputData;
import view.joke_view.JokeFrameBuilder;
import visitor.JokeVisitor;
import visitor.Visitor;

public class GeneratePresenter implements GenerateOuputBoundary {
    // not a typical presenter, more similar to main

    private final FileDataAccessObject fileDataAccessObject;

    public GeneratePresenter(FileDataAccessObject fileDataAccessObject) {
        this.fileDataAccessObject = fileDataAccessObject;
    }

    /**
     * Prepares the success view for the Note related Use Cases.
     *
     * @param generateOutputData the output data
     */
    @Override
    public void prepareSuccessView(GenerateOutputData generateOutputData) {
        final JokeVisitor visitor = new Visitor(fileDataAccessObject);
        visitor.visit(generateOutputData);
    }

    /**
     * Prepares the failure view for the Note related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
//        jokeViewModel.getState().setError(errorMessage);
//        jokeViewModel.firePropertyChanged();
    }
}
