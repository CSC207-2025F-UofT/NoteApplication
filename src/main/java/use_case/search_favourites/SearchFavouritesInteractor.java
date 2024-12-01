package use_case.search_favourites;

import entity.Joke;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFavouritesInteractor implements SearchFavouritesInputBoundary {
    private final SearchFavouritesDataAccessInterface dataAccess;
    private final SearchFavouritesOutputBoundary presenter;

    public SearchFavouritesInteractor(SearchFavouritesDataAccessInterface dataAccess,
                                      SearchFavouritesOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void executeSearch(String keyword) {
        try {
            final List<Joke> favourites = dataAccess.getFavourites();
            final List<Joke> matchingJokes = favourites.stream()
                    .filter(joke -> joke.getContent().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());

            if (matchingJokes.isEmpty()) {
                presenter.presentFailure("No matching jokes found in favourites.");
            }
            else {
                final Joke selectedJoke = matchingJokes.get(0);
                final SearchFavouritesOutputData outputData = new SearchFavouritesOutputData(
                        selectedJoke.getContent()
                );
                presenter.prepareSuccessView(outputData);
            }
        } catch (RuntimeException e) {
            presenter.presentFailure("Error searching favourites: " + e.getMessage());
        }
    }

}
