package use_case.generate.adapter;

import data_access.ExplanationDataAccessObject;
import data_access.MockExplanationDataAccessObject;
import use_case.explain.ExplanationDataAccessInterface;
import use_case.generate.GenerateOuputBoundary;

import javax.swing.*;

/**
 * simple presenter for demo, need to change (view model and stuff)
 */
public class DemoGeneratePresenter implements GenerateOuputBoundary {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;

    @Override
    public void prepareSuccessView(String jokeContent) {
        ExplanationDataAccessInterface explainator = new MockExplanationDataAccessObject();
//        ExplanationDataAccessInterface explainator = new ExplanationDataAccessObject();
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Joke");
        frame.setSize(WIDTH, HEIGHT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JTextArea(jokeContent + explainator.getExplanation(jokeContent)));

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Joke");
        frame.setSize(WIDTH, HEIGHT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JTextArea(5, 20));


        frame.add(panel);
        frame.setVisible(true);
    }
}
