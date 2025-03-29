package use_case.funniest;

import java.util.List;

import entity.Joke;

public class FunniestInputData {
    private final List<Joke> favouriteJokeList;

    public FunniestInputData(List<Joke> favouriteJokeList) {
        this.favouriteJokeList = favouriteJokeList;
    }

    List<Joke> getFavouriteJokeList() {
        return favouriteJokeList;
    }
}
