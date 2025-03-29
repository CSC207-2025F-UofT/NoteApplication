package use_case.login.adapter;

import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import view.login.LoginViewModel;
import view.ViewManagerModel;
import view.main.MainState;
import view.main.MainView;
import view.main.MainViewModel;

public class LoginPresenter implements LoginOutputBoundary {

    private final MainViewModel mainViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, MainViewModel mainViewModel, LoginViewModel loginViewModel) {
        this.mainViewModel = mainViewModel;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        final MainState mainState = mainViewModel.getState();
        mainState.setUsername(response.getUsername());
        mainViewModel.setState(mainState);
        mainViewModel.firePropertyChanged();

        this.viewManagerModel.setState(mainViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
    }
}
