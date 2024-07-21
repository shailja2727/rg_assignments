import java.util.Arrays;
import java.util.List;

public class LambdaExpression {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Shailja", "Diya", "Aayushi", "Anjali");

        // Using lambda expression to iterate over the list
        names.forEach(name -> System.out.println(name));
    }
}
