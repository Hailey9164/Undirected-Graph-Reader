/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* GraphParser class:   Parses a string representation of a   */ 
/*                      graph into a Graph object             */
/**************************************************************/

public class GraphParser {
    /**************************************************************/
    /* Method: parseGraph                                         */
    /* Purpose: Convert one line of input into a Graph object     */
    /* Parameters:                                                */
    /*   String line – the line containing vertex count and edges */
    /* Returns: Graph – the constructed graph                     */
    /**************************************************************/
    public static Graph parseGraph(String line) {

        // Split by whitespace: first token is number of vertices
        String[] parts = line.trim().split("\\s+"); // Split by whitespace
        int n = Integer.parseInt(parts[0]);         // number of vertices

        Graph g = new Graph(n);     // Create graph with n vertices

        // Remaining tokens are edges of the form "(a,b)"
        for (int i = 1; i < parts.length; i++) {
            String p = parts[i];    // p respresents an edge "(a,b)"

            // Remove parentheses
            p = p.replace("(", "").replace(")", "");

            // Split into a and b
            String[] ab = p.split(",");
            int a = Integer.parseInt(ab[0]);        // holds vertex a
            int b = Integer.parseInt(ab[1]);        // holds vertex b

            g.addEdge(a, b);
        }
        return g;   // Return the constructed graph
    }
}
