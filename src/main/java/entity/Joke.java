package entity;

// there should be a joke factory, a user factory
public class Joke {

    private final String content;
    private String explanation;
    private final int score;

    public Joke(String content, int score) {
        this.content = content;
        this.explanation = "explanation";
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
