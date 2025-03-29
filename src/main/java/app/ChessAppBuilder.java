package app;

import data_access.ChessDataAccessObject;
import entity.Board;
import entity.Game;
import interface_adapter.ViewManagerModel;
import interface_adapter.move.MoveController;
import interface_adapter.move.MovePresenter;
import interface_adapter.move.MoveViewModel;
import use_case.move.MoveInteractor;
import use_case.move.MoveOutputBoundary;
import view.ChessBoardView;

/**
 * Builder for the Chess Application.
 */
public class ChessAppBuilder {
    public static final int HEIGHT = 800;
    public static final int WIDTH = 800;
    // TODO change to ChessDataAccessInterface once implemented
    private ChessDataAccessObject chessDataAccessObject;
    private MoveViewModel moveViewModel = new MoveViewModel();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private ChessBoardView chessBoardView;
    private MoveInteractor moveInteractor;

    /**
     * Set the ChessDAO to be used in this application.
     * @param chessDataAccess the DAO to use
     * @return this builder
     */
    public ChessAppBuilder addChessDAO(ChessDataAccessObject chessDataAccess) {
        chessDataAccessObject = chessDataAccess;
        return this;
    }

    /**
     * Creates the objects for the Move Use Case and connects the ChessBoardView to Move controller.
     * @return this builder
     */
    public ChessAppBuilder addMoveUseCase() {
        final MoveOutputBoundary moveOutPutBoundary = new MovePresenter(moveViewModel, viewManagerModel);
        Board board = new Board();
        Game game = new Game(board, true);
        moveInteractor = new MoveInteractor(
                chessDataAccessObject, moveOutPutBoundary, game);

        final MoveController moveController = new MoveController(moveInteractor);
        chessBoardView.setMoveController(moveController);
        return this;
    }

    /**
     * Creates the ChessBoardView and underlying MoveViewModel.
     * @return this builder
     */
    public ChessAppBuilder addMoveView() {
        moveViewModel = new MoveViewModel();
        final MoveController moveController = new MoveController(moveInteractor);
        chessBoardView = new ChessBoardView(moveViewModel, moveController);
        return this;
    }

    public ChessBoardView buildChessBoardView() {
        return chessBoardView;
    }
}
