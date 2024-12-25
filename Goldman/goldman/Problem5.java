package goldman;

import java.util.ArrayList;
import java.util.List; 

public class Problem5 {

    //I gave codepad round interview.
// Question asked was


// There are n students in circular manner.
// Teacher is singing and walking around the circle. 
//Once she stop the singing the student at that position will be removed.
// Last remained Student will be president of a class.
// There is song length k will be given.


// e.g
// n = 4 ( No of Student)
// k = 2 ( Length of song)


// Ans will - 1
// Explaination -
// in 1st Run she will stop and student 2
// 2nd time at 4th Student
// 3rd time at 3 Student
// Last 1st Student will be president of a class.

public int findPresident(int n, int k){
    int result = 0;
    List<Integer> students = new ArrayList<>();
    for(int i=0;i<n;i++){
        students.add(i+1);
    }   
    int currentInd = 0;
    while(students.size()>1){
        currentInd = (currentInd+k-1)%students.size();
        students.remove(currentInd);
    }
    return students.get(0);
}   

}
