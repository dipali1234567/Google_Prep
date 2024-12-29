package Google_Questions;
import java.util.HashMap;
import java.util.Map;

public class ProblemAskedToMe {

    // Question asked was
    // Given Map -> {"X":"123","Y":"456_%X%"}
    
    // And you will be given with input "%X%_%Y%" 
    
    // Output should be "123_456_123

    


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("X", "123");
        map.put("Y", "456_%X%");

        String input = "%X%_%Y%";
        String output = replaceVariables(map, input);
        System.out.println(output);
    }

   public static String replaceVariables(Map<String, String> map, String input) {
        do{
            for (Map.Entry<String, String> entry : map.entrySet()) {
            input = input.replace("%" + entry.getKey() + "%", entry.getValue());
        }
        }while(input.contains("%"));
        return input;
    }


}

