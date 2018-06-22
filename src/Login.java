import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private ArrayList<User> users = new ArrayList<>();
    private Scanner in = new Scanner(System.in);

    public Login() {
        welcomePage();
    }

    public void welcomePage()
    {
        System.out.print("Welcome:\nPress 1 to Login\nPress 2 to sign up: ");
        int option = in.nextInt();
        System.out.println();

        if (option == 1) // if login is selected
        {
            if (users.size() < 1) //check if any users have been signed up
            {
                System.out.println("No users added, please sign up first");
                addUser(); //direct them to sign Up
            }
            loginUser();
        } else if (option == 2) {
            addUser(); //sign up new user
        }
    }
    private void addUser() {
        //get user details
        System.out.println("Welcome to the signUp page: ");
        System.out.print("Please Enter your name: ");
        String name = in.next();

        System.out.print("Please Enter your password: ");
        String password = in.next();
        System.out.println();

        //get user access level
        System.out.println("Please grant access to the user,\n'A' for all access\n'N' for limited access");
        String access = in.next().toUpperCase();
        System.out.println();

        //set user access level
        if (access.equals("A")) {
            users.add(new Admin(name, password));
        } else if (access.equals("N")) {
            users.add(new RegularUser(name, password));
        }
        loginUser();
    }

    private void loginUser()
    {
        System.out.println("Welcome to the Login page: ");
        //get user login details
        System.out.print("Please enter your name: ");
        String name = in.next();
        System.out.print("Please enter your password: ");
        String password = in.next();
        verifyUser(name, password);
    }
    private void verifyUser(String name, String password)
    {
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) //check if password and are correct
            {
                new Menu(user.getAccess()); //get users access and open the menu
                welcomePage();
            }
        }
        System.out.println("Wrong user or password.");
    }
}
