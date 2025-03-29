package use_case.explanation;

/**
 * The Input Data for the Login Use Case.
 */
public class ExplanationInputData {

    private final String jokeContent;

    public ExplanationInputData(String jokeContent) {
        this.jokeContent = jokeContent;
    }

    String getJokeContent() {
        return jokeContent;
    }

}
