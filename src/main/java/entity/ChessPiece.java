package entity;

/**
 * The abstract class of all chess piece.
 */
@SuppressWarnings({"checkstyle:AbstractClassName", "checkstyle:SuppressWarnings"})
public abstract class ChessPiece {
    private final String color;
    private int[] position;

    protected ChessPiece(String color, int xCoordinate, int yCoordinate) {
        this.color = color;
        this.position = new int[2];
        position[0] = xCoordinate;
        position[1] = yCoordinate;
    }

    /**
     * The abstract class for getting the valid moves of a piece.
     * @param <T> type of return value.
     * @return return a list of valid moves.
     */
    public abstract <T> T getValidMoves();

    public String getColor() {
        return color;
    }

    public int[] getPosition() {
        return this.position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}
