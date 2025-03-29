package entity;

import org.json.JSONObject;

/**
 * The chess board entity.
 */
public class Board {
    private ChessPiece[][] grid;

    @SuppressWarnings("checkstyle:MagicNumber")
    public Board() {
        final ChessPiece[][] chessGrid = new ChessPiece[8][8];

        final String white = "White";
        chessGrid[0][0] = new Rook(white, 0, 0);
        chessGrid[0][1] = new Knight(white, 0, 1);
        chessGrid[0][2] = new Bishop(white, 0, 2);
        chessGrid[0][3] = new Queen(white, 0, 3);
        chessGrid[0][4] = new King(white, 0, 4);
        chessGrid[0][5] = new Bishop(white, 0, 5);
        chessGrid[0][6] = new Knight(white, 0, 6);
        chessGrid[0][7] = new Rook(white, 0, 7);
        for (int i = 0; i < 8; i++) {
            chessGrid[1][i] = new Pawn(white, 1, i);
        }

        final String black = "Black";
        chessGrid[7][0] = new Rook(black, 7, 0);
        chessGrid[7][1] = new Knight(black, 7, 1);
        chessGrid[7][2] = new Bishop(black, 7, 2);
        chessGrid[7][3] = new Queen(black, 7, 3);
        chessGrid[7][4] = new King(black, 7, 4);
        chessGrid[7][5] = new Bishop(black, 7, 5);
        chessGrid[7][6] = new Knight(black, 7, 6);
        chessGrid[7][7] = new Rook(black, 7, 7);
        for (int i = 0; i < 8; i++) {
            chessGrid[6][i] = new Pawn(black, 6, i);
        }

        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                chessGrid[row][col] = null;
            }
        }
        this.grid = chessGrid;
    }

    public Board(JSONObject boardFile) {
        // will call some other method to read the file, placeholder for now.
    }

    /**
     * Returns if a tile is empty.
     *
     * @param position position of piece
     * @return bool
     */
    public boolean isEmpty(int[] position) {
        return grid[position[0]][position[1]] == null;
    }

    /**
     * Returns the chess piece at a given tile.
     *
     * @param position position of piece
     * @return Chesspiece
     */
    public ChessPiece getPiece(int[] position) {
        return grid[position[0]][position[1]];
    }

    /**
     * Moves a piece to the specified position on the board.
     *
     * @param position The new position (x, y) for the piece.
     * @param piece The piece to move.
     */
    public void moveToLocation(int[] position, ChessPiece piece) {
        grid[piece.getPosition()[0]][piece.getPosition()[1]] = null;
        piece.setPosition(position);
        grid[position[0]][position[1]] = piece;
    }

    /**
     * Checks if the game is over by determining if either king is missing.
     *
     * @return "None" if both kings are present, "Black" if the white king is missing,
     *         "White" if the black king is missing.
     */
    public String over() {
        boolean whiteKingPresent = false;
        boolean blackKingPresent = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grid[i][j] instanceof King) {
                    if (grid[i][j].getColor().equals("White")) {
                        whiteKingPresent = true;
                    }
                    else {
                        blackKingPresent = true;
                    }
                }
            }
        }
        if (whiteKingPresent && blackKingPresent) {
            return "None";
        }
        else if (whiteKingPresent) {
            return "Black";
        }
        else {
            return "White";
        }
    }
}
