package use_case.explanation;

import use_case.generate.GenerateDataAccessInterface;
import use_case.generate.GenerateOuputBoundary;

public class ExplanationInteractor implements ExplanationInputBoundary {

    private final ExplanationDataAccessInterface explanationDataAccessObject;
    private final ExplanationOutputBoundary explanationOutputBoundary;

    public ExplanationInteractor(ExplanationDataAccessInterface explanationDataAccessObject, ExplanationOutputBoundary explanationOutputBoundary) {
        this.explanationDataAccessObject = explanationDataAccessObject;
        this.explanationOutputBoundary = explanationOutputBoundary;
    }

    @Override
    public void executeExplanation(ExplanationInputData explanationInputData) {
        try {
            final String explanation = explanationDataAccessObject.getExplanation(explanationInputData.getJokeContent());
            explanationOutputBoundary.prepareSuccessView(new ExplanationOutputData(explanation));
        }
        catch (RuntimeException ex) {
            explanationOutputBoundary.prepareFailView(ex.getMessage());
        }
    }
}
