package interface_adapter.checkUsage;

/**
 * The State for checking Usage.
 */

public class CheckUsageState {

    private String characterCount = "";
    private String characterLimit = "";
    private String error;

    public String getCharacterLimit() {
        return characterLimit;
    }

    public void setCharacterLimit(String characterLimit) {
        this.characterLimit = characterLimit;
    }

    public String getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(String characterCount) {
        this.characterCount = characterCount;
    }

    public void setError(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }
}
