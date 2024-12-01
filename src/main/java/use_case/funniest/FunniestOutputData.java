package use_case.funniest;

import entity.Joke;

public class FunniestOutputData {
    private final Joke joke;

    public FunniestOutputData(Joke joke) {
        this.joke = joke;
    }

    Joke getJoke() {
        return joke;
    }
}
