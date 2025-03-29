package view;

import entity.Joke;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

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
public class FavoritePanel extends JScrollPane {

    // UI Components
    private final DefaultListModel<String> jokeListModel;
    private final JList<String> jokeList; // Scrollable joke list

    public FavoritePanel() {

        jokeListModel = new DefaultListModel<>();
        jokeList = new JList<>(jokeListModel);
        jokeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setViewportView(jokeList);


//        // Set layout
//        setLayout(new BorderLayout());

        // Main Content: Scrollable list of favorite jokes

        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    }

    /**
     * Updates the joke list with the provided list of jokes.
     *
     * @param jokes the list of jokes to display
     */
    public void updateJokeList(List<Joke> jokes) {
        jokeListModel.clear();
        for (Joke joke : jokes) {
            String jokeString = joke.getContent();
            jokeListModel.addElement(jokeString);
        }
        this.updateUI();
    }
}
