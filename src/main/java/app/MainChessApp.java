package app;

/**
 * Main that activates login page.
 */
public class MainChessApp {

    /**
     * The main method for starting the program with an external database used to persist user data.
     * @param args input to main
     */
    public static void main(String[] args) {

        final UserAppBuilder userAppBuilder = new UserAppBuilder();
        userAppBuilder.addViewModels()
                .addViews()
                .initializeState()
                .addChessGame()
                .build();
    }
}
