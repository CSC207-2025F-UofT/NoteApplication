package use_case.favourite;

import entity.User;

public interface FavouriteUserDataAccessInterface {
    String getCurrentUsername();

    User get(String username);
}
