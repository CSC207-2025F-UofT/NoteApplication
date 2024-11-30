package use_case.generate.adapter;

import use_case.generate.GenerateInputBoundary;

/**
 * Controller for our generate Use Cases.
 */
public class GenerateController {

    private final GenerateInputBoundary generateInputBoundary;

    public GenerateController(GenerateInputBoundary generateInputBoundary) {
        this.generateInputBoundary = generateInputBoundary;
    }

    /**
     * Executes the generate related Use Cases.
     */
    public void execute() {
        generateInputBoundary.executeGenerate();
    }
    //may change to add user
    //controller is responsible for changing raw info from view states to inputData
}
