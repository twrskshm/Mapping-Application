package Algorithms;

import DataStructures.Grid;
import DataStructures.Coordinate;
import DataStructures.PathDistance;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Implementation of Dijkstra algorithm.
 * Author: Saksham Tiwari
 * Date: 26 February 2021
 */

public class Dijkstra {
    /**
     * Function that runs Dijkstra algorithm.
     * @param grid Input grid.
     */
    public Dijkstra(final Grid grid) {
        dijkstra(grid, grid.getSource());
    }

    /**
     * Implementation of Dijkstra algorithm.
     * @param grid Input grid.
     * @param source Source coordinate.
     */
    private void dijkstra(final Grid grid, final Coordinate source) {
        PriorityQueue<PathDistance> beingVisited = new PriorityQueue<>();
        PathDistance startingPoint = new PathDistance(source);
        beingVisited.add(startingPoint);

        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(source);

        while (!beingVisited.isEmpty()) {
            PathDistance nodeDistance = beingVisited.remove();
            LinkedList<Coordinate> path = nodeDistance.getPath();
            Coordinate currentNode = path.get(path.size() - 1);
            int currentCost = nodeDistance.getCost();

            if (grid.getValue(currentNode) == 'D') {
                for (Coordinate pathNode: path) {
                    if (grid.getValue(pathNode) == 0) {
                        grid.setValue(pathNode, 'O');
                    }
                }

                return;
            }

            int[][] adder = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] pair: adder) {
                Coordinate adjacentNode = new Coordinate(currentNode.getRow() + pair[0], currentNode.getColumn() + pair[1]);

                if (adjacentNode.withinLimits(grid) && !visited.contains(adjacentNode) && (grid.getValue(adjacentNode) == 0 || grid.getValue(adjacentNode) == 'D')) {
                    PathDistance newPathDistance = new PathDistance(path, currentCost + 1);
                    newPathDistance.addToPath(adjacentNode);
                    beingVisited.add(newPathDistance);

                    visited.add(adjacentNode);
                }
            }
        }
    }
}
