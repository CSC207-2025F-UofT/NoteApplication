package use_case.explanation.adapter;

import use_case.explanation.ExplanationInputBoundary;
import use_case.explanation.ExplanationInputData;

public class ExplanationController {

    private final ExplanationInputBoundary explanationInputBoundary;

    public ExplanationController(ExplanationInputBoundary explanationInteractor) {
        this.explanationInputBoundary = explanationInteractor;
    }

    public void execute(String jokeContent) {
        ExplanationInputData input = new ExplanationInputData(jokeContent);
        explanationInputBoundary.executeExplanation(input);
    }
}
