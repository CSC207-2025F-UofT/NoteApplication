package interface_adapter.logged_in;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import use_case.logged_in.LoggedInOutputBoundary;

/**
 * The Presenter for the Change Password Use Case.
 */
public class LoggedInPresenter implements LoggedInOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;
    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoggedInPresenter(ViewManagerModel viewManagerModel,
                             LoggedInViewModel loggedInViewModel,
                             SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.signupViewModel = signupViewModel;
    }

    public void prepareSuccessView(String username) {
        final LoggedInState state = loggedInViewModel.getState();
        state.setUsername(username);
        loggedInViewModel.setState(state);
        loggedInViewModel.firePropertyChanged();

    }

    public void prepareFailView(String error) {
        loggedInViewModel.setState(new LoggedInState());
        loggedInViewModel.firePropertyChanged();
    }

    @Override
    public void switchToSignUpView() {
        viewManagerModel.setState(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
