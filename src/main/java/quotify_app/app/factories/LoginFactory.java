package quotify_app.app.factories;

import quotify_app.adapters.ViewManagerModel;
import quotify_app.adapters.login.LoginController;
import quotify_app.adapters.login.LoginPresenter;
import quotify_app.adapters.login.LoginViewModel;
import quotify_app.data_access.DBUserDataAccessObject;
import quotify_app.entities.CommonUserFactory;
import quotify_app.entities.UserFactory;
import quotify_app.ui.LoginView;
import quotify_app.usecases.login.LoginInputBoundary;
import quotify_app.usecases.login.LoginInteractor;
import quotify_app.usecases.login.LoginOutputBoundary;
import quotify_app.usecases.login.LoginUserDataAccessInterface;

/**
 * The LoginFactory class is responsible for setting up and wiring together the Login Adapter such
 * that it can be built in the App Builder.
 * It follows the Clean Architecture principles to establish each layer's dependencies and constructs the UI flow.
 */
public class LoginFactory {
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();

    private final UserFactory userFactory = new CommonUserFactory();
    private final SignupFactory signupFactory = new SignupFactory();

    private final LoginViewModel loginViewModel = new LoginViewModel();
    private final LoginView loginView = new LoginView(loginViewModel);
    private final LoginUserDataAccessInterface userDataAccessObject = new DBUserDataAccessObject(userFactory);

    // Setup Presenter for Login with necessary dependencies
    private final LoginOutputBoundary loginPresenter = new LoginPresenter(
            viewManagerModel,
            loginViewModel,
            signupFactory.getSignupViewModel()
    );

    // Setup Interactor for Login with necessary dependencies
    private final LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, loginPresenter);

    // Setup Controller for Login with necessary dependencies
    private final LoginController loginController = new LoginController(loginInteractor);

    public LoginController getLoginController() {
        return loginController;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
}
