package interface_adapter.showProfile;

import interface_adapter.ViewModel;

/**
 * The View Model for the profile view.
 */
public class ShowProfileViewModel extends ViewModel<ShowProfileState> {

    public ShowProfileViewModel() {
        super("showProfile");
        setState(new ShowProfileState());
    }

    public String getUsername() {
        return getState().getUsername();
    }

    public int getRankPoint() {
        return getState().getRankPoint();
    }
}
