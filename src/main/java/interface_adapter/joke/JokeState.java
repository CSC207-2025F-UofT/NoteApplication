package interface_adapter.joke;

/**
 * The state for the Joke View Model.
 */
public class JokeState {
    private String jokeText = "";
    private String errorMessage;

    public String getJokeText() {
        return jokeText;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setJokeText(String jokeText) {
        this.jokeText = jokeText;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
