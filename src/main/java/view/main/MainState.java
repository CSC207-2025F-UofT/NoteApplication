package view.main;

public class MainState {

    private String username = "";

    public String toString() {
        return "MainState{"
                + "username: "
                + getUsername() + '\''
                + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
