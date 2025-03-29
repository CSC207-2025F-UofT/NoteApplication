package use_case.query;

import entity.RankHistory;

/**
 * Interface for the QueryDAO.
 */
public interface QueryDataAccessInterface {

    /**
     * Saves a rank history for a given user.
     * @param username the query user's name.
     * @return the rank history of the user.
     */
    RankHistory showRankHistory(String username);
}
