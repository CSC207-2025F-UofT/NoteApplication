package view.favourite_view;

import view.ViewModel;

public class FavouriteViewModel extends ViewModel<FavouriteState> {

    public static final String TITLE_LABEL = "Favourite";
    public static final String KEYWORD_LABEL = "Enter keyword to find a joke:";
    public static final String SEARCH_BUTTOM_LABEL = "search";
    public static final String FUNNIEST_BUTTOM_LABEL = "funniest";
    public static final String CANCEL_BUTTOM_LABEL = "cancel";

    public FavouriteViewModel() {
        super(TITLE_LABEL);
        setState(new FavouriteState());
    }

}
