package use_case.search.adapter;

import view.search_view.SearchView;
import view.search_view.SearchViewModel;

import javax.swing.*;

public class SearchBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;

    public static JFrame build() {

        final JFrame frame = new JFrame();
        final SearchViewModel viewModel = new SearchViewModel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Search");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(new SearchView(viewModel));

        return frame;

    }
}
