package view.favourite_view;

import entity.Joke;
import use_case.fav_search.adapter.FavSearchController;
import use_case.funniest.adapter.FunniestController;
import view.LabelTextPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import use_case.favourite.adapter.FavouriteController;

public class FavouriteView extends JPanel implements ActionListener, PropertyChangeListener {

    private final FavouriteViewModel favouriteViewModel;

    private final String viewName;
    private FavouriteView favouriteView;

    private FavouriteController favouriteController;
    private FunniestController funniestController;
    private FavSearchController favSearchController;

    private final JTextField searchBox = new JTextField(15);
    private final JButton searchButton;
    private final JButton funniestButton;
    private final JButton cancelButton;

    public FavouriteView(FavouriteViewModel favouriteViewModel) {
        this.favouriteViewModel = favouriteViewModel;
        this.viewName = favouriteViewModel.getViewName();
        this.favouriteViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(FavouriteViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel search = new LabelTextPanel(new JLabel(FavouriteViewModel.KEYWORD_LABEL), searchBox);

        final JPanel buttons = new JPanel();
        searchButton = new JButton(FavouriteViewModel.SEARCH_BUTTOM_LABEL);
        buttons.add(searchButton);
        funniestButton = new JButton(FavouriteViewModel.FUNNIEST_BUTTOM_LABEL);
        buttons.add(funniestButton);
        cancelButton = new JButton(FavouriteViewModel.CANCEL_BUTTOM_LABEL);
        buttons.add(cancelButton);
        buttons.add(search);

        final JPanel jokeListPanel = new JPanel();
        final List<Joke> fav = favouriteViewModel.getState().getFavourites();
        for (Joke joke : fav) {
            final String content = joke.getContent();
            jokeListPanel.add(new JLabel(content));
        }

        final JSplitPane mainPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        mainPanel.setLeftComponent(buttons);
        mainPanel.setRightComponent(jokeListPanel);

        this.add(title);
        this.add(mainPanel);

        funniestButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(funniestButton)) {
                        funniestController.execute(fav);
                    }
                }
        );

        cancelButton.addActionListener(this);

        searchButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(searchButton)) {
                        favSearchController.executeSearch(searchBox.getText());
                    }
                }
        );
    }

    public void setFavouriteController(FavouriteController controller) {
        this.favouriteController = controller;
    }

    public void setFunniestController(FunniestController controller) {
        this.funniestController = controller;
    }

    public void setFavSearchController(FavSearchController controller) {
        this.favSearchController = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}