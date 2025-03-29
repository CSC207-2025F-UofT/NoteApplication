package use_case.fav_search;

import entity.Joke;

import java.util.List;
import java.util.stream.Collectors;

public class FavSearchInteractor implements FavSearchInputBoundary {
    private final FavSearchDataAccessInterface dataAccess;
    private final FavSearchOutputBoundary presenter;

    public FavSearchInteractor(FavSearchOutputBoundary presenter, FavSearchDataAccessInterface dataAccess) {
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
                final FavSearchOutputData outputData = new FavSearchOutputData(
                        selectedJoke.getContent(),
                        selectedJoke.getExplanation()
                );
                presenter.prepareSuccessView(outputData);
            }
        } catch (RuntimeException e) {
            presenter.presentFailure("Error searching favourites: " + e.getMessage());
        }
    }

}
