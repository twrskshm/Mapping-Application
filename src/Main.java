import java.util.Scanner;

import Algorithms.Dijkstra;
import DataStructures.Grid;
import DataStructures.Coordinate;
import Algorithms.BreadthFirstSearch;
import Algorithms.DepthFirstSearch;

/**
 * Starting point for the execution of the program.
 * Author: Saksham Tiwari
 * Date: 27 February 2021
 */

public class Main {
    /**
     * Function that takes in user input and runs the desired algorithm.
     * @param parameters String array containing command line arguments.
     */
    public static void main(final String[] parameters) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter dimensions of the grid along with obstacle density (in percentage): ");

        Grid grid = new Grid(input.nextInt(), input.nextInt(), input.nextInt());
        grid.print();

        System.out.print("Enter the source destination coordinates: ");
        grid.setValue(new Coordinate(input.nextInt(), input.nextInt()), 'S');
        grid.setValue(new Coordinate(input.nextInt(), input.nextInt()), 'D');

        System.out.println("Enter the option of the algorithm you wish to apply:\n"
                + "1. Breadth First Search\n"
                + "2. Depth First Search\n"
                + "3. Dijkstra\n"
                + "4. A*");

        grid.print();

        switch (input.nextInt()) {
            case 1:
                BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(grid);
                break;
            case 2:
                DepthFirstSearch depthFirstSearch = new DepthFirstSearch(grid);
                break;
            case 3:
                Dijkstra dijkstra = new Dijkstra(grid);
                break;
            case 4:
                //AStar aStar = new AStar(grid);
                break;
            default:
                break;
        }

        grid.print();
    }
}
