package interface_adapter.showProfile;

import interface_adapter.ViewManagerModel;
import use_case.showProfile.ShowProfileOutputBoundary;
import use_case.showProfile.ShowProfileOutputData;
import view.ViewManager;

public class ShowProfilePresenter implements ShowProfileOutputBoundary {

    private final ShowProfileViewModel showProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ShowProfilePresenter(ShowProfileViewModel showProfileViewModel, ViewManagerModel viewManagerModel) {
        this.showProfileViewModel = showProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ShowProfileOutputData outputData) {
        // On success, switch to the Profile view.

        final ShowProfileState showProfileState = showProfileViewModel.getState();
        showProfileState.setUsername(outputData.getUsername());
        showProfileState.setRankPoint(outputData.getRankPoint());
        this.showProfileViewModel.setState(showProfileState);
        this.showProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setState(showProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
