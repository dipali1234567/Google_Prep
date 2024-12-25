package goldman;

import java.util.List;

public class Problem4 {

    //Given s = 'abcde' and validChars = ['a', 'b', 'c'] return the sum of lengths of all valid substrings of s. A valid substring is any substring of s which contains only valid characters.

    public int sumOfLengthsOfValidSubstrings(String s, List<Character> validChars){
        int result = 0;
        for(int i=0;i<s.length();i++){
            if(validChars.contains(s.charAt(i))){
                result++;
            }
        }
        return result;
    }
}