/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 1                                   */
/* CycleDetector class: Detects cycles in an undirected graph */
/**************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CycleDetector {

    /**************************************************************/
    /* Method: findCycle                                          */
    /* Purpose: Find a cycle in an undirected graph               */
    /* Parameters:                                                */
    /*   Graph g – the graph to analyze                           */
    /* Returns: List<Integer> – list of vertices forming a cycle, */
    /*                          or null if none exists            */
    /**************************************************************/
    public static List<Integer> findCycle(Graph g) {
        // used to track visited vertices
        boolean[] visited = new boolean[g.getNumVertices() + 1];   

        // used to track parent of each vertex in DFS
        int[] parent = new int[g.getNumVertices() + 1];            

        // Try DFS from every unvisited vertex
        for (int v = 1; v <= g.getNumVertices(); v++) {
            if (!visited[v]) {
                List<Integer> cycle = dfsCycle(g, v, visited, parent);
                if (cycle != null) return cycle;
            }
        }
        return null;
    }

    /**************************************************************/
    /* Method: dfsCycle                                           */
    /* Purpose: Perform DFS traversal to detect a cycle in  graph */
    /* Parameters:                                                */
    /*   Graph g – the graph being traversed                      */
    /*   int start – the starting vertex for DFS                  */
    /*   boolean[] visited – array tracking visited vertices      */
    /*   int[] parent – array tracking parent of each vertex      */
    /* Returns: List<Integer> – list of vertices forming a cycle, */
    /*                          or null if none exists            */
    /**************************************************************/
    private static List<Integer> dfsCycle(Graph g, int start,
                                          boolean[] visited, 
                                          int[] parent) {
        Stack<Integer> stack = new Stack<>();   // Stack for DFS
        stack.push(start);
        parent[start] = -1; // root has no parent

        while (!stack.isEmpty()) {
            int v = stack.pop();        // Get next vertex to process
            visited[v] = true;

            for (int nbr : g.getAdjacencyList().get(v)) {

                // If neighbor not visited, continue DFS
                if (!visited[nbr]) {
                    parent[nbr] = v;
                    stack.push(nbr);
                }

                // If visited and not the parent, we found a cycle
                else if (nbr != parent[v]) {
                    return buildCycle(v, nbr, parent);
                }
            }
        }
        return null;
    }

    /**************************************************************/
    /* Method: buildCycle                                         */
    /* Purpose: Reconstructs the cycle path by walking parent pointers */
    /* Parameters:                                                 */
    /*   int v – the vertex where the cycle was detected          */
    /*   int nbr – the neighbor that caused the cycle             */
    /*   int[] parent – array tracking parent of each vertex      */
    /* Returns: List<Integer> – list of vertices forming a cycle  */
    /**************************************************************/
    private static List<Integer> buildCycle(int v, int nbr, int[] parent) {
        List<Integer> cycle = new ArrayList<>();

        // Start from the neighbor and walk back to v
        cycle.add(nbr);

        int cur = v;        //use cur to walk back from v to nbr

        // Walk back until we return to the neighbor, which closes the cycle
        while (cur != nbr) {
            cycle.add(cur);
            cur = parent[cur];
        }

        // Close the cycle by repeating the start vertex
        cycle.add(nbr);

        // Reverse so the cycle prints in correct order
        Collections.reverse(cycle);
        return cycle;
    }
}
