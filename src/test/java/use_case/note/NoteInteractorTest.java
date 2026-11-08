package use_case.note;

import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteInteractorTest {

    @Test
    public void testExecuteRefreshSuccess() {

        NoteDataAccessInterface noteDAO = new NoteDataAccessInterface() {


            @Override
            public String saveNote(User user, String note) {
                return "";
            }


            @Override
            public String loadNote(User user) {
                return "test";
            }
        };



        class OutputRecorder implements NoteOutputBoundary {
            String data;
            String failure;

            @Override
            public void prepareSuccessView(String data) {
                this.data = data;
            }

            @Override
            public void prepareFailView(String error) {
                failure = error;
            }
        }

        OutputRecorder recorder = new OutputRecorder();

        NoteInteractor noteInteractor = new NoteInteractor(noteDAO, recorder);

        noteInteractor.executeRefresh();

        assertEquals("test", recorder.data);
        assertNull(recorder.failure);

    }
}