package interface_adapter.joke;

import interface_adapter.ViewModel;

/**
 * The View Model for the Joke View.
 */
public class MainViewModel extends ViewModel<MainState> {

    public MainViewModel() {
        super("joke view");
        setState(new MainState());
    }
}
