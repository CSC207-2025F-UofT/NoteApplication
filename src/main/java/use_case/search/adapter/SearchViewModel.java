package use_case.search.adapter;

import view.ViewModel;

public class SearchViewModel extends ViewModel<SearchState> {

    public static final String TITLE_LABEL = "Search";
    public static final String SEARCH_LABEL = "Enter keyword to find a joke:";
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public SearchViewModel() {
        super("Search");
        setState(new SearchState());
    }
}
