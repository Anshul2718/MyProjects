package Prototype;

public class PrototypePatternTest {
    public static void main(String[] args) {
        UserPrototypeRegistry registry = new UserPrototypeRegistryImpl();

        User adminUser = new User(1,"admin","admin@example.com","Admin",30);

        registry.addPrototype("admin", adminUser);
        User cloneAdmin = (User) registry.cloneUser("admin");
        System.out.println("Is cloneAdmin the same object as adminUser? "+(cloneAdmin == adminUser));
        System.out.println("Cloned Admin User: "+cloneAdmin);
        System.out.println("Test passed successfully.");

    }
}
