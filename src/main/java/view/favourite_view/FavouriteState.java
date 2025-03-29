package view.favourite_view;

import java.util.List;

import entity.Joke;
import entity.User;

public class FavouriteState {
    private String keyWord;
    private User user;
    private List<Joke> favourites;

    public List<Joke> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Joke> favourites) {
        this.favourites = favourites;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
