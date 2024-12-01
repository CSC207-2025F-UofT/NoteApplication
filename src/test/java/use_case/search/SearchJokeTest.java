package use_case.search;

import data_access.JokeDataAccessObject;

public class SearchJokeTest {

    public static void main(String[] args) {
        JokeDataAccessObject jokeDataAccessObject = new JokeDataAccessObject();
        String joke = jokeDataAccessObject.searchJoke("bees");
        System.out.println(joke);
    }
}
