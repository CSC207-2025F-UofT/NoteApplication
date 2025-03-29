package use_case.favourite;

import entity.User;

public class FavouriteInputData {
    private final User user;

    public FavouriteInputData(User user) {
        this.user = user;
    }

    User getUser() {
        return user;
    }
}
