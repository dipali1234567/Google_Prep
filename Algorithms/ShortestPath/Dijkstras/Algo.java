package Algorithms.ShortestPath.Dijkstras;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;

public class Algo {

    //TC V+E logV
    //SC V
    public static Map<Integer,Integer> dijkstras(HashMap<Integer,List<Integer>> graph, int start){
       Map<Integer, Integer> dist = new HashMap<>();
       for(int node: graph.keySet()){
        dist.put(node, Integer.MAX_VALUE);
       }
       
       dist.put(start,0);
       PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
        return a.getValue()-b.getValue();
       });

       pq.add( new Pair<>(start,0));

       while(!pq.isEmpty()){
        Pair<Integer,Integer> currNodeAndDist = pq.poll();
        int node = (int) currNodeAndDist.getKey();
        int nodeDist = (int) currNodeAndDist.getValue();

            for(int neighbor: graph.get(node)){
                int neighborDist = nodeDist + 1;
                if(dist.get(neighbor)>neighborDist){
                    dist.put(neighbor,neighborDist);
                    pq.add(new Pair<>(neighbor,neighborDist));
                }
            }
       }
       return dist;
    }

    public static void main(String[] args) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1,2));
        graph.put(1, Arrays.asList(2,3));
        graph.put(2, Arrays.asList(3,4));
        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList());
        System.out.println(dijkstras(graph, 0));
    }
}

class Pair<K,V>{
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