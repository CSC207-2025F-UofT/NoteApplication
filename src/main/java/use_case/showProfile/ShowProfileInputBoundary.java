package use_case.showProfile;

/**
 * Input Boundary for actions related to logging in.
 */
public interface ShowProfileInputBoundary {

    /**
     * Executes the login use case.
     * @param showProfileInputData the input data
     */
    void execute(ShowProfileInputData showProfileInputData);
}
