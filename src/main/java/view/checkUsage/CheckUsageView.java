package view.checkUsage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data_access.DBCheckUsageDataAccessObject;
import interface_adapter.checkUsage.CheckUsageController;
import interface_adapter.checkUsage.CheckUsageState;
import interface_adapter.checkUsage.CheckUsageViewModel;
import use_case.checkUsage.CheckUsageDataAccessInterface;

/**
 * The View for when the user is translating a file.
 */
public class CheckUsageView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final Dimension BUTTONS_DIM = new Dimension(250, 35);
    private static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 18);
    private static final Color BUTTON_COLOR = new Color(108, 184, 198);

    private final CheckUsageViewModel checkUsageViewModel;

    private final JLabel title = new JLabel("Current Usage");
    private final JTextField characterCountOutputField = new JTextField(15);
    private final JTextField characterLimitOutputField = new JTextField(15);
    private final CheckUsageDataAccessInterface checkUsageDai = new DBCheckUsageDataAccessObject();

    private final JButton checkUsageButton = new JButton("Check Current Usage");
    private CheckUsageController checkUsageController;
    private final CheckUsageState checkUsageState = new CheckUsageState();

    public CheckUsageView(CheckUsageViewModel checkUsageViewModel) {

        this.checkUsageViewModel = checkUsageViewModel;
        this.checkUsageViewModel.addPropertyChangeListener(this);

        this.characterCountOutputField.setEditable(false);
        this.characterLimitOutputField.setEditable(false);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel usageCount = new LabelTextPanel(
                new JLabel("character count"), characterCountOutputField);
        final LabelTextPanel usageLimit = new LabelTextPanel(
                new JLabel("character limit"), characterLimitOutputField);

        final JPanel bottons = new JPanel();
        checkUsageButton.setPreferredSize(BUTTONS_DIM);
        checkUsageButton.setBackground(BUTTON_COLOR);
        checkUsageButton.setFont(BUTTON_FONT);
        bottons.add(checkUsageButton);

        checkUsageButton.addActionListener(
                evt -> {
                    checkUsageController.execute();
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usageCount);
        this.add(usageLimit);
        this.add(bottons);
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
        final CheckUsageState state = (CheckUsageState) evt.getNewValue();
        setFields(state);
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setFields(CheckUsageState state) {
        characterCountOutputField.setText(state.getCharacterCount());
        characterLimitOutputField.setText(state.getCharacterLimit());
    }

    public void setCheckUsageController(CheckUsageController controller) {
        this.checkUsageController = controller;
    }

}
