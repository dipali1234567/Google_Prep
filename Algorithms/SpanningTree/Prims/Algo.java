package Algorithms.SpanningTree.Prims;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.LinkedList;
//TC V+E logV
//SC V

//Select the minimum edge and add it to the MST
// Now check if edge any check if any other edge is connected to the MST
// If it is, then check if it is minimum
// If it is, then add it to the MST
// Repeat the process until all nodes are added to the MST

// MST is not possible for disconnected graph



public class Algo {

    static int [][]MST;

    public static int prims(int [][]edges, int n){
        int mstCost = 0;
        int mstEdges = 0;
        Map<Integer,List<Pair<Integer,Integer>>> graph = buildGraph(edges);
        int nodes = graph.size();
        int vis[] = new int[nodes];
        MST = new int[nodes][3];
        PriorityQueue<Pair<Integer, Pair<Integer,Integer>>> queue = new PriorityQueue<>((a,b)-> a.getKey().compareTo(b.getKey()));
        queue.add(new Pair<>(0, new Pair(0,-1)));
        while(!queue.isEmpty()){
            Pair<Integer, Pair<Integer,Integer>> edge = queue.poll();
            int cost = edge.getKey();
            int u = edge.getValue().getKey();
            int v = edge.getValue().getValue();
            if(vis[u]==1) continue;
            if(v!=-1){
                MST[mstEdges][0] = v;
                MST[mstEdges][1] = u;
                MST[mstEdges][2] =cost;
                mstCost += cost;
                mstEdges++;
            }
            vis[u] = 1;
            for(Pair<Integer, Integer> neighbor : graph.get(u)){
                int adjV = (int) neighbor.getKey();
                int adjcost =  (int) neighbor.getValue();
                if(vis[adjV]==1) continue;
                queue.add(new Pair<>(adjcost, new Pair<>(adjV,u)));
            }

        }
        return mstCost;

    } 
    
    public static Map<Integer,List<Pair<Integer,Integer>>> buildGraph(int [][]edges){
        Map<Integer, List<Pair<Integer,Integer>>> graph = new HashMap<>();
        for(int [] edge : edges){
            int u = edge[0];
            int v =edge[1];
            int cost = edge[2];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());
            graph.get(u).add(new Pair<>(v, cost));
            graph.get(v).add(new Pair<>(u,cost));
        }
        return graph;
    }

    public static void printMST(int [][]MST){
        for(int [] edge : MST){
            System.out.println(edge[0] + " - " + edge[1] + " : " + edge[2]);
        }
    }

    public static void main(String[] args) {
        int [][]edges = {{0,1,2},{1,2,3},{0,2,1}};
        int [][]edges2 = {{0,1,2},{1,2,3},{0,2,1},{0,3,4},{3,4,5},{4,5,6},{3,5,7},{2,3,8}};
        int n = 3;
        int mstCost = prims(edges, n);
        System.out.println("MST Cost: " + mstCost);
        printMST(MST);
        System.out.println("--------------------------------");
        mstCost = prims(edges2, n);
        System.out.println("MST Cost: " + mstCost);
        printMST(MST);
        System.out.println("--------------------------------");
        int [][]edges3 = {{0,1,2},{1,2,3},{0,2,1},{0,3,4},{3,4,5},{4,5,6},{3,5,7},{2,3,8},{0,4,10}};
        n = 5;
        mstCost = prims(edges3, n);
        System.out.println("MST Cost: " + mstCost);
        printMST(MST);
    }

}

class Pair<K,V>{
    K key;
    V value;
    Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }


}   
