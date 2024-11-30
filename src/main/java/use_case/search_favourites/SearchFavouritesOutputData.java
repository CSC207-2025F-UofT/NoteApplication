package use_case.search_favourites;

public class SearchFavouritesOutputData {

    private final String jokeContent;

    public SearchFavouritesOutputData(String jokeContent) {

        this.jokeContent = jokeContent;
    }

    public String getJokeContent() {
        return jokeContent;
    }
}
