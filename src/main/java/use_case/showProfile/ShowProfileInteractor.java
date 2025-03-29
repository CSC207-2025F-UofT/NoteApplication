package use_case.showProfile;

import entity.User;

/**
 * The ShowProfile Interactor.
 */
public class ShowProfileInteractor implements ShowProfileInputBoundary {
    private final ShowProfileUserDataAccessInterface userDataAccessObject;
    private final ShowProfileOutputBoundary showProfilePresenter;

    public ShowProfileInteractor(ShowProfileUserDataAccessInterface userDataAccessObject,
                                  ShowProfileOutputBoundary showProfilePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.showProfilePresenter = showProfilePresenter;
    }

    @Override
    public void execute(ShowProfileInputData showProfileInputData) {
        // The following code only handle success use case call
        // Because I currently don't know what can cause this use case to fail
        final User user = userDataAccessObject.get(showProfileInputData.getUsername());
        final ShowProfileOutputData showProfileOutputData =
                new ShowProfileOutputData(showProfileInputData.getUsername(), user.getCurrentRankPoint(), true);
        showProfilePresenter.prepareSuccessView(showProfileOutputData);
    }
}
