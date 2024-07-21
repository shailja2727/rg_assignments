import java.util.Optional;

public class OptionalEg {
    public static void main(String[] args) {
        Optional<String> nonEmpty = Optional.of("Hello, World!");
        Optional<String> empty = Optional.ofNullable(null);

        nonEmpty.ifPresent(System.out::println); // Prints: Hello, World!
        System.out.println(empty.orElse("Default Value")); // Prints: Default Value

        nonEmpty.map(String::length).ifPresent(System.out::println); // Prints: 13
    }
}
