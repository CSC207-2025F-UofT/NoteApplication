package app;

import interface_adapter.note.NoteController;
import interface_adapter.note.NotePresenter;
import interface_adapter.note.NoteViewModel;
import interface_adapter.translateText.TranslateTextViewModel;
import use_case.note.NoteDataAccessInterface;
import use_case.note.NoteInteractor;
import use_case.note.NoteOutputBoundary;
import use_case.translateText.TranslateTextDataAccessInterface;
import use_case.translateText.TranslateTextInteractor;
import view.NoteView;
import view.TranslateTextView;

import javax.swing.*;

/**
 * Builder for the Note Application.
 */
public class TranslateTextAppBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;
    private TranslateTextDataAccessInterface translatetextDAO;
    private TranslateTextViewModel noteViewModel = new TranslateTextViewModel();
    private TranslateTextView noteView;
    private TranslateTextInteractor noteInteractor;

    /**
     * Sets the NoteDAO to be used in this application.
     * @param translatetextDataAccess the DAO to use
     * @return this builder
     */
    public TranslateTextAppBuilder addtranslatetextDAO(TranslateTextDataAccessInterface translatetextDataAccess) {
        translatetextDAO = translatetextDataAccess;
        return this;
    }

    /**
     * Creates the objects for the Note Use Case and connects the NoteView to its
     * controller.
     * <p>This method must be called after addNoteView!</p>
     * @return this builder
     * @throws RuntimeException if this method is called before addNoteView
     */
    public TranslateTextAppBuilder addNoteUseCase() {
        final NoteOutputBoundary noteOutputBoundary = new NotePresenter(noteViewModel);
        noteInteractor = new NoteInteractor(
                noteDAO, noteOutputBoundary);

        final NoteController controller = new NoteController(noteInteractor);
        if (noteView == null) {
            throw new RuntimeException("addNoteView must be called before addNoteUseCase");
        }
        noteView.setNoteController(controller);
        return this;
    }

    /**
     * Creates the NoteView and underlying NoteViewModel.
     * @return this builder
     */
    public TranslateTextAppBuilder addNoteView() {
        noteViewModel = new NoteViewModel();
        noteView = new NoteView(noteViewModel);
        return this;
    }

    /**
     * Builds the application.
     * @return the JFrame for the application
     */
    public JFrame build() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Note Application");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(noteView);

        // refresh so that the note will be visible when we start the program
        noteInteractor.executeRefresh();

        return frame;

    }
}
