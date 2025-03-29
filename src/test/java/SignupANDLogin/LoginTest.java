package SignupANDLogin;

import data_access.UserDataAccessObject;
import entity.User;
import org.junit.Test;
import use_case.login.*;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void successTest() {
        LoginInputData inputData = new LoginInputData("uno", "uno");
        LoginUserDataAccessInterface userRepository = new UserDataAccessObject();

        User user = new User("uno", "uno");
        userRepository.save(user);

        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("uno", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToSignUpView(){}
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}