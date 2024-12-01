package use_case.funniest;

import use_case.favourite.FavouriteInputBoundary;
import use_case.favourite.FavouriteOutputBoundary;

public class FunniestInteractor implements FavouriteInputBoundary {

    private final FavouriteOutputBoundary favouriteOutputBoundary;

    public FunniestInteractor(FavouriteOutputBoundary outputBoundary) {
        this.favouriteOutputBoundary = outputBoundary;
    }

    @Override
    public void executeFunniest() {
        try {

        }
    }
}
