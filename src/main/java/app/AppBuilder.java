package app;

import data_access.FileDataAccessObject;
import data_access.JokeDataAccessObject;
import entity.UserFactory;
import view.ViewManagerModel;
import use_case.login.adapter.LoginController;
import use_case.login.adapter.LoginPresenter;
import view.login.LoginViewModel;
import use_case.fav_search.*;
import use_case.fav_search.adapter.FavSearchController;
import use_case.fav_search.adapter.FavSearchPresenter;
import use_case.favourite.FavouriteInputBoundary;
import use_case.favourite.FavouriteInteractor;
import use_case.favourite.FavouriteOutputBoundary;
import use_case.favourite.adapter.FavouriteController;
import use_case.favourite.adapter.FavouritePresenter;
import use_case.funniest.FunniestInputBoundary;
import use_case.funniest.FunniestInteractor;
import use_case.funniest.FunniestOutputBoundary;
import use_case.generate.GenerateInputBoundary;
import use_case.generate.GenerateInteractor;
import use_case.generate.GenerateOuputBoundary;
import use_case.generate.adapter.GenerateController;
import use_case.generate.adapter.GeneratePresenter;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.logout.adapter.LogoutController;
import use_case.logout.adapter.LogoutPresenter;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.search.adapter.SearchController;
import use_case.search.adapter.SearchPresenter;
import use_case.search.adapter.SearchViewModel;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.adapter.SignupController;
import use_case.signup.adapter.SignupPresenter;
import view.signup.SignupViewModel;
import view.login.LoginView;
import view.SearchView;
import view.signup.SignupView;
import view.ViewManager;
import view.favourite_view.FavouriteView;
import view.favourite_view.FavouriteViewModel;
import view.joke_view.JokeFrameBuilder;
import view.main.MainView;
import view.main.MainViewModel;

import javax.swing.*;
import java.awt.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new UserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final FileDataAccessObject userDataAccessObject = new FileDataAccessObject("src/main/resources/Users.json");
    private final JokeDataAccessObject jokeDataAccessObject = new JokeDataAccessObject();
    private final JokeFrameBuilder jokeFrameBuilder = new JokeFrameBuilder();

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginView loginView;
    private LoginViewModel loginViewModel;
    private MainView mainView;
    private MainViewModel mainViewModel;
    private SearchView searchView;
    private SearchViewModel searchViewModel;
    private FavouriteView favouriteView;
    private FavouriteViewModel favouriteViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addMainView() {
        mainViewModel = new MainViewModel();
        mainView = new MainView(mainViewModel);
        cardPanel.add(mainView, mainView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addSearchView() {
        searchViewModel = new SearchViewModel();
        searchView = new SearchView(searchViewModel);
        cardPanel.add(searchView, searchView.getViewName());
        return this;
    }

    public AppBuilder addFavouriteView() {
        favouriteViewModel = new FavouriteViewModel();
        favouriteView = new FavouriteView(favouriteViewModel);
        cardPanel.add(favouriteView, favouriteView.getViewName());
        return this;
    }


    /**
     * Adds the Signup Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel, searchViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        // viewModels Injected to Presenter here.
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                mainViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSearchUseCase() {
        final SearchOutputBoundary searchOutputBoundary =
                new SearchPresenter(userDataAccessObject, jokeFrameBuilder);

        final SearchInputBoundary searchInteractor =
                new SearchInteractor(jokeDataAccessObject, searchOutputBoundary);

        final SearchController searchController =
                new SearchController(searchInteractor);
        mainView.setSearchController(searchController);
        searchView.setSearchController(searchController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addFavouriteUseCase() {
        final FavouriteOutputBoundary favouriteOutputBoundary =
                new FavouritePresenter(favouriteViewModel);

        final FavouriteInputBoundary favouriteInputBoundary =
                new FavouriteInteractor(userDataAccessObject, favouriteOutputBoundary);

        final FavouriteController favouriteController =
                new FavouriteController(favouriteInputBoundary);
        mainView.setFavouriteController(favouriteController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addFavSearchUseCase() {
        final FavSearchOutputBoundary favSearchOutputBoundary =
                new FavSearchPresenter(jokeFrameBuilder);

        final FavSearchInputBoundary favSearchInteractor =
                new FavSearchInteractor(favSearchOutputBoundary, userDataAccessObject);

        final FavSearchController favSearchController =
                new FavSearchController(favSearchInteractor);
        favouriteView.setFavSearchController(favSearchController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addFunniestUseCase() {
        final FunniestOutputBoundary funniestOutputBoundary =
                new FunniestPresenter(favouriteViewModel);

        final FunniestInputBoundary funniestInputBoundary =
                new FunniestInteractor(funniestOutputBoundary);

        final FunniestController funniestController =
                new FunniestController(funniestInputBoundary);
        favouriteView.setFunniestController(funniestController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addGenerateUseCase() {
        final GenerateOuputBoundary generateOuputBoundary =
                new GeneratePresenter(jokeFrameBuilder);

        final GenerateInputBoundary generateInputBoundary =
                new GenerateInteractor(jokeDataAccessObject, generateOuputBoundary);

        final GenerateController generateController =
                new GenerateController(generateInputBoundary);
        mainView.setGenerateController(generateController);
        return this;
    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                mainViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        mainView.setLogoutController(logoutController);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Joke Machine");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
