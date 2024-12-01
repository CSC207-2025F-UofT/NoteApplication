package use_case.fav_search;

public class FavSearchOutputData {

    private final String jokeContent;

    public FavSearchOutputData(String jokeContent) {

        this.jokeContent = jokeContent;
    }

    public String getJokeContent() {
        return jokeContent;
    }
}
