public class User {
    private String name;
    private String password;
    private String access;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public String getName() {
        return name;
    }

    public String getPassword()
    {
        return password;
    }
}
