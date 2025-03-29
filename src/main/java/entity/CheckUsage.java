package entity;

import use_case.checkUsage.CheckUsageDataAccessInterface;
import use_case.translateText.DataAccessException;

/**
 * The representation of a Text Translator.
 */
public class CheckUsage {

    private final CheckUsageDataAccessInterface dataAccessObject;
    private String characterCount;
    private String characterLimit;

    public CheckUsage(CheckUsageDataAccessInterface dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    public void setCharacterLimit(String characterLimit) {
        this.characterLimit = characterLimit;
    }

    public void setCharacterCount(String characterCount) {
        this.characterCount = characterCount;
    }

    public String getCharacterLimit() {
        return characterLimit;
    }

    public String getCharacterCount() {
        return characterCount;
    }

    /**
     * Translates the input text in the specified output language (input language could be "Detect Language")
     * and updates the output text and input text (if detecting language).
     * @throws DataAccessException if the text could not be translated for any reason
     */
    public void getUsage() throws DataAccessException {
        characterCount = dataAccessObject.getCharacterCount();
        characterLimit = dataAccessObject.getCharacterLimit();
    }

}
