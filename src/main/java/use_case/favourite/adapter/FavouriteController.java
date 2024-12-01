package use_case.favourite.adapter;

import entity.User;
import use_case.favourite.FavouriteInputBoundary;
import use_case.favourite.FavouriteInputData;
import use_case.favourite.FavouriteInteractor;
import use_case.favourite.FavouriteOutputBoundary;

public class FavouriteController {
    private final FavouriteInputBoundary userFavouriteUseCaseInteractor;

    public FavouriteController(FavouriteInputBoundary userFavouriteUseCaseInteractor) {
        this.userFavouriteUseCaseInteractor = userFavouriteUseCaseInteractor;
    }

    public void execute(User user) {
        FavouriteInputData input = new FavouriteInputData(user);
        userFavouriteUseCaseInteractor.execute(input);
    };
}
