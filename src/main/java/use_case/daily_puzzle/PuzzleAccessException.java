package use_case.daily_puzzle;

/**
 * Exception thrown when a puzzle can't be returned.
 */
public class PuzzleAccessException extends Exception {
    public PuzzleAccessException(String string) { super(string); }
}