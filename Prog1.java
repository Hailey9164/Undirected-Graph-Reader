/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: main driver for reading graphs from a file,   */
/* computing connected components and cycles, and printing    */
/* formatted results.                                         */
/**************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**************************************************************/
/* Class: Prog1                                               */
/* Purpose: Main driver class for the program. Prompts the    */
/* user for an input filename, reads each line as a graph,    */
/* computes connected components and detects a cycle, then    */
/* prints the results.                                        */
/**************************************************************/
public class Prog1 {
    /**********************************************************/
    /* Method: main                                           */
    /* Purpose: Entry point of the program. Prompts the user  */
    /* for an input filename, reads graphs from the file,     */
    /* and prints connected components and cycle information. */
    /* Parameters:                                            */
    /*   String[] args – command line arguments (unused).     */
    /* Returns: None                                          */
    /**********************************************************/  
    public static void main(String[] args) throws FileNotFoundException {
         
        // Prompt user for input filename
        try ( // Scanner for user input
                Scanner keyboardScanner = new Scanner(System.in)) {
            // Prompt user for input filename
            System.out.print("Enter input filename: ");
            String filename = keyboardScanner.nextLine().trim();
                
            // Scanner for reading the input file
            File inputFile = new File(filename);
            try (Scanner fileScanner = new Scanner(inputFile)) {
            int graphNum = 1;   // To keep track of graph numbers in output
                    
            // Read each line as a separate graph, compute connected components
            // and detect cycle
            while (fileScanner.hasNextLine()) {
                // Read the next line and parse it into a Graph object
                    String line = fileScanner.nextLine().trim();
                    if (line.isEmpty()) continue;
                        
                    // Parse line into Graph
                    Graph g = GraphParser.parseGraph(line); 
                        
                    // Compute connected components and detect cycle
                    List<List<Integer>> comps = 
                                        ConnectedComponents.findComponents(g);
                    List<Integer> cycle = CycleDetector.findCycle(g);
                        
                    // Print results for this graph
                    printGraphResult(graphNum, comps, cycle);
                    graphNum++;
                }
            } 
        }
    }

    /**************************************************************/
    /* Method: printGraphResult                                   */
    /* Purpose: Prints the results for a single graph             */
    /* Parameters:                                                */
    /*   int graphNum – the number of the current graph           */
    /*   List<List<Integer>> comps – list of connected components */
    /*   List<Integer> cycle – list of vertices in a cycle        */
    /* Returns: None                                              */
    /**************************************************************/
    private static void printGraphResult(int graphNum, 
                                        List<List<Integer>> comps, 
                                        List<Integer> cycle) {
        System.out.println("\nGraph " + graphNum + ":");

        // Print connected components
        System.out.print(comps.size() + " connected components: ");

        // Print each component as a set of vertices
        for (List<Integer> comp : comps) {
            System.out.print("{ ");
        for (int v : comp) System.out.print(v + " ");
            System.out.print("} ");
        }
        System.out.println();

        // Print cycle detection result
        if (cycle == null) {
            System.out.println("The graph is acyclic.");
        } else {
            System.out.print("Cycle detected: ");
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print(cycle.get(i));
                if (i < cycle.size() - 1) System.out.print(" - ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
