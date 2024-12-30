package Algorithms.SpanningTree.Kruskal;

import java.util.Arrays;

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

    static int [][]MST;


    public static int kruskal(int [][]edges, int n){
        Arrays.sort(edges, (a,b)->a[2]-b[2]);
        int mstCost = 0;
        int mstEdges = 0;
        MST = new int[n][3];
        int []parent = new int[n];
        int []rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            if(find(u,parent)==find(v,parent)) continue;
            union(u,v,parent,rank);
            mstCost += cost;
            mstEdges++;
            MST[mstEdges][0] = u;
            MST[mstEdges][1] = v;
            MST[mstEdges][2] = cost;
        }
        return mstCost;
    }

    public static int find(int u, int []parent){
        if(parent[u]==u) return u;
        return find(parent[u],parent);
    }

    public static void union(int u, int v, int []parent, int []rank){
        int pu = find(u,parent);
        int pv = find(v,parent);
        if(rank[pu]>rank[pv]) parent[pv] = pu;
        else if(rank[pu]<rank[pv]) parent[pu] = pv;
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }

}