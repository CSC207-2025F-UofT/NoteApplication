package interface_adapter.query;

import entity.RankHistory;
import interface_adapter.ViewModel;

/**
 * The View Model for the query view.
 */
public class QueryViewModel extends ViewModel<QueryState> {

    public QueryViewModel() {
        super("query");
        setState(new QueryState());
    }

    public RankHistory getRankHistoryList() {
        return getState().getRankHistoryList();
    }

}
