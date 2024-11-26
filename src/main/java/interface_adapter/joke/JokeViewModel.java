package interface_adapter.joke;

import interface_adapter.ViewModel;

/**
 * The View Model for the Joke View.
 */
public class JokeViewModel extends ViewModel<JokeState> {

    public JokeViewModel() {
        super("joke view");
        setState(new JokeState());  // Initialize with a new JokeState
    }
}
