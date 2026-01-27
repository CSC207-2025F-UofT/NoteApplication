package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * A FavoritePanel that includes a scrollable list of favorite jokes.
 */
public class FavoritePanel extends JPanel {

    // UI Components
    private final JTextField keywordField = new JTextField(20); // Text field to enter a keyword
    private final JButton searchButton = new JButton("Search");
    private final JButton funniestButton = new JButton("Funniest");
    private final JButton cancelButton = new JButton("Cancel");
    private final DefaultListModel<String> jokeListModel = new DefaultListModel<>();
    private final JList<String> jokeList = new JList<>(jokeListModel); // Scrollable joke list
    private final JScrollPane scrollPane = new JScrollPane(jokeList); // Scroll pane for the list
    private final JButton goToJokePageButton = new JButton("Go to Joke Page");
    private final JButton goToLoginPageButton = new JButton("Go to Login Page");

    public FavoritePanel() {
        // Set layout
        setLayout(new BorderLayout());

        // Top Panel: Search bar and action buttons
        final JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Enter Keyword:"));
        topPanel.add(keywordField);
        topPanel.add(searchButton);
        topPanel.add(funniestButton);
        topPanel.add(cancelButton);
        add(topPanel, BorderLayout.NORTH);

        // Main Content: Scrollable list of favorite jokes
        jokeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel: Navigation buttons
        final JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(goToJokePageButton);
        bottomPanel.add(goToLoginPageButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Populate with dummy data for demonstration
        populateDummyData();
    }

    /**
     * Populates the joke list with dummy data for testing.
     * Remove this method in production.
     */
    private void populateDummyData() {
        for (int i = 1; i <= 50; i++) {
            jokeListModel.addElement("Favorite Joke " + i);
        }
    }

    /**
     * Updates the joke list with the provided list of jokes.
     *
     * @param jokes the list of jokes to display
     */
    public void updateJokeList(java.util.List<String> jokes) {
        jokeListModel.clear();
        for (String joke : jokes) {
            jokeListModel.addElement(joke);
        }
    }

    /**
     * Gets the keyword entered in the search field.
     *
     * @return the entered keyword
     */
    public String getEnteredKeyword() {
        return keywordField.getText().trim();
    }

    /**
     * Sets the ActionListener for the search button.
     *
     * @param listener the ActionListener for the search button
     */
    public void setSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the funniest button.
     *
     * @param listener the ActionListener for the funniest button
     */
    public void setFunniestButtonListener(ActionListener listener) {
        funniestButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the cancel button.
     *
     * @param listener the ActionListener for the cancel button
     */
    public void setCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the "Go to Joke Page" button.
     *
     * @param listener the ActionListener for the navigation button
     */
    public void setGoToJokePageButtonListener(ActionListener listener) {
        goToJokePageButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the "Go to Login Page" button.
     *
     * @param listener the ActionListener for the navigation button
     */
    public void setGoToLoginPageButtonListener(ActionListener listener) {
        goToLoginPageButton.addActionListener(listener);
    }
}
