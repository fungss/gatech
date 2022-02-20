import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class TestingGraphAlgo {
    
    public static void main(String args[]){
        Set<Integer> testSet = new HashSet<>();
        for (int i=8; i>=0 ; i--){
            testSet.add(i);
        }
        List<Integer> result = new ArrayList<>(testSet);
        System.out.println(result.toString());
    }
}
