package use_case.showProfile;

/**
 * The Input Data for the ShowProfile use case.
 */
public class ShowProfileInputData {
    private final String username;

    public ShowProfileInputData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
