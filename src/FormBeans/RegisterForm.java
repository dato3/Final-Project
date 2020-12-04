package FormBeans;

import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("userName,firstName,lastName,password,confirmPassword")
public class RegisterForm extends FormBean{
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String action;

    public String getUserName() 	   {	return userName; 		}
    public String getFirstName()	   {    return firstName;		}
    public String getLastName()	   	   {    return lastName; 		}
    public String getPassword() 	   {	return password; 		}
    public String getConfirmPassword() {	return confirmPassword; }
    public String getAction()   	   {   	return action;  		}
    
    public void setUserName(String s)  		  { userName = s.trim(); 		}
    public void setFirstName(String s)  	  { firstName = s.trim(); 		}
    public void setLastName(String s)  	  	  { lastName = s.trim(); 		}
    @InputType("password")
    public void setPassword(String s)  		  { password = s.trim(); 		}
    @InputType("password")
    public void setConfirmPassword(String s)  { confirmPassword = s.trim(); }
    @InputType("button")
    public void setAction(String s)    { action   = s;        }

    public void validate() {
        if (hasValidationErrors()) {
            return;
        }
        if (userName == null || userName.length() == 0) {
        	this.addFieldError("userName","User Name is required");
        }
        if (password == null || password.length() == 0) {
        	this.addFieldError("password","Password is required");
        }
        if (confirmPassword == null || confirmPassword.length() == 0) {
        	this.addFieldError("confirmPassword","Confirmation Password is required");
        }
        if (firstName == null || firstName.length() == 0) {
        	this.addFieldError("firstName","First Name is required");
        }
        if (lastName == null || lastName.length() == 0) {
        	this.addFieldError("lastName","Last Name is required");
        }
        if (hasValidationErrors()) {
            return;
        }
        if (!userName.contains("@")) {
        	this.addFieldError("userName","User Name is invalid");
        }
        if (hasValidationErrors()) {
            return;
        }
        if (userName.matches(".*[<>\"].*")) {
            this.addFieldError("userName", "Username may not contain angle brackets or quotes");
        }
    }
}
