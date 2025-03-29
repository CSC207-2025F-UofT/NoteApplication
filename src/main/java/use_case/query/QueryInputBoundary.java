package use_case.query;

/**
 * The Input Boundary for query use cases.
 */
public interface QueryInputBoundary {

    /**
     * Executes the query use case.
     * @param username the user .
     */
    void execute(String username);
}
