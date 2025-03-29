package interface_adapter.query;

import entity.RankHistory;

/**
 * The State information representing the query user.
 */
public class QueryState {
    private RankHistory rankHistoryList;

    public QueryState() {

    }

    public void setRankHistoryList(RankHistory rankHistoryList) {
        this.rankHistoryList = rankHistoryList;
    }

    public RankHistory getRankHistoryList() {
        return rankHistoryList;
    }
}
