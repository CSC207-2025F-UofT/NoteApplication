package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.joke.JokeController;
import interface_adapter.joke.JokeState;
import interface_adapter.joke.JokeViewModel;

/**
 * The View for displaying jokes and interacting with the Joke Application.
 */
public class JokeAppView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "joke view";
    private final JokeViewModel jokeViewModel;

    private final JLabel userIdLabel = new JLabel("User ID: ");
    private final JLabel jokeDisplayArea = new JLabel("Your joke will appear here");
    private final JButton generateJokeButton = new JButton("Generate Joke");
    private final JButton searchJokeButton = new JButton("Search Joke");
    private final JButton favoriteJokeButton = new JButton("Favorite Joke");
    private JokeController jokeController;

    public JokeAppView(JokeViewModel jokeViewModel) {
        this.jokeViewModel = jokeViewModel;
        this.jokeViewModel.addPropertyChangeListener(this);

        setupButtons();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(userIdLabel);
        this.add(jokeDisplayArea);
        this.add(generateJokeButton);
        this.add(searchJokeButton);
        this.add(favoriteJokeButton);
    }
    /**
     * Configures the actions for each button.
     */
    private void setupButtons() {
        // Generate Joke Action
        generateJokeButton.addActionListener(e -> jokeController.execute("Generate a joke", ""));

        // Search Joke Action
        searchJokeButton.addActionListener(e -> {
            String query = JOptionPane.showInputDialog(this, "Search for a joke:");
            if (query != null && !query.trim().isEmpty()) {
                jokeController.execute("search", query);
            }
        })
        favoriteJokeButton.addActionListener(e -> jokeController.execute("Favourite", ""));
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Handles updates from the JokeViewModel, updating the UI display accordingly.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName()) && evt.getNewValue() instanceof JokeState) {
            JokeState jokeState = (JokeState) evt.getNewValue();
            updateFields(jokeState);
        } else if ("error".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, evt.getNewValue().toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Updates the UI fields based on the current state of JokeState
     * @param state the current JokeState
     */
    private void updateFields(JokeState state) {
        jokeDisplayArea.setText(state.getJokeText());
        favoriteJokeButton.setText(state.isFavorite() ? "Unfavourite Joke" : "Favorite Joke");
        userIdLabel.setText("User ID: " + state.getErrorMessage());
    }

    public String getViewName() {
        return viewName;
    }

    public void setJokeController(JokeController jokeController) {
        this.jokeController = jokeController;
    }
}
