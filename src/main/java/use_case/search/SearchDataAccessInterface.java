package use_case.search;

public interface SearchDataAccessInterface {
    /**
     * Search jokes with the keyword and show them.
     * @param keyword the keyword that want to be searched.
     * @return return a String of joke that we want
     */
    String searchJoke(String keyword);
}
