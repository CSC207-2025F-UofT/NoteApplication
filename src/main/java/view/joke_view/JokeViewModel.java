package view.joke_view;

import view.ViewModel;


public class JokeViewModel extends ViewModel<JokeState> {

    public static final String TITLE_LABEL = "Joke";
    public static final String EXPLANATION_BUTTON_LABEL = "Explain";
    public static final String ADD_BUTTON_LABEL = "Add to Favorite";
    public static final String EXPLANATION_LABEL = "Explanation";

    public JokeViewModel() {
        super("Joke");
        setState(new JokeState());
    }
    // a wrapper for all the info you need to build a view