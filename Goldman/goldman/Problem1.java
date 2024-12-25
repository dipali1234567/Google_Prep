package goldman;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1 {
    // Instructions to candidate.
 	// **  1) You are an avid rock collector who lives in southern California. Some rare 
 	// **     and desirable rocks just became available in New York, so you are planning 
 	// **     a cross-country road trip. There are several other rare rocks that you could 
 	// **     pick up along the way. 
 	// **     
 	// **     You have been given a grid filled with numbers, representing the number of 
 	// **     rare rocks available in various cities across the country.  Your objective 
 	// **     is to find the optimal path from So_Cal to New_York that would allow you to 
 	// **     accumulate the most rocks along the way. 
 	// **     
 	// **     Note: You can only travel either north (up) or east (right).
 	// **  2) Consider adding some additional tests in doTestsPass().
 	// **  3) Implement optimalPath() correctly.
 	// **  4) Here is an example:
 	// **                                                           ^
 	// **                 {{0,0,0,0,5}, New_York (finish)           N
 	// **                  {0,1,1,1,0},                         < W   E >
 	// **   So_Cal (start) {2,0,0,0,0}}                             S
 	// **                                                           v 
 	// **   The total for this example would be 10 (2+0+1+1+1+0+5).

     int grid [][];
    int m ;
    int n;
    int [][] dp;





    public   int  optimalPathMy(int [][] grid) {
        this.grid= grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dp = new int[m][n];
        for(int [] a: dp) Arrays.fill(a,-1);
        return runAndWalk(m-1,0); 
    }

    public  int  runAndWalk(int i, int j) {
        if(i==0 && j==(n-1)){
            return grid[i][j];
        }

        if(i>=m || j>=n || i<0 ||j<0){
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int up = runAndWalk(i-1,j);
        int right = runAndWalk(i,j+1);
        return dp[i][j] =(grid[i][j]+Math.max(up,right));  
    }

    public static void doTestsPass() {
        Problem1 solution = new Problem1();
        int[][] testGrid = {
            {0, 0, 0, 0, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}
        };
        
        int result = solution.optimalPathMy(testGrid);
        boolean testPassed = result == 10;
        
        System.out.println("Test " + (testPassed ? "PASSED" : "FAILED"));
        System.out.println("Expected: 10, Got: " + result);
    }
}
