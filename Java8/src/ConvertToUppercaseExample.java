import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToUppercaseExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java8", "feature", "assignment", "deadline");

        // Convert each string to uppercase
        List<String> uppercaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseWords);
    }
}