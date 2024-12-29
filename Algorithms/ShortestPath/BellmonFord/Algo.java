package Algorithms.ShortestPath.BellmonFord;

import java.util.HashMap;
import java.util.Map;
public class Algo {

    //TC V*E
    //SC V
    //for complete graph V*E*(E-1)~ O(n^3)

    //Dijkstras is better for positive weights
    //Can handle negative weights
    //Can detect negative cycle - if after V-1 iterations, we still can relax edges, then there is a negative cycle
    //Can handle disconnected graphs
    //drawback is that it is not efficient for large graphs and negative weight cycle.
    //Approach is to relax(means update node distance if it is less than current distance) all edges V-1 times


    public static Map<Integer,Integer> bellmonFord(int [][]edges, int start, int n){
        Map<Integer,Integer> dist = new HashMap<>();
        for(int i=0;i<n;i++){
            dist.put(i,Integer.MAX_VALUE);
        }
        dist.put(start,0);
        for(int i=0;i<n-1;i++){
            for(int edge[]:edges){
                int u = edge[0];
                int v = edge[1];
                int cost = edge[2];
                if(dist.get(u)!=Integer.MAX_VALUE && (dist.get(u)+cost)<dist.get(v)){
                    dist.put(v, dist.get(u)+cost);
                }
            }
        }
        return dist;
        
    }   

    public static void main(String[] args) {
        int [][]edges = {{0,1,5},{1,2,-2},{2,3,-1},{3,4,1}};
        int start = 0;
        int n = 5;
        System.out.println(bellmonFord(edges, start, n));
    }

      

}
