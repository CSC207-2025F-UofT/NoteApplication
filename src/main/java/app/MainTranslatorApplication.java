package app;

import data_access.DBTranslateTextDataAccessObject;
import use_case.translateText.TranslateTextDataAccessInterface;

/**
 * An application where we can view and add to a note stored by a user.
 * <p>
 * This is a minimal  example of using the password-protected user API from lab 5,
 * but demonstrating the endpoint allowing you to store an arbitrary JSON object.
 * This functionality could be used in any project where your team wants to persist
 * data which is then accessible across devices.</p>
 * <p>The code is intentionally somewhat incomplete to leave work to be done if your
 * team were to choose to work on a project which would require similar functionality.
 * For example, we have intentionally not created a full "Note" entity here, but
 * rather just represented a note as a string.
 * </p>
 * The ViewManager code has also been removed, since this minimal program only requires a single
 * view. Your team may wish to bring back the ViewManager or make your own implementation of supporting
 * switching between views depending on your project.
 */
public class MainTranslatorApplication {

    /**
     * The main entry point of the application.
     * The program will show you the input and output language drop-down box and will allow you
     * to type text in a textbox. You can then click Translate Text and your text will be translated.
     * This uses the DeepL API.
     * @param args commandline arguments are ignored
     */
    public static void main(String[] args) {

        // create the data access and inject it into our builder!
        final TranslateTextDataAccessInterface translateTextDataAccess = new DBTranslateTextDataAccessObject();

        final TranslateTextAppBuilder builder = new TranslateTextAppBuilder();
        builder.addTranslateTextDAO(translateTextDataAccess)
                .addTranslateTextView()
                .addTranslateTextUseCase().build().setVisible(true);
    }
}
