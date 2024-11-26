package use_case.search;

public class SearchOutputData {

    private final String jokeContent;

    public SearchOutputData(String jokeContent) {
        this.jokeContent = jokeContent;
    }

    public String getJokeContent() {
        return jokeContent;
    }
}