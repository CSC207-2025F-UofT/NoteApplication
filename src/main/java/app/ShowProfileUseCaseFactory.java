package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInController;
import interface_adapter.logged_in.LoggedInPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.query.QueryController;
import interface_adapter.query.QueryPresenter;
import interface_adapter.query.QueryViewModel;
import interface_adapter.showProfile.ShowProfileController;
import interface_adapter.showProfile.ShowProfilePresenter;
import interface_adapter.showProfile.ShowProfileViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.logged_in.LoggedInInputBoundary;
import use_case.logged_in.LoggedInInteractor;
import use_case.logged_in.LoggedInOutputBoundary;
import use_case.query.QueryDataAccessInterface;
import use_case.query.QueryInputBoundary;
import use_case.query.QueryInteractor;
import use_case.query.QueryOutputBoundary;
import use_case.showProfile.ShowProfileInputBoundary;
import use_case.showProfile.ShowProfileInteractor;
import use_case.showProfile.ShowProfileOutputBoundary;
import use_case.showProfile.ShowProfileUserDataAccessInterface;
import view.LoggedInView;

/**
 * This class contains the static factory function for creating the LoggedInView.
 */
public final class ShowProfileUseCaseFactory {

    /** Prevent instantiation. */
    private ShowProfileUseCaseFactory() {

    }

    /**
     * Factory function for creating the LoggedInView.
     *
     * @param viewManagerModel     the ViewManagerModel to inject into the LoggedInView
     * @param loggedInViewModel    the loggedInViewModel to inject into the LoggedInView
     * @param signupViewModel      the signupViewModel
     * @param showProfileViewModel the showProfileViewModel
     * @param userDataAccessObject the ChangePasswordUserDataAccessInterface to inject into the LoggedInView
     * @param queryViewModel       the QueryViewModel to inject into the LoggedInView
     * @param queryDataAccessObject the Query DataAccessObject
     * @return the LoggedInView created for the provided input classes
     */
    public static LoggedInView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            SignupViewModel signupViewModel,
            ShowProfileViewModel showProfileViewModel,
            QueryViewModel queryViewModel,
            ShowProfileUserDataAccessInterface userDataAccessObject,
            QueryDataAccessInterface queryDataAccessObject) {

        final ShowProfileController showProfileController =
                createShowProfileUseCase(viewManagerModel,
                        showProfileViewModel, userDataAccessObject);

        final QueryOutputBoundary queryOutputBoundary = new QueryPresenter(queryViewModel, viewManagerModel);
        final QueryInputBoundary queryInputInteractor = new QueryInteractor(queryDataAccessObject, queryOutputBoundary);
        final QueryController queryController = new QueryController(queryInputInteractor);

        final LoggedInController loggedInController = createLoggedInUseCase(viewManagerModel, loggedInViewModel,
                signupViewModel);

        return new LoggedInView(viewManagerModel, loggedInController, loggedInViewModel,
                showProfileController, queryController);
    }

    private static ShowProfileController createShowProfileUseCase(
            ViewManagerModel viewManagerModel,
            ShowProfileViewModel showProfileViewModel,
            ShowProfileUserDataAccessInterface userDataAccessObject) {

        final ShowProfileOutputBoundary showProfileOutputBoundary = new ShowProfilePresenter(showProfileViewModel,
                viewManagerModel);

        final ShowProfileInputBoundary showProfileInputInteractor = new ShowProfileInteractor(userDataAccessObject,
                showProfileOutputBoundary);

        return new ShowProfileController(showProfileInputInteractor);
    }

    private static LoggedInController createLoggedInUseCase(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            SignupViewModel signupViewModel) {

        final LoggedInOutputBoundary loggedInOutputBoundary = new LoggedInPresenter(viewManagerModel, loggedInViewModel,
                signupViewModel);

        final LoggedInInputBoundary loggedInInputBoundary = new LoggedInInteractor(loggedInOutputBoundary);

        return new LoggedInController(loggedInInputBoundary);
    }
}
