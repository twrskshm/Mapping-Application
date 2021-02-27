package Algorithms;

import DataStructures.Grid;
import DataStructures.Coordinate;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Implementation of breadth first search algorithm.
 * Author: Saksham Tiwari
 * Date: 26 February 2021
 */

public class BreadthFirstSearch {
    /**
     * Function that runs breadth first search algorithm.
     * @param grid Input grid.
     */
    public BreadthFirstSearch(final Grid grid) {
        breadthFirstSearch(grid, grid.getSource());
    }

    /**
     * Implementation of breadth first search algorithm.
     * @param grid Input grid.
     * @param source Source coordinate.
     */
    private void breadthFirstSearch(final Grid grid, final Coordinate source) {
        LinkedList<LinkedList<Coordinate>> beingVisited = new LinkedList<>();
        LinkedList<Coordinate> startingPoint = new LinkedList<>();
        startingPoint.add(source);
        beingVisited.add(startingPoint);

        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(source);

        while (!beingVisited.isEmpty()) {
            LinkedList<Coordinate> path = beingVisited.remove();
            Coordinate currentNode = path.get(path.size() - 1);

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
                    LinkedList<Coordinate> newPath = new LinkedList<>(path);
                    newPath.add(adjacentNode);
                    beingVisited.add(newPath);

                    visited.add(adjacentNode);
                }
            }
        }
    }
}