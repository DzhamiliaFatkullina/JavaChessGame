package src.pieces;

/**
 * Class Coordinate for a 2D space with constructor, getters and setters for x and y.
 * @author Dzhamilia Fatkullina
 */

public class Coordinate {
    private int x;
    private int y;

    /**
     * Constructor for Coordinate
     * @param x - int value for x coordinate on a 2D space
     * @param y - int value for y coordinate on a 2D space
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
