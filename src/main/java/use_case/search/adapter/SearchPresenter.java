package use_case.search.adapter;

import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;
import view.search_view.SearchState;
import view.search_view.SearchViewModel;

public class SearchPresenter implements SearchOutputBoundary {

    private final SearchViewModel searchViewModel;

    public SearchPresenter(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData searchOutputData) {
        final SearchState searchState = searchViewModel.getState();
        searchState.setExplanation(searchOutputData.getJokeContent());
        searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailureView(String errormessage) {

    }
}