package DataStructures;

import java.util.Random;

/**
 * Data structure representing the grid.
 * Author: Saksham Tiwari
 * Date: 26 February 2021
 */

public class Grid {
    private final char[][] GRID;
    private Coordinate source;

    /**
     * Function that initializes the two dimensional array.
     * @param rows Total number of rows in the grid.
     * @param columns Total number of columns in the grid.
     * @param obstacleDensity Percentage of cells containing obstacles.
     */
    public Grid(final int rows, final int columns, final double obstacleDensity) {
        GRID = new char[rows][columns];
        addObstacles(obstacleDensity);
    }

    /**
     * Function that randomly adds obstacles to the grid.
     * @param obstacleDensity Percentage of cells containing obstacles.
     */
    private void addObstacles(final double obstacleDensity) {
        int counter = (int) ((obstacleDensity / 100) * (GRID.length * GRID[0].length));
        Random random = new Random();

        while (counter-- > 0) {
            int row = random.nextInt(GRID.length);
            int column = random.nextInt(GRID[0].length);
            GRID[row][column] = 'X';
        }
    }

    /**
     * Function that returns source coordinate.
     * @return Source coordinate.
     */
    public Coordinate getSource() {
        return source;
    }

    /**
     * Function that returns number of rows in the grid.
     * @return Integer representing number of rows in the grid.
     */
    int totalRows() {
        return GRID.length;
    }

    /**
     * Function that returns number of column in the grid.
     * @return Integer representing number of columns in the grid.
     */
    int totalColumns() {
        return GRID[0].length;
    }

    /**
     * Function that returns character value stored in the cell represented by the coordinate.
     * @param coordinate Coordinate representing cell in the grid.
     * @return Character value stored in the cell represented by the coordinate.
     */
    public char getValue(final Coordinate coordinate) {
        return GRID[coordinate.getRow()][coordinate.getColumn()];
    }

    /**
     * Function that changes character value stored in the cell represented by the coordinate.
     * @param coordinate Coordinate representing cell in the grid.
     * @param value New character value.
     */
    public void setValue(final Coordinate coordinate, final char value) {
        if (value == 'S') {
            source = coordinate;
        }

        GRID[coordinate.getRow()][coordinate.getColumn()] = value;
    }

    /**
     * Function that prints the grid.
     */
    public void print() {
        for (char[] row: GRID) {
            for (char character: row) {
                System.out.print(character + "\t|\t");
            }

            System.out.println();
        }
    }
}
