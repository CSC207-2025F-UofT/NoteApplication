package use_case.login;

import entity.User;

public class LoginInteractor implements LoginInputBoundary {
    private final LoginUserDataAccessInterface userDataAccess;
    private final LoginOutputBoundary presenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccess, LoginOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(LoginInputData inputData) {
        final String username = inputData.getUsername();
        final String password = inputData.getPassword();

        if (!userDataAccess.existsByName(username)) {
            presenter.prepareFailView("User does not exist.");
        }
        else {
            final User user = userDataAccess.get(username);
            if (!user.getPassword().equals(password)) {
                presenter.prepareFailView("Incorrect password.");
            }
            else {
                userDataAccess.setCurrentUsername(username);
                presenter.prepareSuccessView(new LoginOutputData(username));
            }
        }
    }

    @Override
    public void switchToSignUpView() {
        presenter.switchToSignUpView();
    }
}
