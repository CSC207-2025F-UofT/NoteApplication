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
        try {
            final String jokeContent = searchDataAccessObject.searchJoke(keyword);
            final SearchOutputData searchOutputData = new SearchOutputData(jokeContent);
            searchPresenter.prepareSuccessView(searchOutputData);
        }
        catch (RuntimeException ex) {
            final String message = "failed to find a joke";
            searchPresenter.prepareFailureView(message);
        }
    }
}
