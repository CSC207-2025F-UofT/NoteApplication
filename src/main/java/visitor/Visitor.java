package visitor;

import data_access.FileDataAccessObject;
import use_case.fav_search.FavSearchOutputData;
import use_case.generate.GenerateOutputData;
import use_case.search.SearchOutputData;
import view.joke_view.JokeFrameBuilder;

import javax.swing.*;

public class Visitor implements JokeVisitor{

    private final FileDataAccessObject fileDataAccessObject;

    public Visitor(FileDataAccessObject dataAccess) {
        this.fileDataAccessObject = dataAccess;
    }


    public void visit(GenerateOutputData generateOutputData) {

        JokeFrameBuilder frameBuilder = new JokeFrameBuilder();

        final JFrame frame = frameBuilder
                .addJokeView()
                .setJokeContent(generateOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase(fileDataAccessObject)
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void visit(SearchOutputData searchOutputData) {
        JokeFrameBuilder frameBuilder = new JokeFrameBuilder();

        final JFrame frame = frameBuilder
                .addJokeView()
                .setJokeContent(searchOutputData.getJokeContent())
                .addExplanationUseCase()
                .addAddToFavUseCase(fileDataAccessObject)
                .build();

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void visit(FavSearchOutputData favSearchOutputData) {
        JokeFrameBuilder frameBuilder = new JokeFrameBuilder();

        final JFrame frame = frameBuilder
                .addJokeView()
                .setJokeContent( favSearchOutputData.getJokeContent())
                .setExplanation(favSearchOutputData.getExplanation())
                .addExplanationUseCase()
                .addAddToFavUseCase(fileDataAccessObject)
                .build();

        frame.pack();
        frame.setVisible(true);
    }


}
