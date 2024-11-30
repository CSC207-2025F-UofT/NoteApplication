package use_case.favourite.adapter;

import view.FavouriteView;

import javax.swing.*;

public class FavouriteBuilder {
    public static final int HEIGHT = 300;
    public static final int WIDTH = 400;

    public static JFrame build() {

        final JFrame frame = new JFrame();
        final FavouriteViewModel viewModel = new FavouriteViewModel();
        final FavouriteController controller = new FavouriteController();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Search");
        frame.setSize(WIDTH, HEIGHT);

        frame.add(new FavouriteView(viewModel, controller));

        return frame;
    }
}
