public class LinkedList {
    User head;

    void add(User user){
        User newUser = new User(user.username, user.password, user.role);
        newUser.next = head;
        head = newUser;
    }

    User find(String username, String password){
        User current = head;
        while(current != null){
            if(current.username.equals(username) && current.password.equals(password)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void display(){
        User current = head;
        while(current != null){
            System.out.println("- " + current.username + " (" + current.role + ")");
            current = current.next;
        }
    }
}
