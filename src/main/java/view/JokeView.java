package view;

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
    private final JButton generateJokeButton = new JButton("Generate Joke");
    private final JButton searchJokeButton = new JButton("Search Joke");
    private final JButton favoriteJokeButton = new JButton("Favourite Joke");
    private final JButton logoutButton = new JButton("Log out");
    private JokeController jokeController;

    public JokeAppView(JokeViewModel jokeViewModel) {
        this.jokeViewModel = jokeViewModel;
        this.jokeViewModel.addPropertyChangeListener(this);

        setupButtons();

        // Set up layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(userIdLabel);
        this.add(generateJokeButton);
        this.add(searchJokeButton);
        this.add(favoriteJokeButton);
        this.add(logoutButton);
    }

    /**
     * Configures the actions for each button.
     */
    private void setupButtons() {
        generateJokeButton.addActionListener(e -> jokeController.execute("Generate", ""));

        searchJokeButton.addActionListener(e -> {
            String query = JOptionPane.showInputDialog(this, "Search Joke:");
            if (query != null && !query.trim().isEmpty()) {
                jokeController.execute("search", query);
            }
        });

        favoriteJokeButton.addActionListener(e -> jokeController.execute("Favourite", ""));
        logoutButton.addActionListener(e -> System.out.println("Logout action triggered"));  // Placeholder for logout action
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
            displayJoke(jokeState.getJokeText());
            updateFavoriteButton(jokeState.isFavorite());
        } else if ("error".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, evt.getNewValue().toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays the joke in a pop-up dialog.
     * @param jokeText the joke text to display
     */
    private void displayJoke(String jokeText) {
        JOptionPane.showMessageDialog(this, jokeText, "Here's Your Joke", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Updates the favorite button text based on the favorite status.
     * @param isFavorite the favorite status
     */
    private void updateFavoriteButton(boolean isFavorite) {
        favoriteJokeButton.setText(isFavorite ? "Unfavourite Joke" : "Favourite Joke");
    }

    public String getViewName() {
        return viewName;
    }

    public void setJokeController(JokeController jokeController) {
        this.jokeController = jokeController;
    }
}
