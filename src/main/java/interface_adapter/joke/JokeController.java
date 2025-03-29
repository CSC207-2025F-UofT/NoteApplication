package interface_adapter.joke;

import use_case.joke.JokeInputBoundary;
import use_case.joke.JokeInputData;

/**
 * The controller for the Joke Use Case.
 */
public class JokeController {

    private final JokeInputBoundary jokeUseCaseInteractor;

    public JokeController(JokeInputBoundary jokeUseCaseInteractor) {
        this.jokeUseCaseInteractor = jokeUseCaseInteractor;
    }

    /**
     * Executes the Joke Use Case.
     * @param actionType the type of action (e.g., "generate", "search", "favorite")
     * @param query the search query for finding a joke, if applicable
     */
    public void execute(String actionType, String query) {
        JokeInputData jokeInputData = new JokeInputData(actionType, query);

        jokeUseCaseInteractor.execute(jokeInputData);
    }
}
