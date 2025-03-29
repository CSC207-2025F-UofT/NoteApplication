package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data_access.FileDataAccessObject;
import use_case.favourite.adapter.FavouriteController;
import use_case.generate.adapter.GenerateController;
import use_case.logout.adapter.LogoutController;
import use_case.search.adapter.SearchController;

import static view.main.MainViewModel.*;

/**
 * The Main View for interacting with the Joke Application.
 */
public class MainView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = TITLE_LABEL;
    private final MainViewModel jokeViewModel;

    private final JLabel userIdLabel = new JLabel("User ID: ");
    private final JButton generateJokeButton = new JButton(GENERATE_BUTTON_LABEL);
    private final JButton searchJokeButton = new JButton(SEARCH_BUTTON_LABEL);
    private final JButton favouritePageButton = new JButton(FAVOURITE_BUTTON_LABEL);
    private final JButton logoutButton = new JButton(LOGOUT_BUTTON_LABEL);

    private LogoutController logoutController;
    private GenerateController generateController;
    private FavouriteController favouriteController;
    private SearchController searchController;
    private FileDataAccessObject fileDataAccessObject;

    public MainView(MainViewModel jokeViewModel, FileDataAccessObject fileDataAccessObject) {
        this.jokeViewModel = jokeViewModel;
        this.fileDataAccessObject = fileDataAccessObject;

        this.jokeViewModel.addPropertyChangeListener(this);

        setupButtons();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(userIdLabel);
        this.add(generateJokeButton);
        this.add(searchJokeButton);
        this.add(favouritePageButton);
        this.add(logoutButton);
    }

    /**
     * Configures the actions for each button.
     */
    private void setupButtons() {
        generateJokeButton.addActionListener(event -> generateController.execute());

        searchJokeButton.addActionListener(event -> {
            searchController.switchtoSearchView();
        });

        favouritePageButton.addActionListener(event -> {
            favouriteController.execute(fileDataAccessObject.get(jokeViewModel.getState().getUsername()));
            // Navigate to favourites
        });

        logoutButton.addActionListener(event -> {
            logoutController.execute(fileDataAccessObject.getCurrentUsername());
            logoutController.switchtoLoginView();
            // Logout logic
        });
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
     * Handles updates from the JokeViewModel.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final MainState state = (MainState) evt.getNewValue();
        setFields(state);

        if ("error".equals(evt.getPropertyName())) {
            JOptionPane.showMessageDialog(this, evt.getNewValue().toString(), ERROR_DIALOG_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setFields(MainState state) {
        userIdLabel.setText("User ID:" + state.getUsername());
    }

    public String getViewName() {
        return viewName;
    }

    public void setFavouriteController(FavouriteController favouriteController) {
        this.favouriteController = favouriteController;
    }

    public void setGenerateController(GenerateController generateController) {
        this.generateController = generateController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}
