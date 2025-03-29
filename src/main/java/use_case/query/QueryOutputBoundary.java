package use_case.query;

import entity.RankHistory;

/**
 * The output boundary for the query Use Case.
 */
public interface QueryOutputBoundary {
    /**
     * Prepares the success view for the query related Use Cases.
     * @param rankHistoryList the rank history data.
     */
    void prepareSuccessView(RankHistory rankHistoryList);

    /**
     * Prepares the failure view for the query related Use Cases.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
