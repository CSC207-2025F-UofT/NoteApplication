package use_case.funniest;

import entity.User;

public interface FunniestInputBoundary {
    /**
     * Search the funniest joke by keyword.
     * @param funniestInputData the input data.
     */
    void execute(FunniestInputData funniestInputData);
}
