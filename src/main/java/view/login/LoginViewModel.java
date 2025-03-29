package view.login;

import view.ViewModel;

public class LoginViewModel extends ViewModel<LoginState> {

    public LoginViewModel() {
        super("log in");
        setState(new LoginState());
    }

}