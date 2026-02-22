/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* Graph class: Stores graph in an adjacency list with n vertices */
/**************************************************************/

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int n;     // number of vertices
    private final List<List<Integer>> adj;  // adjacency list

    /**************************************************************/
    /* Method: getNumVertices                                     */
    /* Purpose: Returns the number of vertices in the graph       */
    /* Parameters: None                                           */
    /* Returns: int – number of vertices                          */
    /**************************************************************/
    public int getNumVertices() {
        return n;
    }

    /**************************************************************/
    /* Method: getAdjacencyList                                   */
    /* Purpose: Returns the adjacency list of the graph           */
    /* Parameters: None                                           */
    /* Returns: List<List<Integer>> – adjacency list              */
    /**************************************************************/
    public List<List<Integer>> getAdjacencyList() {
        return adj;
    }

    /**************************************************************/
    /* Method: Graph                                              */
    /* Purpose: Constructor for the Graph class                   */
    /* Parameters:                                                */
    /*   int n – number of vertices in the graph                  */
    /* Returns: None                                              */
    /**************************************************************/
    public Graph(int n) {
        this.n = n;

        // Initialize adjacency list with n+1 empty lists (1-based indexing)
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    /**************************************************************/
    /* Method: addEdge                                            */
    /* Purpose: Adds an undirected edge (u, v) to the graph       */
    /* Parameters:                                                */
    /*   int u – first vertex                                     */
    /*   int v – second vertex                                    */
    /* Returns: None                                              */
    /**************************************************************/
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
