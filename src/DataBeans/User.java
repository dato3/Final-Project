package DataBeans;

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

    public String getUserName()        { return userName; }
    public String getFirstName()        { return firstName; }
    public String getLastName()        { return lastName; }
    public String getPassword()        { return password; }
    public String getConfirmPassword()        { return confirmPassword; }

    public void setUserName(String s)  { userName = s;    }
    public void setFirstName(String s)  { firstName = s;    }
    public void setLastName(String s)  { lastName = s;    }
    public void setPassword(String s)  { password = s;    }
    public void setConfirmPassword(String s)  { confirmPassword = s;    }
}