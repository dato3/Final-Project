package Main;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;

import ProjectDAO.CartDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;
import ProjectDAO.UserDAO;
import DataBeans.User;
import FormBeans.LoginForm;

public class Login extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = new FormBeanFactory<>(LoginForm.class);
	private CartDAO cartDAO;
    private UserDAO userDAO;
    
    public Login(Model model) {
    	userDAO = model.getUserDAO();
    	cartDAO = model.getCartDAO();
    }
    
    public String getName() {
        return "login.do";
    }  
    
    public String performGet(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") != null) {
            return "main.do";
        }
        request.setAttribute("form", new LoginForm());
        return "login.jsp";
    }

    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "main.do";
        }

        try {
            LoginForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // Any validation errors?
            if (form.hasValidationErrors()) {
                return "login.jsp";
            }

            // Look up the user
            User user = userDAO.read(form.getUserName());

            if (user == null) {
                form.addFieldError("userName", "User Name not found");
                return "login.jsp";
            }

            // Check the password
            if (!user.getPassword().equals(form.getPassword())) {
                form.addFieldError("password", "Incorrect password");
                return "login.jsp";
            }
            // Attach (this copy of) the user bean to the session
            session.setAttribute("user", user);
            session.setAttribute("cartData", cartDAO.read(user.getUserName()));

            // If redirectTo is null, redirect to the "todolist" action
            return "main.do";
        } catch (MyDAOException e) {
            session.setAttribute("error", e.getMessage());
            return "error.jsp";
        }
    }
}