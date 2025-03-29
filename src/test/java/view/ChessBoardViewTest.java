package view;

import data_access.ChessDataAccessObject;
import entity.Board;
import entity.Game;
import interface_adapter.ViewManagerModel;
import interface_adapter.move.MoveController;
import interface_adapter.move.MovePresenter;
import interface_adapter.move.MoveViewModel;
import use_case.move.MoveDataAccessInterface;
import use_case.move.MoveInteractor;
import use_case.move.MoveOutputBoundary;

import javax.swing.*;


public class ChessBoardViewTest {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test ChessBoardView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        MoveViewModel TestModel = new MoveViewModel();
        MoveDataAccessInterface moveDataAccessObject = new ChessDataAccessObject();
        MoveViewModel moveViewModel = new MoveViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        MoveOutputBoundary movePresenter = new MovePresenter(moveViewModel, viewManagerModel);
        Board board = new Board();
        Game game = new Game(board, true);
        MoveInteractor TestInteractor = new MoveInteractor(moveDataAccessObject, movePresenter, game);
        MoveController TestController = new MoveController(TestInteractor);

        ChessBoardView TestView = new ChessBoardView(TestModel, TestController);

        frame.add(TestView);
        frame.setVisible(true);

    }
}
