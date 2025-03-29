package use_case.login.adapter;

import entity.Joke;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import view.favourite_view.FavouriteState;
import view.login.LoginState;
import view.login.LoginViewModel;
import view.ViewManagerModel;
import view.main.MainState;
import view.main.MainView;
import view.main.MainViewModel;
import view.signup.SignupViewModel;

import java.util.ArrayList;

public class LoginPresenter implements LoginOutputBoundary {

    private final MainViewModel mainViewModel;
    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, MainViewModel mainViewModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel) {
        this.mainViewModel = mainViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
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

    @Override
    public void switchToSignUpView() {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsername("");
        loginState.setPassword("");
        loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();
        viewManagerModel.setState(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
