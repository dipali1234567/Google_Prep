package Algorithms.ShortestPath;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;



public class ShortestPathinUndirectedGraphUnitWeights {
    
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int start = 0;
        int end = 4;

        HashMap<Integer,List<Integer>> graph = buildGraph(edges);
        System.out.println(shortestPath(graph, start, end));
    }   

    public static HashMap<Integer,List<Integer>> buildGraph(int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int [] edge :edges){
            int node1 = edge[0];
            int node2 = edge[1];  
            graph.putIfAbsent(node1, new ArrayList<>());
            graph.putIfAbsent(node2, new ArrayList<>());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return graph;
    }

    public static int shortestPath(HashMap<Integer,List<Integer>> graph, int start, int end) {
        Map<Integer,Integer> dist = new HashMap<Integer,Integer>();
        for(int node: graph.keySet()){
            dist.put(node, Integer.MAX_VALUE);
        }
        Queue<Pair<Integer,Integer>> queue = new LinkedList<Pair<Integer,Integer>>();
        queue.add(new Pair<>(start,0));
        while(!queue.isEmpty()){
            Pair<Integer,Integer> node = queue.poll();
            int curreNode = (int) node.getKey();
            int currentDist = (int) node.getValue();
            for(int neighbor: graph.get(curreNode)){              
                int newDist = currentDist + 1;
                if(dist.get(neighbor)>newDist){
                    dist.put(neighbor, newDist);
                    queue.add(new Pair<>(neighbor,newDist));
                }
            }
        }
        return dist.get(end);
    }

}

class Pair<K,V> {
    K key;
    V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }
}