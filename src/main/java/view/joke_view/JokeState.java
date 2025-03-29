package view.joke_view;

import static view.joke_view.JokeViewModel.ADD_BUTTON_LABEL;

public class JokeState {
    // info that can change
    private String jokeContent = "";
    private String explanation = "";
    private String addToFav = ADD_BUTTON_LABEL;

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

    public void setAddToFavText(String added) {
        this.addToFav = added;
    }

    public String getAddToFav() {
        return this.addToFav;
    }
}