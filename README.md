**************************************************************
Hailey Campbell                                          
Login ID: 018392504                                      
CS 3310, Spring 2026                                   
Programming Assignment 1                                  
Description: This program reads multiple undirected graphs
from an input file, prints the connected components of each
graph, and detects one cycle if it exists.
**************************************************************

**************************************************************
1. FILES INCLUDED
**************************************************************
Prog1.java
    - Main driver class. Prompts the user for an input filename,
      reads each graph from the file, and prints the connected
      components and cycle information.

Graph.java
    - Stores an undirected graph using an adjacency list.
      Provides methods to add edges and retrieve graph data.

GraphParser.java
    - Contains a static method to convert one line of input
      into a Graph object.

ConnectedComponents.java
    - Uses depth-first search (DFS) to compute all connected
      components of a graph.

CycleDetector.java
    - Uses DFS with an explicit stack to detect a cycle in an
      undirected graph and reconstruct one such cycle.

README
    - This file.


2. COMPILATION INSTRUCTIONS

All .java files must be in the same directory.

To compile the program, open a terminal in the directory
containing the files and type:

    javac *.java

This will compile all classes and produce the corresponding
.class files.


3. EXECUTION INSTRUCTIONS

After compiling, run the program with:

    java Prog1

The program will prompt:

    Enter input filename:

Type the name of your input file, for example:

    SampleInput.txt

The program will then read each line of the file as a separate
graph and print:

    - The number of connected components
    - The vertices in each component
    - A cycle if one exists, or a message that the graph is
      acyclic


4. INPUT FILE FORMAT

Each line of the input file represents one graph.

Format:

    n (a,b) (c,d) (e,f) ...

Where:
    n      = number of vertices in the graph
    (a,b)  = undirected edge between vertices a and b

Example:

    7 (1,2) (3,4) (3,5) (4,5)
    8 (1,2) (2,3) (3,2) (1,4) (1,5) (6,2) (6,7) (8,2)
    12 (1,3) (2,5) (3,4) (3,5) (5,6) (6,7) (8,1) (1,8)
       (10,12) (9,12) (11,12) (10,9) (11,9)


5. OUTPUT FORMAT

The program prints results in the following format:

    Graph1:
    Two connected components: {1 2} {3 4 5}
    Cycle detected: 3 - 4 - 5 - 3

    Graph2:
    One connected component: {1 2 3 4}
    The graph is acyclic.


6. DESIGN NOTES

- Each class is placed in its own file, as required.
- All non-main class variables are private and accessed through
  getter methods.
- All methods include full header comments describing purpose,
  parameters, and return values.
- Meaningful variable names are used throughout.
- DFS is used for both connected component detection and cycle
  detection.
- Cycle detection uses an explicit stack and parent pointers to
  reconstruct one cycle.


7. HOW TO MODIFY OR EXTEND

To add new graph algorithms, create a new class file and place
the methods there. Keep all data-related operations inside the
Graph class and follow the same style guidelines used in this
assignment.
