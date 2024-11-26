package use_case.search;

public interface SearchInputBoundary {
    /**
     * Search jokes by keyword.
     * @param keyword the keyword that wants to be searched.
     */
    void executeSearch(String keyword);
}
