package use_case.funniest;

import entity.Joke;

import java.util.List;

public class FunniestInteractor implements FunniestInputBoundary {

    private final FunniestOutputBoundary funniestOutputBoundary;

    public FunniestInteractor(FunniestOutputBoundary funniestoutputBoundary) {
        this.funniestOutputBoundary = funniestoutputBoundary;
    }

    @Override
    public void execute(FunniestInputData funniestInputData) {
        final List<Joke> jokeList = funniestInputData.getFavouriteJokeList();
        Joke funniestJoke = jokeList.get(0);
        for (Joke joke : jokeList) {
            if (joke.getScore() > funniestJoke.getScore()) {
                funniestJoke = joke;
            }
        }
        // interactor gets input data and outputs output data
        final FunniestOutputData funniestOutputData = new FunniestOutputData(funniestJoke);

        funniestOutputBoundary.prepareSuccessView(funniestOutputData);
    }
}
