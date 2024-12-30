package Google_Questions;
import java.util.*;

public class Problem110Dec {
    // You are given a grid with locations for a mouse and a target cheese block. The mouse wants to reach the cheese, some cells are filled with water which cannot be crossed.  
    // Can the mouse reach the cheese? The mouse can move along the horizontal and vertical directions.

    //The grid also has a cat at some given location. You have to find the maximum distance which you can always maintain from the cat.  
    //What if we want to find the shortest path for this maximum distance?

    static int [][] grid;
    static int m;
    static int n;
    static int cheeserowLocation;
    static int cheeseColumnLocation;
    static int row [] = {1,-1,0,0};
    static int col [] = {0,0,1,-1};

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        Problem110Dec.grid = grid;
        Problem110Dec.m = grid.length;
        Problem110Dec.n = grid[0].length;
        Problem110Dec.cheeserowLocation = 3;
        Problem110Dec.cheeseColumnLocation = 4;
        System.out.println("-------------Phone Screening-----------------");
        System.out.println(canMouseReachCheeseBfs( 0, 0));
        System.out.println("-------------DSA1-----------------");
        System.out.println(largestKDigitNumber("3582", 2));
        System.out.println("-------------DSA2-----------------");
        List<String> result = new ArrayList<>();
        getSequences(0, 4, result, "",2);
        System.out.println(result.toString());
        System.out.println("-------------DSA3-----------------");
        
    }

    
    public static boolean canMouseReachCheese( int i, int j ){
        if( i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1)
        return false;
        if(i== cheeserowLocation && j == cheeseColumnLocation)
            return true;

        return canMouseReachCheese(i+1,j)||canMouseReachCheese(i-1,j)||canMouseReachCheese(i,j+1)||canMouseReachCheese(i,j-1);
    }

    public static boolean canMouseReachCheeseBfs( int i, int j ){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int []{i,j});
        int vis[][] = new int [m][n];
        vis[i][j] = 1;
        while(!queue.isEmpty()){
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for(int k=0;k<4;k++){
                int newx = x + row[k];
                int newy = y + col[k];
            if(newx<m && newy<n  && newx>=0 && newy>=0 && grid[newx][newy]==0 && vis[newx][newy]==0){
                vis[newx][newy] = 1;
                if(x==cheeserowLocation && y==cheeseColumnLocation) return true;
                queue.add(new int [] {newx, newy});
            }
        }
        }
        return false;
    }

    // How to solve this part ?     //The grid also has a cat at some given location. You have to find the maximum distance which you can always maintain from the cat.  

    public static int maxDistanceFromCat(int i, int j){
        int maxDistance = 0;
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(grid[x][y] == 0)
                    maxDistance = Math.max(maxDistance, Math.abs(x-i) + Math.abs(y-j));
            }
        }
        return maxDistance;
    }
        

    // You are given a number (very long) and an integer K. Find the largest K-digit number that can be formed
// from the original number (preserve the order). 

// Example : S = "3582",   K=2
// Output: "82"

// Follow up 1: Solve in O(n) time
// Follow up 2: Solve in O(n) time and O(k) space

public static String largestKDigitNumber(String s, int k){
    PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
    int n = s.length();
    generateSubSequence(s,k,0,"",n, pq);
    return pq.peek();
}

public static String largestKDigitNumberOn(String s, int k){
    PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
    int n = s.length();
    generateSubSequence(s,k,0,"",n, pq);
    return pq.peek();
}

public static void generateSubSequence(String s, int k , int index, String sub, int n, PriorityQueue<String> pq){
    if(index == n){
        if(sub.length()==k){
            pq.add(sub);
        }
        return;
    }
    generateSubSequence(s,k,index+1,sub+s.charAt(index),n,pq);
    generateSubSequence(s,k,index+1,sub,n,pq);
}

// You are given a number (very long) and an integer K. Find the largest K-digit number that can be formed
// from the original number (preserve the order). 

// Example : S = "3582",   K=2
// Output: "82"

// solve above problem in O(n) time and O(k) space

//
// Get all sequences that sum to a particular number if digits 1 & 2 can be used.

// Example : Sum=4 
// Result : [“1111”, “112”, “121”, “211”, “22”]

// Follow up 1: What if we are allowed to use first K digits. (1,2,3,...,K)
// Follow up 2: What if we have to only count the number of sequences for the original question?
// Follow up 3: Count the number of sequences when K digits are allowed


public static void getSequences(int sum, int k, List<String> result, String sub, int digit){
    
    if(sum == k){
        result.add(sub); return;
    }

    if(sum>k) return;
    for(int i=1;i<=digit;i++){
        getSequences(sum+i,k,result, sub+i,digit);
    }
}

// Follow up 2: What 
public static void getSequences(int sum, int k, int [] count, String sub, int digit){
    
    if(sum == k){
        count[0]++; return;
    }

    if(sum>k) return;
    for(int i=1;i<=digit;i++){
        getSequences(sum+i,k,count, sub+i,digit);
    }
}


// Given an expression with some variables, operands (+ and -) and parenthesis, return the simplified expression.

// Example : a-(a-b)-c
// Output : b-c

// Follow up: 
// What if nested parentheses are allowed?

// Example: a-(b-(c-a)) + c
// Output : -b+2c




}
