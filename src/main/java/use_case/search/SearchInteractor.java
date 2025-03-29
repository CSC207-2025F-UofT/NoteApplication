package use_case.search;

public class SearchInteractor implements SearchInputBoundary {
    private final SearchDataAccessInterface searchDataAccessObject;
    private final SearchOutputBoundary searchPresenter;

    public SearchInteractor(SearchDataAccessInterface searchDataAccessObject,
                            SearchOutputBoundary searchPresenter) {
        this.searchDataAccessObject = searchDataAccessObject;
        this.searchPresenter = searchPresenter;
    }

    @Override
    public void executeSearch(String keyword) {
        final String jokeContent = searchDataAccessObject.searchJoke(keyword);
        final SearchOutputData searchOutputData = new SearchOutputData(jokeContent);
        if (searchOutputData.getError()) {
            final String message = "failed to find a joke";
            searchPresenter.prepareFailureView(message);
        }
        else {
            searchPresenter.prepareSuccessView(searchOutputData);
        }
    }

    public void switchToSearchView() {
        searchPresenter.switchToSearchView();
    }

    @Override
    public void switchToMainView() {
        searchPresenter.switchToMainView();
    }
}
