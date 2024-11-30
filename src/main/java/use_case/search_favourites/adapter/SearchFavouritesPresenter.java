package use_case.search_favourites.adapter;

import use_case.search_favourites.SearchFavouritesOutputBoundary;
import use_case.search_favourites.SearchFavouritesOutputData;
import view.FavouriteView;
import view.joke_view.JokeFrameBuilder;

import javax.swing.*;

/**
 Search favourites presenter.
 */

public class SearchFavouritesPresenter implements SearchFavouritesOutputBoundary {

    private final FavouriteView favouriteView;
    private final JokeFrameBuilder jokeFrameBuilder;

    public SearchFavouritesPresenter(FavouriteView favouriteView, JokeFrameBuilder jokeFrameBuilder) {
        this.favouriteView = favouriteView;
        this.jokeFrameBuilder = jokeFrameBuilder;
    }

    @Override
    public void prepareSuccessView(SearchFavouritesOutputData searchFavouritesOutputData) {
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(searchFavouritesOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase()
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void presentFailure(String message) {

    }
}
