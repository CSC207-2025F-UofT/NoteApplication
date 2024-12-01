package use_case.favourite;

import java.util.List;

import entity.Joke;

public interface FavouriteUserDataAccessInterface {
    List<Joke> getFavourite();
}
