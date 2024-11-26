package use_case.search_favourites;

import data_access.JokeDataAccessObject;
import entity.Joke;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFavouritesInteractor implements SearchFavouritesInputBoundary {

    private final JokeDataAccessObject jokeDataAccessObject;
    private final SearchFavouritesOutputBoundary outputBoundary;

    public SearchFavouritesInteractor(JokeDataAccessObject jokeDataAccessObject,
                                      SearchFavouritesOutputBoundary outputBoundary) {
        this.jokeDataAccessObject = jokeDataAccessObject;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void searchFavourites(String keyword) {
        try {
            List<Joke> favourites = jokeDataAccessObject.getFavorites();
            List<Joke> matchingFavourites = favourites.stream()
                    .filter(joke -> joke.getText().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
            if (matchingFavourites.isEmpty()) {
                outputBoundary.presentFavouritesSearchResult("No matching jokes found in favourites.");
            } else {
                String result = matchingFavourites.stream()
                        .map(Joke::getText)
                        .collect(Collectors.joining("\n"));
                outputBoundary.presentFavouritesSearchResult(result);
            }
        } catch (Exception e) {
            outputBoundary.presentFavouritesSearchError("An error occurred while searching favourites.");
        }
    }
}
