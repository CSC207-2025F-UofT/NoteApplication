package use_case.search.adapter;

import use_case.search.SearchInputBoundary;

public class SearchController {

    private final SearchInputBoundary searchInputBoundary;

    public SearchController(SearchInputBoundary searchInteractor) {
        this.searchInputBoundary = searchInteractor;
    }

    public void execute(String keywords) {
        searchInputBoundary.executeSearch(keywords);
    }
}