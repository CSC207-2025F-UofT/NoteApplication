package interface_adapter.query;

import entity.RankHistory;
import interface_adapter.ViewManagerModel;
import use_case.query.QueryOutputBoundary;

/**
 * The presenter for query viewing.
 */
public class QueryPresenter implements QueryOutputBoundary {

    private final QueryViewModel queryViewModel;
    private final ViewManagerModel viewManagerModel;

    public QueryPresenter(QueryViewModel queryViewModel, ViewManagerModel viewManagerModel) {
        this.queryViewModel = queryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the success view for the query related Use Cases.
     *
     * @param rankHistoryList the user rank history data.
     */
    @Override
    public void prepareSuccessView(RankHistory rankHistoryList) {
        // On success, switch to the Query view.
        final QueryState queryState = queryViewModel.getState();
        queryState.setRankHistoryList(rankHistoryList);
        this.queryViewModel.setState(queryState);
        this.queryViewModel.firePropertyChanged();

        this.viewManagerModel.setState(queryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the query related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {

    }
}
