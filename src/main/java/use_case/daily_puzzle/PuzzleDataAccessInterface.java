package use_case.daily_puzzle;

import java.util.ArrayList;

/**
 * Interface for the Lichess api.
 * It consists of methods for fetching a daily puzzle and a puzzle from id.
 */
public interface PuzzleDataAccessInterface {

    /**
     * Returns the daily puzzle's id and solutions
     * @return The JSONObject corresponding to a puzzle
     * @throws PuzzleAccessException if a puzzle cannot be fetched.
     */
    ArrayList<String> getDaily() throws PuzzleAccessException;

    /**
     * Returns a puzzle's moves and solutions from puzzle id.
     * @param id the id of the puzzle.
     * @return strings of puzzle setup moves and puzzle solutions.
     * @throws PuzzleAccessException If a puzzle cannot be fetched.
     */
    ArrayList<String> fetchPuzzle(String id) throws PuzzleAccessException;

}
