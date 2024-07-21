import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names1 = Arrays.asList("John", "Jane", "Jack", "Jill");
        List<String> names2 = Arrays.asList("John", "Jane", "Jack", "Jill");

        // Using method reference to sort by length
        names1.sort(Comparator.comparingInt(String::length));
        System.out.println(names1);
        // Using lambda expression to sort by length
        names2.sort((a, b) -> Integer.compare(a.length(), b.length()));

        System.out.println(names2);
    }
}