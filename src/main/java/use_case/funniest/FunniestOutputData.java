package use_case.funniest;

import entity.Joke;

public class FunniestOutputData {
    private final Joke joke;

    public FunniestOutputData(Joke joke) {
        this.joke = joke;
    }

    public Joke getJoke() {
        return joke;
    }

    public String getJokeContent() {
        return joke.getContent();
    }
}
