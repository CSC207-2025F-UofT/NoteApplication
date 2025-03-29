package use_case.checkUsage;

import use_case.translateText.DataAccessException;

/**
 * Interface for the Check Usage DAO. It consists of methods for
 * getting character count and character limit.
 */
public interface CheckUsageDataAccessInterface {

    /**
     * Get character count.
     * @return the number of character used by user
     * @throws DataAccessException if the character count could not be switched for any reason
     */
    String getCharacterCount() throws DataAccessException;

    /**
     * Get character limit.
     * @return the maximum number of character that user can use
     * @throws DataAccessException if the character limit could not be switched for any reason
     */
    String getCharacterLimit() throws DataAccessException;

}
