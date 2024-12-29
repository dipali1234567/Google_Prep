package Algorithms.SpanningTree.Kruskal;

// How many spannng tree possible for a graph having N nodes and E edges
// Answer is Ec(N-1)


//Process
//Sort all edges in ascending order
//Pick the smallest edge and add it to the MST
//Check if it forms a cycle
//If it does, then discard it
//If it doesn't, then add it to the MST
//Repeat the process until all nodes are added to the MST

// TC E logE + E logV
// SC V 


// Kruskals algo may work for disconnected graph. It might find MST for some components but not for all.

public class Algo {

}