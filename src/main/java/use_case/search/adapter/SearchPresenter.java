package use_case.search.adapter;

import data_access.FileDataAccessObject;
import view.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;
import view.joke_view.JokeFrameBuilder;
import view.main.MainViewModel;
import visitor.Visitor;

import javax.swing.*;

public class SearchPresenter implements SearchOutputBoundary {

    private final Visitor searchVisitor;
    private final JokeFrameBuilder jokeFrameBuilder;
    private final ViewManagerModel viewManagerModel;
    private final SearchViewModel searchViewModel;
    private final FileDataAccessObject fileDataAccessObject;
    private final MainViewModel mainViewModel;

    public SearchPresenter(SearchViewModel searchViewModel,
                           MainViewModel mainViewModel,
                           ViewManagerModel viewManagerModel,
                           FileDataAccessObject fileDataAccessObject,
                           JokeFrameBuilder jokeFrameBuilder) {
        this.fileDataAccessObject = fileDataAccessObject;
        this.searchVisitor = new Visitor(fileDataAccessObject);
        this.jokeFrameBuilder = jokeFrameBuilder;
        this.viewManagerModel = viewManagerModel;
        this.searchViewModel = searchViewModel;
        this.mainViewModel = mainViewModel;
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

    @Override
    public void switchToMainView() {
        viewManagerModel.setState(mainViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}