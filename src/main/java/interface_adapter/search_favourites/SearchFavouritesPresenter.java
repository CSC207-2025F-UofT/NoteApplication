package interface_adapter.search_favourites;

import use_case.search_favourites.SearchFavouritesOutputBoundary;

public class SearchFavouritesPresenter implements SearchFavouritesOutputBoundary {

    private String resultMessage;
    private String errorMessage;

    @Override
    public void presentFavouritesSearchResult(String result) {
        this.resultMessage = result;
    }

    @Override
    public void presentFavouritesSearchError(String error) {
        this.errorMessage = error;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
