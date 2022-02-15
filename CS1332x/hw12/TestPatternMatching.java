import java.util.ArrayList;
import java.util.Map;

public class TestPatternMatching {

    public static void main(String args[]){
        System.out.println("-----------test buildLastTable-----------");
        String testString = "octocat";
        System.out.printf("Test input charSequence: %s", testString);
        System.out.println();
        Map<Character, Integer> testTable = PatternMatching.buildLastTable(testString);
        char[] testChars = new char[]{'o', 'c', 't', 'a', 'u'};
        for (char c:testChars){
            System.out.printf("Index in last occurrence table: %d", testTable.getOrDefault(c, -1));
            System.out.println();
        }


        System.out.println("-----------test boyerMoore-----------");
        CharacterComparator comparator = new CharacterComparator();
        String testText = "because im happy";
        System.out.printf("Test text is: %s", testText);
        System.out.println();
        String testPattern = "happy";
        System.out.printf("Test pattern is: %s", testPattern);
        System.out.println();
        ArrayList<Integer> res = (ArrayList<Integer>) PatternMatching.boyerMoore(testPattern, testText, comparator);
        System.out.printf("The resulting array is: %s", res.toString());
        System.out.println();
    }
}
