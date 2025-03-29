package use_case.generate;

/**
 * Output Data for the Generate Use Case.
 */
public class GenerateOutputData {

    private final String jokeContent;

    public GenerateOutputData(String jokeContent) {
        this.jokeContent = jokeContent;
//        this.useCaseFailed = useCaseFailed;
    }

    public String getJokeContent() {
        return jokeContent;
    }
}
