package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.joke.MainState;
import interface_adapter.joke.JokeViewModel;
import interface_adapter.joke.MainViewModel;
import use_case.joke.JokeOutputBoundary;
import use_case.joke.JokeOutputData;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * The Presenter for the Joke Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final MainViewModel mainViewModel;
    private final ViewManagerModel viewManagerModel;
    private final  LoginViewModel loginViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, MainViewModel mainViewModel,
                         LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainViewModel = mainViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        MainState mainState = mainViewModel.getState();
        mainState.setJokeText(response.getJokeText());
        mainViewModel.setState(jokeState);
        mainViewModel.firePropertyChanged();

        viewManagerModel.setState(mainViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        MainState mainState = mainViewModel.getState();
        jokeState.setErrorMessage(error);
        mainViewModel.setState(jokeState);
        mainViewModel.firePropertyChanged("error");
    }
}
