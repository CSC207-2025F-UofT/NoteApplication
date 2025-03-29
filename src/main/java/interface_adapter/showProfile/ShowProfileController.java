package interface_adapter.showProfile;

import use_case.showProfile.ShowProfileInputBoundary;
import use_case.showProfile.ShowProfileInputData;

/**
 * The controller for the ShowProfile use case.
 */
public class ShowProfileController {

    private final ShowProfileInputBoundary showProfileInputInteractor;

    public ShowProfileController(ShowProfileInputBoundary showProfileInteractor) {
        this.showProfileInputInteractor = showProfileInteractor;
    }

    /**
     * Execute the showProfile use case.
     * @param username the username of the user logging in
     */
    public void execute(String username) {
        final ShowProfileInputData showProfileInputData = new ShowProfileInputData(username);

        showProfileInputInteractor.execute(showProfileInputData);
    }
}
