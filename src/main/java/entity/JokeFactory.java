package entity;

public class JokeFactory {
    public Joke create(String content, int score) {
        return new Joke(content, score);
    }
}
