package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.ChessDataAccessObject;
import data_access.QueryDataAccessObject;
import data_access.UserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.query.QueryViewModel;
import interface_adapter.showProfile.ShowProfileViewModel;
import interface_adapter.signup.SignupViewModel;
import view.ChessBoardView;
import view.LoggedInView;
import view.LoginView;
import view.ProfileView;
import view.QueryView;
import view.SignupView;
import view.ViewManager;

public class UserAppBuilder {
    private CardLayout cardLayout;
    private JPanel views;
    private ViewManagerModel viewManagerModel;
    private ChessBoardView chessBoardView;
    private UserDataAccessObject userDataAccessObject;
    private QueryDataAccessObject queryDataAccessObject;

    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private SignupViewModel signupViewModel;
    private ShowProfileViewModel showProfileViewModel;
    private QueryViewModel queryViewModel;

    public UserAppBuilder() {
        this.cardLayout = new CardLayout();
        this.views = new JPanel(cardLayout);
        this.viewManagerModel = new ViewManagerModel();
        this.userDataAccessObject = new UserDataAccessObject();
        this.queryDataAccessObject = new QueryDataAccessObject();

        new ViewManager(views, cardLayout, viewManagerModel);
    }

    /**
     * Set the addViewModels to be used in this application.
     * @return this builder
     */
    public UserAppBuilder addViewModels() {
        this.loginViewModel = new LoginViewModel();
        this.loggedInViewModel = new LoggedInViewModel();
        this.signupViewModel = new SignupViewModel();
        this.showProfileViewModel = new ShowProfileViewModel();
        this.queryViewModel = new QueryViewModel();

        return this;
    }

    /**
     * Set the addViews to be used in this application.
     * @return this builder
     */
    public UserAppBuilder addViews() {
        final SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel,
                userDataAccessObject);
        final LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel,
                userDataAccessObject, signupViewModel);
        final LoggedInView loggedInView = ShowProfileUseCaseFactory.create(viewManagerModel, loggedInViewModel,
            signupViewModel, showProfileViewModel, queryViewModel, userDataAccessObject, queryDataAccessObject);
        final ProfileView profileView = new ProfileView(viewManagerModel, showProfileViewModel);
        final QueryView queryView = new QueryView(viewManagerModel, queryViewModel);

        views.add(signupView, signupView.getViewName());
        views.add(loginView, loginView.getViewName());
        views.add(loggedInView, loggedInView.getViewName());
        views.add(profileView, profileView.getViewName());
        views.add(queryView, queryView.getViewName());

        return this;
    }

    /**
     * Set the addChessGame to be used in this application.
     * @return this builder
     */
    public UserAppBuilder addChessGame() {
        final ChessAppBuilder chessAppBuilder = new ChessAppBuilder();
        chessAppBuilder.addChessDAO(new ChessDataAccessObject())
                .addMoveView()
                .addMoveUseCase();

        this.chessBoardView = chessAppBuilder.buildChessBoardView();
        this.views.add(chessBoardView, "chessBoardView");
        return this;
    }

    /**
     * Set the initializeState to be used in this application.
     * @return this builder
     */
    public UserAppBuilder initializeState() {
        this.viewManagerModel.setState("signUpView");
        this.viewManagerModel.firePropertyChanged();
        return this;
    }

    /**
     * Set the build to be used in this application.
     * @return this builder
     */
    public JFrame build() {
        final JFrame frame = new JFrame("Chess Game Login");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(this.views);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
