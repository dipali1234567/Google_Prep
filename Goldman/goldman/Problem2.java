package goldman;

public class Problem2 {

    //Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], 
    //follow each element to the index it points to. Find a cycle and return its length. No cycle is found -> -1.


    // Lets dry run the example
    // arr = [1,3,0,1]
    // startInd = 0
    // 0 -> 1 -> 3 -> 1
    // cycle length = 3 (1->3->1)

    // arr = [1,2,0]
    // startInd = 0
    // 0 -> 1 -> 2 -> 0
    // cycle length = 3 (0->1->2->0)

    // arr = [1,2,3,4,5]
    // startInd = 0
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 1
    // cycle length = 5 (0->1->2->3->4->5->1)

    // now no cycle scenario
    // arr = [1,2,3,4,5]
    // startInd = 0
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5
    // no cycle found
    // return -1



    public int findCycleLength(int [] arr, int startInd){
        int result = 0;
        int currentStartInd = startInd;
        int currentInd = arr[currentStartInd];
        while((currentInd != currentStartInd) && (result<arr.length)){
            currentInd = arr[currentInd];
            result++;
        }
        return result!=0?result:-1;
    }
}

