package view.joke_view;

import use_case.add_to_fav.adapter.AddToFavController;
import use_case.explanation.adapter.ExplanationController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JokeView extends JPanel implements PropertyChangeListener, ActionListener {

    private final String viewName;
    private final JokeViewModel jokeViewModel;

    private final JTextArea jokeContent = new JTextArea(3, 20);
    private final JTextArea explanation = new JTextArea(10, 20);

    // Controllers
    // each function of a controller is a button
    private final JButton explain;
    private final JButton addToFav;
    private AddToFavController addController;
    private ExplanationController explanationController;

    public JokeView(JokeViewModel jokeViewModel) {

        this.jokeViewModel = jokeViewModel;
        this.jokeViewModel.addPropertyChangeListener(this);
        this.viewName = jokeViewModel.getViewName();

        final JLabel title = new JLabel(JokeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel explanationLabel = new JLabel(JokeViewModel.EXPLANATION_LABEL);
        explanationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        explain = new JButton(JokeViewModel.EXPLANATION_BUTTON_LABEL);
        buttons.add(explain);
        addToFav = new JButton(JokeViewModel.ADD_BUTTON_LABEL);
        buttons.add(addToFav);

        explain.addActionListener(
                evt -> {
                    if (evt.getSource().equals(explain)) {
                        final JokeState currentState = jokeViewModel.getState();

                        explanationController.execute(
                                currentState.getJokeContent()
                        );
                    }
                }
        );

        addToFav.addActionListener(
                evt -> {
                    if (evt.getSource().equals(addToFav)) {
                        final JokeState currentState = jokeViewModel.getState();
                        //can change depending on how addController is implemented
                        addController.execute(
                                currentState.getJokeContent(),
                                currentState.getExplanation());
                    }
                }
        );

        // a smaller (than view) observer pattern
        jokeContent.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final JokeState currentState = jokeViewModel.getState();
                currentState.setJokeContent(jokeContent.getText());
                jokeViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        explanation.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final JokeState currentState = jokeViewModel.getState();
                currentState.setExplanation(explanation.getText());
                jokeViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.add(title);
        this.add(jokeContent);
        this.add(explanationLabel);
        this.add(explanation);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final JokeState state = (JokeState) evt.getNewValue();
        setFields(state);
        changeAddToFavText(state);
    }

    private void setFields(JokeState state) {
        jokeContent.setText(state.getJokeContent());
        explanation.setText(state.getExplanation());
    }

    public String getViewName() {
        return viewName;
    }

    public void setExplanationController(ExplanationController explanationController) {
        this.explanationController = explanationController;
    }

    public void setAddController(AddToFavController addController) {
        this.addController = addController;
    }

    public void changeAddToFavText(JokeState jokeState) {
        addToFav.setText(jokeState.getAddToFav());
    }
}
