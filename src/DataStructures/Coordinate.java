package DataStructures;

import java.util.Objects;

/**
 * Data structure representing a point on the grid.
 * Author: Saksham Tiwari
 * Date: 26 February 2021
 */

public class Coordinate {
    private final int ROW;
    private final int COLUMN;

    /**
     * Function that initializes variables "ROW" and "COLUMN".
     * @param row X-coordinate of the point on the grid.
     * @param column Y-coordinate of the point on the grid.
     */
    public Coordinate(final int row, final int column) {
        ROW = row;
        COLUMN = column;
    }

    /**
     * Function that returns x-coordinate of the point.
     * @return Integer representing x-coordinate of the point.
     */
    public int getRow() {
        return ROW;
    }

    /**
     * Function that returns y-coordinate of the point.
     * @return Integer representing y-coordinate of the point.
     */
    public int getColumn() {
        return COLUMN;
    }

    /**
     * Function that checks if the point lies inside the grid.
     * @param grid 2-d character array representing the grid.
     * @return True if the point lies inside the grid, false otherwise.
     */
    public boolean withinLimits(final Grid grid) {
        return ROW >= 0 && ROW < grid.totalRows() && COLUMN >= 0 && COLUMN < grid.totalColumns();
    }

    /**
     * Function that checks if two instances of this class are equal or not.
     * @param object Another instance of this class.
     * @return True if the objects are equal, false if not.
     */
    @Override
    public boolean equals(final Object object) {
        if (object instanceof Coordinate) {
            Coordinate coordinate = (Coordinate) object;
            return ROW == coordinate.getRow() && COLUMN == coordinate.getColumn();
        }

        return false;
    }

    /**
     * Function the calculates hash value of the instance of this class.
     * @return Integer representing hash value of the instance of this class.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ROW, COLUMN);
    }
}
