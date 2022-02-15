import java.util.Comparator;

public class IntComparator implements Comparator<Integer> {

    public int compare(Integer a1, Integer b2)  {
        return a1.compareTo(b2);
        // return a1 - b2;
    }
}
