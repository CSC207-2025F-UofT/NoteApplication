package use_case.logout;

import data_access.FileDataAccessObject;
import entity.User;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private FileDataAccessObject fileDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(FileDataAccessObject userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.fileDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute(LogoutInputData logoutInputData) {
        final String username = logoutInputData.getUsername();
        final User currentUser = fileDataAccessObject.get(username);
        fileDataAccessObject.save(currentUser);
        fileDataAccessObject.setCurrentUsername(null);
        final LogoutOutputData logoutOutputData = new LogoutOutputData(username, false);
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }

    @Override
    public void switchtoLoginView() {
        logoutPresenter.switchtoLoginView();
    }
}

