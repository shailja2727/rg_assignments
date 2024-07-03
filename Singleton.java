public class Singleton {

    private static Singleton instance;

    private Singleton()
    {

    }

    // static method to get the singleton instance
    public static Singleton getInstance()
    {
        //Lazy initialization
        if(instance == null)
        {
            System.out.println("Created instance");
            instance = new Singleton();
        }
        return instance;
    }
    public void display_message()
    {
        System.out.println("The singleton instance is created");
    }

    public static void main(String [] args)
    {
        Singleton s = Singleton.getInstance();
        s.display_message();
    }
}
