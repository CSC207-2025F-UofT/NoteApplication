package use_case.explanation;

/**
 * Output Data for the Explanation Use Case.
 */
public class ExplanationOutputData {

    private final String explanation;

    public ExplanationOutputData(String explanation) {
        this.explanation = explanation;
//        this.useCaseFailed = useCaseFailed;
    }

    public String getExplanation() {
        return explanation;
    }
}
