package interface_adapter.checkUsage;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the TranslateTextView.
 */
public class CheckUsageViewModel extends ViewModel<CheckUsageState> {
    public CheckUsageViewModel() {
        super("CheckUsageViewModel");
        setState(new CheckUsageState());
    }
}
