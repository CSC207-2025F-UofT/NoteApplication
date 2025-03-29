package view;

import entity.RankHistory;
import interface_adapter.ViewManagerModel;
import interface_adapter.query.QueryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The view of user profile.
 */
public class QueryView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "query";
    private final QueryViewModel queryViewModel;
    private final JPanel contentPanel;

    public QueryView(ViewManagerModel viewManagerModel, QueryViewModel queryViewModel) {
        this.queryViewModel = queryViewModel;
        this.queryViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Rank History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JScrollPane scrollPane = new JScrollPane();

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1));

        scrollPane.setViewportView(contentPanel);

        this.add(title);
        this.add(scrollPane);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final RankHistory rankHistory = queryViewModel.getRankHistoryList();
        for (int i = 0; i < rankHistory.getRanks().size(); i++) {
            contentPanel.add(new JLabel(rankHistory.getRanks().get(i).toString()));
        }
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }

}
