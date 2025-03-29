package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.move.MoveController;
import interface_adapter.move.MoveViewModel;

/**
 * The view of actual chess game.
 */
public class ChessBoardView extends JPanel implements ActionListener, PropertyChangeListener {

    private final int numRow = 8;
    private final int numCol = 8;
    private final int fontSize = 36;
    private final String viewName = "Chess Board";
    private final MoveViewModel moveViewModel;
    private MoveController moveController;

    public ChessBoardView(MoveViewModel moveViewModel, MoveController moveController) {
        this.moveViewModel = moveViewModel;
        this.moveController = moveController;
        moveViewModel.addPropertyChangeListener(this);

        final JLabel titleLabel = new JLabel(MoveViewModel.TITLE_LABEL);

        this.setLayout(new GridLayout(numRow, numCol));

        // Add buttons to the frame in a chessboard pattern
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                final JButton button = new JButton();
                final String stringRow = String.valueOf(Math.abs(row - 7));
                final String stringCol = String.valueOf(col);
                button.setActionCommand(stringCol + "," + stringRow);

                // Set background color to alternate between black and white
                if ((row + col) % 2 == 0) {
                    button.setBackground(Color.GRAY);
                } else {
                    button.setBackground(Color.orange);
                }

                // Add pieces to the board
                final String[][] pieces = moveViewModel.getPieces();
                if (pieces[row][col] != null) {
                    // Set highlighted background color associate with valid moves.
                    if (pieces[row][col].equals("Valid")) {
                        button.setBackground(Color.YELLOW);
                    } else {
                        button.setText(pieces[row][col]);
                        button.setFont(new Font("Serif", Font.BOLD, fontSize));
                    }
                }

                button.setFocusPainted(true);
                button.addActionListener(this);
                this.add(button);

            }
        }

    }

    public void setMoveController(MoveController moveController) {
        this.moveController = moveController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        // Split the string at the comma
        String[] parts = e.getActionCommand().split(",");
        // Convert the parts to integers
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        moveController.onClick(x, y);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("pieces".equals(evt.getPropertyName())) {
            // Retrieve the updated pieces array
            String[][] updatedPieces = (String[][]) evt.getNewValue();

            // Update the board
            for (int row = 0; row < numRow; row++) {
                for (int col = 0; col < numCol; col++) {
                    // Find the button at this position
                    JButton button = (JButton) this.getComponent(row * numCol + col);

                    // Reset button background color
                    if ((row + col) % 2 == 0) {
                        button.setBackground(Color.GRAY);
                    } else {
                        button.setBackground(Color.orange);
                    }

                    // Update the button text and background based on the new pieces
                    if (updatedPieces[row][col] != null) {
                        if ("Valid".equals(updatedPieces[row][col])) {
                            button.setBackground(Color.YELLOW); // Highlight valid move
                            button.setText(""); // No text for "Valid" markers
                        } else {
                            button.setText(updatedPieces[row][col]); // Set piece text
                            button.setFont(new Font("Serif", Font.BOLD, fontSize));
                        }
                    } else {
                        button.setText(""); // Clear text if no piece
                    }
                }
            }

            // Refresh the UI
            this.revalidate();
            this.repaint();
        }
    }


}