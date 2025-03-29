package app;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import entity.CheckUsage;
import interface_adapter.checkUsage.CheckUsageController;
import interface_adapter.checkUsage.CheckUsagePresenter;
import interface_adapter.checkUsage.CheckUsageViewModel;
import use_case.checkUsage.CheckUsageDataAccessInterface;
import use_case.checkUsage.CheckUsageInteractor;
import use_case.checkUsage.CheckUsageOutputBoundary;
import view.checkUsage.CheckUsageView;

/**
 * Builder for the File Translator Application.
 */

public class CheckUsageAppBuilder {
    public static final int HEIGHT = 250;
    public static final int WIDTH = 400;
    private CheckUsageDataAccessInterface checkUsageDAO;
    private CheckUsageViewModel checkUsageViewModel = new CheckUsageViewModel();
    private CheckUsageView checkUsageView;
    private CheckUsageInteractor checkUsageInteractor;

    /**
     * Sets the checkUsageDAO to be used in this application.
     * @param checkUsageDataAccess the DAO to use
     * @return this builder
     */
    public CheckUsageAppBuilder addCheckUsageDAO(CheckUsageDataAccessInterface checkUsageDataAccess) {
        checkUsageDAO = checkUsageDataAccess;
        return this;
    }

    /**
     * Creates the objects for the CheckUsage Use Case and connects the CheckUsageView to its
     * controller.
     * <p>This method must be called after addCheckUsageView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addCheckUsageView
     */
    public CheckUsageAppBuilder addCheckUsageUseCase() {
        final CheckUsageOutputBoundary checkUsageOutputBoundary =
                new CheckUsagePresenter(checkUsageViewModel);
        final CheckUsage checkUsage = new CheckUsage(checkUsageDAO);

        checkUsageInteractor = new CheckUsageInteractor(checkUsageDAO, checkUsageOutputBoundary,
                checkUsage);

        final CheckUsageController controller = new CheckUsageController(checkUsageInteractor);
        if (checkUsageView == null) {
            throw new RuntimeException("addCheckUsageView must be called before addCheckUsageUseCase");
        }
        checkUsageView.setCheckUsageController(controller);
        return this;
    }

    /**
     * Creates the CheckUsageView and underlying CheckUsageViewModel.
     * @return this builder
     */
    public CheckUsageAppBuilder addCheckUsageView() {
        checkUsageViewModel = new CheckUsageViewModel();
        checkUsageView = new CheckUsageView(checkUsageViewModel);
        return this;
    }

    /**
     * Builds the translator application.
     * @return the JFrame for the application
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setTitle("Translator Application - User Usage");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(checkUsageView);

        return frame;
    }
}
