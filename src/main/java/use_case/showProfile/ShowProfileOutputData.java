package use_case.showProfile;

/**
 * Output Data for the ShowProfile Use case.
 */
public class ShowProfileOutputData {

    private final String username;
    private final int rankPoint;
    private final boolean useCaseSucceeded;

    public ShowProfileOutputData(String username, int rankPoint, boolean useCaseSucceeded) {
        this.username = username;
        this.rankPoint = rankPoint;
        this.useCaseSucceeded = useCaseSucceeded;
    }

    public int getRankPoint() {
        return rankPoint;
    }

    public String getUsername() {
        return username;
    }

}
