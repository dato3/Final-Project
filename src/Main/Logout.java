package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.Model;
import ProjectDAO.UserDAO;
import FormBeans.LoginForm;

/*
 * Logs out by setting the "user" session attribute to null.
 * (Actions don't be much simpler than this.)
 */
public class Logout extends Action {
	private UserDAO userDAO;
	
	public Logout(Model model) {
		userDAO = model.getUserDAO();
	}

    public String getName() {
        return "logout.do";
    }

    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
//        try {
////            session.setAttribute("users", userDAO.getUsers());
//        } catch(RollbackException e) {
//        	request.setAttribute("error", e.getMessage());
//            return "error.jsp";
//        }

        request.setAttribute("form", new LoginForm());
        return "login.jsp";
    }
}
