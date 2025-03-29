package view.login;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import entity.Joke;
import use_case.login.adapter.LoginController;
import view.LabelTextPanel;
import view.favourite_view.FavouriteState;

/**
 * The View for when the user is logging into the program.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    private final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    private final JButton logInButton = new JButton("Log In");
    private final JButton cancelButton = new JButton("Cancel");
    private LoginController loginController;

    public LoginView(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        setupui();
        setupListeners();
    }

    /**
     * Set up the UI components and layout.
     */
    private void setupui() {
        final JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel usernamePanel = new LabelTextPanel(new JLabel("Username"), usernameInputField);
        final LabelTextPanel passwordPanel = new LabelTextPanel(new JLabel("Password"), passwordInputField);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.add(logInButton);
        buttonPanel.add(cancelButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernamePanel);
        this.add(usernameErrorField);
        this.add(passwordPanel);
        this.add(passwordErrorField);
        this.add(buttonPanel);
    }

    /**
     * Set up listeners for user interaction.
     */
    private void setupListeners() {
        logInButton.addActionListener(evt -> {
            final LoginState currentState = loginViewModel.getState();
            loginController.execute(currentState.getUsername(), currentState.getPassword());
        });

        cancelButton.addActionListener(this);

        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateUsername();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateUsername();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateUsername();
            }

            private void updateUsername() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                loginViewModel.setState(currentState);
            }
        });

        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePassword();
            }

            private void updatePassword() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()));
                loginViewModel.setState(currentState);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(cancelButton)) {
            loginController.switchToSignUpView();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName()) && evt.getNewValue() instanceof LoginState) {
            final LoginState state = (LoginState) evt.getNewValue();
            usernameInputField.setText(state.getUsername());
            passwordInputField.setText(state.getPassword());
            usernameErrorField.setText(state.getLoginError());
            passwordErrorField.setText("");
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
