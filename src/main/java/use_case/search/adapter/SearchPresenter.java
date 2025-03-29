package use_case.search.adapter;

import data_access.FileDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;
import view.joke_view.JokeFrameBuilder;
import visitor.Visitor;

import javax.swing.*;

public class SearchPresenter implements SearchOutputBoundary {

    private final Visitor searchVisitor;
    private final JokeFrameBuilder jokeFrameBuilder;
    private final ViewManagerModel viewManagerModel;
    private final SearchViewModel searchViewModel;
    private final FileDataAccessObject fileDataAccessObject;

    public SearchPresenter(SearchViewModel searchViewModel,
                           ViewManagerModel viewManagerModel,
                           FileDataAccessObject fileDataAccessObject,
                           JokeFrameBuilder jokeFrameBuilder) {
        this.fileDataAccessObject = fileDataAccessObject;
        this.searchVisitor = new Visitor(fileDataAccessObject);
        this.jokeFrameBuilder = jokeFrameBuilder;
        this.viewManagerModel = viewManagerModel;
        this.searchViewModel = searchViewModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData searchOutputData) {
        searchVisitor.visit(searchOutputData);
    }

    @Override
    public void prepareFailureView(String errormessage) {
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(errormessage)
                .addExplanationUseCase()
                .addAddToFavUseCase(fileDataAccessObject)
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void switchToSearchView() {
        viewManagerModel.setState(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}