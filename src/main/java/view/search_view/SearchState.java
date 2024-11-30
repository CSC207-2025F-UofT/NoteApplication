package view.search_view;

public class SearchState {
    // info that can change
    private String jokeContent = "";
    private String explanation = "";

    @Override
    public String toString() {
        return "JokeState{"
                + "jokeContent='" + getJokeContent() + '\''
                + ", explanation='" + getExplanation() + '\''
                + '}';
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getJokeContent() {
        return jokeContent;
    }

    public void setJokeContent(String jokeContent) {
        this.jokeContent = jokeContent;
    }
}