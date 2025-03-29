package use_case.favourite;

import java.util.List;

import entity.Joke;

public class FavouriteOutputData {
    private List<Joke> favouriteJokeList;

    public FavouriteOutputData(List<Joke> favouriteJokeList) {
        this.favouriteJokeList = favouriteJokeList;
    }

    public List<Joke> getFavouriteJokeList() {
        return favouriteJokeList;
    }
}
