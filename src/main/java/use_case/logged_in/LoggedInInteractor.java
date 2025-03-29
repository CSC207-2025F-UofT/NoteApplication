package use_case.logged_in;

/**
 * The Signup Interactor.
 */
public class LoggedInInteractor implements LoggedInInputBoundary {
    private final LoggedInOutputBoundary userPresenter;

    public LoggedInInteractor(LoggedInOutputBoundary loggedInOutputBoundary) {
        this.userPresenter = loggedInOutputBoundary;
    }

    @Override
    public void switchToSignUpView() {
        userPresenter.switchToSignUpView();
    }
}
