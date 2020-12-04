package FormBeans;

import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("userName,password")
public class LoginForm extends FormBean{
    private String userName;
    private String password;
    private String action;

    public String getUserName() {	return userName;}
    public String getPassword() {	return password;}
    public String getAction()   {   return action;  }
    
    public void setUserName(String s)  { userName = s.trim(); }
    @InputType("password")
    public void setPassword(String s)  { password = s.trim(); }
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
            this.addFieldError("userName", "May not contain angle brackets or quotes");
        }
    }
}
