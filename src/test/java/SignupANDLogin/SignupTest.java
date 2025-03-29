package SignupANDLogin;

import org.junit.Test;
import use_case.signup.*;
import data_access.UserDataAccessObject;

import static org.junit.Assert.*;

public class SignupTest {

    @Test
    public void successTest() {
        SignupInputData inputData = new SignupInputData("uno", "uno", "uno");
        SignupUserDataAccessInterface userRepository = new UserDataAccessObject();

        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("uno", user.getUsername());
                assertTrue(userRepository.existsByName("uno"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToLoginView() {
                // This is expected
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }
}
