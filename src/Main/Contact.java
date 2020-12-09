package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.Model;

public class Contact extends Action {
	
	private UserDAO userDAO;
	
	public Contact(Model model) {
        userDAO = model.getUserDAO();
    }
	
	public String getName() {
        return "contact.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "contact.jsp";
        }
        else {
        	request.setAttribute("user", user);
        }
        return ("contact.jsp");
    }
}