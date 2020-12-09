package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.CartDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;
import ProjectDAO.UserDAO;
import FormBeans.LoginForm;

/*
 * Logs out by setting the "user" session attribute to null.
 * (Actions don't be much simpler than this.)
 */
public class Logout extends Action {
	private UserDAO userDAO;
	private CartDAO cartDAO;
	
	public Logout(Model model) {
		userDAO = model.getUserDAO();
		cartDAO = model.getCartDAO();
	}

    public String getName() {
        return "logout.do";
    }

    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        session.setAttribute("totalPrice", null);
        try {
			cartDAO.deleteTable();
		} catch (MyDAOException e) {
			e.printStackTrace();
		}
//        try {
////            session.setAttribute("users", userDAO.getUsers());
//        } catch(RollbackException e) {
//        	request.setAttribute("error", e.getMessage());
//            return "error.jsp";
//        }

        request.setAttribute("form", new LoginForm());
        return "login.do";
    }
}
