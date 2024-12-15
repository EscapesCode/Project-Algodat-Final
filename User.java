public class User{
    String username;
    String password;
    String role;
    User next;

    public User(String username, String password, String role){
        this.username = username;
        this.password =  password;
        this.role = role;
        this.next = null;
    }
}