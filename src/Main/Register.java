package Main;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;

import ProjectDAO.Model;
import ProjectDAO.MyDAOException;
import ProjectDAO.UserDAO;
import DataBeans.User;
import FormBeans.RegisterForm;

public class Register extends Action {
	private FormBeanFactory<RegisterForm> formBeanFactory = new FormBeanFactory<>(RegisterForm.class);

    private UserDAO userDAO;
    
    public Register(Model model) {
    	userDAO = model.getUserDAO();
    }
    
    public String getName() {
        return "register.do";
    }  
    
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("hw_users") != null) {
            return "main.do";
        }
        
        request.setAttribute("form", new RegisterForm());
        return "register.jsp";
    }

    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "main.do";
        }

        RegisterForm form = formBeanFactory.create(request);
        request.setAttribute("form", form);
        // Any validation errors?
        if (form.hasValidationErrors()) {
            return "register.jsp";
        }

        // Look up the user
        try {
            if (!form.getPassword().equals(form.getConfirmPassword())) {
            	form.addFieldError("password", "Password should match");
                return "register.jsp";
            }
            User newUser = new User();
            newUser.setUserName(form.getUserName());
            newUser.setFirstName(form.getFirstName());
            newUser.setLastName(form.getLastName());
            newUser.setPassword(form.getPassword());
            userDAO.create(newUser);
            session.setAttribute("user", newUser);
            return ("main.do");
        } catch (MyDAOException e) {
            form.addFieldError("userName", "A user with this name already exists");
            return "register.jsp";
        }
    }
}