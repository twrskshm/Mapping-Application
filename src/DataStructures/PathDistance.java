package DataStructures;

import java.util.LinkedList;

/**
 * Data structure that contains path and cost associated with that path.
 * Author: Saksham Tiwari
 * Date: 27 February 2021
 */

public class PathDistance implements Comparable<PathDistance> {
    private final LinkedList<Coordinate> PATH;
    private final int COST;

    /**
     * Function that initializes variables "path" and "cost".
     * @param source Location of the source cell.
     */
    public PathDistance(final Coordinate source) {
        PATH = new LinkedList<>();
        PATH.add(source);
        COST = 0;
    }

    /**
     * Function that initializes variables "path" and "cost".
     * @param path Path recorded until now.
     * @param cost Cost associated with the path.
     */
    public PathDistance(final LinkedList<Coordinate> path, final int cost) {
        PATH = new LinkedList<>(path);
        COST = cost;
    }

    /**
     * Function that returns path stored in the data structure.
     * @return Path stored in the data structure.
     */
    public LinkedList<Coordinate> getPath() {
        return PATH;
    }

    /**
     * Function that adds a coordinate to the path.
     * @param coordinate Coordinate that needs to be added to the path.
     */
    public void addToPath(final Coordinate coordinate) {
        PATH.add(coordinate);
    }

    /**
     * Function that returns cost associated with the path.
     * @return Integer representing cost associated with the path.
     */
    public int getCost() {
        return COST;
    }

    /**
     * Function that compares two PathDistance objects.
     * @param another PathDistance object this objects needs to be compared with.
     * @return 1 if this instance has greater cost, 0 if they both have equal costs and -1 if this instance has lower cost.
     */
    @Override
    public int compareTo(final PathDistance another) {
        if (COST > another.getCost()) {
            return 1;
        } else if (COST == another.getCost()) {
            return 0;
        }

        return -1;
    }
}
