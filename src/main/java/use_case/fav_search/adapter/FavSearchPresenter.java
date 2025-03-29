package use_case.fav_search.adapter;

import data_access.FileDataAccessObject;
import use_case.fav_search.FavSearchOutputBoundary;
import use_case.fav_search.FavSearchOutputData;
import view.favourite_view.FavouriteView;
import view.favourite_view.FavouriteViewModel;
import view.joke_view.JokeFrameBuilder;

import javax.swing.*;

/**
 Search favourites presenter.
 */

public class FavSearchPresenter implements FavSearchOutputBoundary {

    private final JokeFrameBuilder jokeFrameBuilder;

    public FavSearchPresenter(JokeFrameBuilder jokeFrameBuilder) {
        this.jokeFrameBuilder = jokeFrameBuilder;
    }

    @Override
    public void prepareSuccessView(FavSearchOutputData searchFavouritesOutputData) {
        final FileDataAccessObject fileDataAccessObject = new FileDataAccessObject("Users.json");
        final JFrame frame = jokeFrameBuilder
                .addJokeView()
                .setJokeContent(searchFavouritesOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase(fileDataAccessObject)
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void presentFailure(String message) {

    }
}
