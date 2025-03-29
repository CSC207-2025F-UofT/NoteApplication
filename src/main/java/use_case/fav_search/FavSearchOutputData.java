package use_case.fav_search;

public class FavSearchOutputData {

    private final String jokeContent;
    private final String explanation;

    public FavSearchOutputData(String jokeContent, String explanation) {
        this.jokeContent = jokeContent;
        this.explanation = explanation;

    }

    public String getJokeContent() {
        return jokeContent;
    }

    public String getExplanation() {
        return explanation;
    }
}
