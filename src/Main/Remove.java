package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.CartDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;

public class Remove extends Action {
	private CartDAO cartDAO;
	private UserDAO userDAO;
	
	public Remove(Model model) {
        userDAO = model.getUserDAO();
        cartDAO = model.getCartDAO();
    }
	
	public String getName() {
        return "remove.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String medicineName = request.getParameter("medicineName");
        if (user == null) {
            return "basket.jsp";
        }
        else {
        	request.setAttribute("user", user);
        	try {
        		cartDAO.removeRow(medicineName);
        		session.setAttribute("totalPrice", cartDAO.totalCalulation(user.getUserName()));
        		session.setAttribute("cartData", cartDAO.read(user.getUserName()));
			} catch (MyDAOException e) {
				e.printStackTrace();
			}
        }
        return ("basket.jsp");
    }
}