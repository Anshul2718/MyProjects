package Prototype;

public class User  implements ObjectClonable{
    private int userId;
    private String username;
    private String email;
    private  String displayName;
    private  int age;

    public User(int userId, String username, String email, String displayName, int age){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.age = age;
    }
    public ObjectClonable clone(){
        try {
            return (ObjectClonable) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
}
