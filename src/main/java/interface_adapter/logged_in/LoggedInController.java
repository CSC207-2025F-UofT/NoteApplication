package interface_adapter.logged_in;

import use_case.logged_in.LoggedInInputBoundary;

/**
 * Controller for the Signup Use Case.
 */
public class LoggedInController {

    private final LoggedInInputBoundary userLoggedInUseCaseInteractor;

    public LoggedInController(LoggedInInputBoundary userLoggedInUseCaseInteractor) {
        this.userLoggedInUseCaseInteractor = userLoggedInUseCaseInteractor;
    }

    /**
     * Executes the "switch to SignUpView" Use Case.
     */
    public void switchToSignUpView() {
        userLoggedInUseCaseInteractor.switchToSignUpView();
    }
}
