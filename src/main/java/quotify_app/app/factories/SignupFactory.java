package quotify_app.app.factories;

import quotify_app.adapters.ViewManagerModel;
import quotify_app.adapters.signup.SignupController;
import quotify_app.adapters.signup.SignupPresenter;
import quotify_app.adapters.signup.SignupViewModel;
import quotify_app.data_access.DBUserDataAccessObject;
import quotify_app.entities.CommonUserFactory;
import quotify_app.entities.UserFactory;
import quotify_app.ui.SignupView;
import quotify_app.usecases.signup.SignupInputBoundary;
import quotify_app.usecases.signup.SignupInteractor;
import quotify_app.usecases.signup.SignupOutputBoundary;
import quotify_app.usecases.signup.SignupUserDataAccessInterface;

/**
 * The SignupFactory class is responsible for setting up and wiring together the Signup Adapter such
 * that it can be built in the App Builder.
 * It follows the Clean Architecture principles to establish each layer's dependencies and constructs the UI flow.
 */
public class SignupFactory {
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();

    private final UserFactory userFactory = new CommonUserFactory();
    private final LoginFactory loginFactory = new LoginFactory();

    private final SignupViewModel signupViewModel = new SignupViewModel();
    private final SignupView signupView = new SignupView(signupViewModel);
    private final SignupUserDataAccessInterface userDataAccessObject = new DBUserDataAccessObject(userFactory);

    /*
     * Setup presenter with necessary dependencies
     */
    private final SignupOutputBoundary signupPresenter = new SignupPresenter(
            viewManagerModel,
            signupViewModel,
            loginFactory.getLoginViewModel()
    );

    /*
     * Setup interactor with necessary dependencies
     */
    private final SignupInputBoundary signupInteractor = new SignupInteractor(
            userDataAccessObject,
            signupPresenter,
            userFactory
    );

    // Controller connects the view to the interactor
    private final SignupController signupController = new SignupController(signupInteractor);

    public SignupViewModel getSignupViewModel() {
        return signupViewModel;
    }

    public SignupView getSignupView() {
        return signupView;
    }

    public SignupController getSignupController() {
        return signupController;
    }
}
