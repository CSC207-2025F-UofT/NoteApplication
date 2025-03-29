package use_case.fav_search.adapter;

import use_case.fav_search.FavSearchInputBoundary;

public class FavSearchController {

    private final FavSearchInputBoundary interactor;

    public FavSearchController(FavSearchInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void executeSearch(String keyword) {
        interactor.executeSearch(keyword);
    }
}
