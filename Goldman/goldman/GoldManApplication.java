package goldman;

public class GoldManApplication {

    public static void main(String[] args) {
        Problem1 problem = new Problem1();
        
        // Example test case from the problem description
        int[][] grid = {
            {0, 0, 0, 0, 5},  // New York (finish)
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}   // Southern California (start)
        };
        
        int result = problem.optimalPathMy(grid);
        System.out.println("Optimal path sum: " + result);
    }

}
