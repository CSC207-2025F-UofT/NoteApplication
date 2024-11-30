package use_case.generate;

import data_access.JokeDataAccessObject;
import use_case.generate.adapter.GenerateController;
import use_case.generate.adapter.GeneratePresenter;
import view.joke_view.JokeFrameBuilder;

public class GenerateTest {
    public static void main(String[] args) {
        //pretend that the generate button is pressed
        // this is not a unit test
        new GenerateController(new GenerateInteractor(new JokeDataAccessObject(), new GeneratePresenter(new JokeFrameBuilder()))).execute();
    }
}
