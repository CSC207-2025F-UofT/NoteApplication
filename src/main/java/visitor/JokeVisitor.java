package visitor;

import data_access.FileDataAccessObject;
import use_case.generate.GenerateOutputData;
import use_case.search.SearchOutputData;

import javax.swing.*;

public interface JokeVisitor {
    void visit(GenerateOutputData generateOutputData);

    void visit(SearchOutputData searchOutputData);

    void visit(FavSearchOutputData favSearchOutputData);
}
