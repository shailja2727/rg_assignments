class Name {
    // Private is using to hide the data
    private int age;

    // getter
    public int getAge() { return age; }

    // setter
    public void setAge(int age) { this.age = age; }
}

public class Encapsulate {
    // main function
    public static void main(String[] args)
    {
        Name n1 = new Name();
        n1.setAge(19);
        System.out.println("The age of the person is: "
                + n1.getAge());
    }

}
