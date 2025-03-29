package use_case.checkUsage;

/**
 * Output Data for the CheckUsage Use Case.
 */
public class CheckUsageOutputData {

    private final String characterCount;
    private final String characterLimit;

    public CheckUsageOutputData(String characterCount, String characterLimit) {
        this.characterCount = characterCount;
        this.characterLimit = characterLimit;
    }

    public String getCharacterCount() {
        return characterCount;
    }

    public String getCharacterLimit() {
        return characterLimit;
    }
}
