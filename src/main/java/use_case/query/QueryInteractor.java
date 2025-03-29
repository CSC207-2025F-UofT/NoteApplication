package use_case.query;

import entity.RankHistory;

/**
 * The Query Interactor.
 */
public class QueryInteractor implements QueryInputBoundary {
    private final QueryDataAccessInterface queryDataAccessInterface;
    private final QueryOutputBoundary queryOutputBoundary;

    public QueryInteractor(QueryDataAccessInterface queryDataAccessInterface,
                           QueryOutputBoundary queryOutputBoundary) {
        this.queryDataAccessInterface = queryDataAccessInterface;
        this.queryOutputBoundary = queryOutputBoundary;
    }

    /**
     * Executes the query use case.
     *
     * @param username the user.
     */
    @Override
    public void execute(String username) {
        final RankHistory rankHistoryList = queryDataAccessInterface.showRankHistory(username);
        queryOutputBoundary.prepareSuccessView(rankHistoryList);
    }
}
