package view.main;

import view.ViewModel;

public class MainViewModel extends ViewModel<MainState> {
    // Constants for UI labels
    public static final String TITLE_LABEL = "Joke Application";
    public static final String GENERATE_BUTTON_LABEL = "Generate Joke";
    public static final String SEARCH_BUTTON_LABEL = "Search Joke";
    public static final String FAVOURITE_BUTTON_LABEL = "Go to Favourites";
    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    public static final String ERROR_DIALOG_TITLE = "Error";

    public MainViewModel() {
        super("Joke");
        setState(new MainState());
    }
}
