public class RegularUser extends User
{

  public RegularUser(String name, String password)
  {
    super(name, password);
  }

  public String getAccess()
  {
    return "NONE";
  }
}
