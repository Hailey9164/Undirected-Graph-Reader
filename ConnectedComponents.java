/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* ConnectedComponents class: Finds connected components in   */
/*                            an undirected graph             */
/**************************************************************/

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {

    /**************************************************************/
    /* Method: findComponents                                     */
    /* Purpose: Find all connected components in an undirected    */
    /*          graph                                             */
    /* Parameters:                                                */
    /*   Graph g – the graph to analyze                           */
    /* Returns: List<List<Integer>> – list of components, each    */
    /*          component is a list of vertices in that component */
    /**************************************************************/
    public static List<List<Integer>> findComponents(Graph g) {
        // used to track visited vertices
        boolean[] visited = new boolean[g.getNumVertices() + 1];

        // list to hold all connected components
        List<List<Integer>> comps = new ArrayList<>();          

        // Try starting DFS from every vertex
        for (int v = 1; v <= g.getNumVertices(); v++) {
            if (!visited[v]) {  // If vertex not visited, it's a new component
                List<Integer> comp = new ArrayList<>();

                // Collect all vertices reachable from v using DFS
                dfs(g, v, visited, comp);
                comps.add(comp);
            }
        }
        return comps;
    }

    /**************************************************************/
    /* Method: dfs                                                */
    /* Purpose: Perform DFS traversal and collect vertices in a   */
    /*          component                                         */
    /* Parameters:                                                */
    /*   Graph g – the graph being traversed                      */
    /*   int v – the current vertex being visited                 */
    /*   boolean[] visited – array tracking visited vertices      */
    /*   List<Integer> comp – list of vertices in current         */
    /*                        component                           */
    /* Returns: void                                              */
    /**************************************************************/
    private static void dfs(Graph g, int v, boolean[] visited, 
                            List<Integer> comp) {
        // Mark current vertex as visited and add to current component
        visited[v] = true;
        comp.add(v);

        // Visit all neighbors
        for (int nbr : g.getAdjacencyList().get(v)) {
            if (!visited[nbr]) {
                dfs(g, nbr, visited, comp);
            }
        }
    }
}
