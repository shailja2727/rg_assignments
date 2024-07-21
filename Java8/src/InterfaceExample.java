interface MyInterface {
    // Default method
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
    // Static method
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}
class MyClass implements MyInterface {
    // Overriding the default method
    @Override
    public void defaultMethod() {
        System.out.println("This is an overridden default method.");
    }
}
public class InterfaceExample {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        // Calling the overridden default method
        myClass.defaultMethod(); // Prints: This is an overridden default method.
        // Calling the static method
        MyInterface.staticMethod(); // Prints: This is a static method.
    }
}
