package interface_adapter.query;

import use_case.query.QueryInputBoundary;

/**
 * The controller for the query use case.
 */
public class QueryController {

    private final QueryInputBoundary queryInteractor;

    public QueryController(QueryInputBoundary queryInteractor) {
        this.queryInteractor = queryInteractor;
    }

    /**
     * Execute the query use case.
     * @param username the username of the user logging in
     */
    public void execute(String username) {
        queryInteractor.execute(username);
    }
}
