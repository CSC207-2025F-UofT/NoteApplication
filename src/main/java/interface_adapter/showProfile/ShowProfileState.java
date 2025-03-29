package interface_adapter.showProfile;

/**
 * The State information representing the logged-in user.
 */
public class ShowProfileState {
    private String username = "";
    private int rankPoint;

    public ShowProfileState() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRankPoint(int rankPoint) {
        this.rankPoint = rankPoint;
    }

    public String getUsername() {
        return username;
    }

    public int getRankPoint() {
        return rankPoint;
    }

}
