package use_case.favourite.adapter;

import entity.User;
import use_case.favourite.FavouriteInputBoundary;
import use_case.favourite.FavouriteInputData;

public class FavouriteController {

    private final FavouriteInputBoundary favouriteInputBoundary;

    public FavouriteController(FavouriteInputBoundary favouriteInputBoundary) {
        this.favouriteInputBoundary = favouriteInputBoundary;
    }

    public void execute(User user) {
        final FavouriteInputData input = new FavouriteInputData(user);
        favouriteInputBoundary.execute(input);
    }

    public void switchToFavouriteView() {
            favouriteInputBoundary.switchToFavouriteView();
    }

    public void switchToMainView() {
        favouriteInputBoundary.switchToMainView();
    }
}
