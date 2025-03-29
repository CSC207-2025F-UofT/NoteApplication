package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import use_case.search.adapter.SearchController;
import use_case.search.adapter.SearchViewModel;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName;
    private final SearchViewModel searchViewModel;

    private final JLabel searchLabel;
    private final JTextField keywordInputField = new JTextField(15);

    private final JButton searchButton;
    private final JButton cancelButton;
    private SearchController searchController;

    public SearchView(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
        this.viewName = searchViewModel.getViewName();
        this.searchViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchLabel = new JLabel(SearchViewModel.SEARCH_LABEL);
        final LabelTextPanel searchBox = new LabelTextPanel(searchLabel, this.keywordInputField);

        final JPanel buttons = new JPanel();
        searchButton = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(searchButton);
        cancelButton = new JButton(SearchViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancelButton);

        searchButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(searchButton)) {
                        searchController.execute(keywordInputField.getText());
                    }
                }
        );

        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        searchController.switchToMainView();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchBox);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public String getViewName() {
        return viewName;
    }
}

