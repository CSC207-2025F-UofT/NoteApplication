package view;

import use_case.favourite.adapter.FavouriteViewModel;
import view.helper_functions.LabelTextPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import use_case.favourite.adapter.FavouriteController;
import use_case.favourite.adapter.FavouriteState;

public class FavouriteView extends JPanel {

    private final FavouriteController favouriteController;
    private final FavouriteViewModel favouriteViewModel;

    private final String viewName = "Favourite";
    private FavouriteView favouriteView;

    private final JTextArea keywordInputField = new JTextArea();

    private final JTextField searchBox = new JTextField(15);
    private final JButton searchButton;
    private final JButton funniestButton;
    private final JButton cancelButton;

    public FavouriteView(FavouriteViewModel favouriteViewModel, FavouriteController controller) {
        this.favouriteController = controller;
        this.favouriteViewModel = favouriteViewModel;
//        this.favouriteViewModel.addPropertyChangeListener(this);

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

        this.add(title);
        this.add(search);
        this.add(buttons);

//        funniestButton.addActionListener(
//                evt -> {
//                    if (evt.getSource().equals(funniestButton)) {
//                        favouriteController.execute(favouriteInputField.getText());
//
//                    }
//                }
//        );
//
//        refreshButton.addActionListener(
//                evt -> {
//                    if (evt.getSource().equals(refreshButton)) {
//                        favouriteController.execute(null);
//
//                    }
//                }
//        );
//    }
//
//    /**
//     * React to a button click that results in evt.
//     * @param evt the ActionEvent to react to
//     */
//    public void actionPerformed(ActionEvent evt) {
//        System.out.println("Click " + evt.getActionCommand());
//    }
//
//    public void propertyChange(PropertyChangeEvent evt) {
//        final FavouriteState state = (FavouriteState) evt.getNewValue();
//        setFields(state);
//        usernameErrorField.setText(state.getFavouriteError());
//    }
//
//    private void setFields(FavouriteState state) {
//        usernameInputField.setText(state.getUsername());
//    }
//
//    public String getViewName() {
//        return viewName;
//    }
    }
}