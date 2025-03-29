package use_case.funniest.adapter;

import entity.Joke;
import use_case.funniest.FunniestInputBoundary;
import use_case.funniest.FunniestInputData;

import java.util.List;

public class FunniestController {
    private final FunniestInputBoundary funniestInputBoundary;

    public FunniestController(FunniestInputBoundary funniestInteractor) {
        this.funniestInputBoundary = funniestInteractor;
    }

    public void execute(List<Joke> favourites) {
        final FunniestInputData funniestInputData = new FunniestInputData(favourites);
        funniestInputBoundary.execute(funniestInputData);
    }
}
