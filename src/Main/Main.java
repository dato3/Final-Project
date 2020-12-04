package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.Model;

public class Main extends Action {
	
	private UserDAO userDAO;
	
	public Main(Model model) {
        userDAO = model.getUserDAO();
    }
	
	public String getName() {
        return "main.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "main.jsp";
        }
        else {
        	request.setAttribute("user", user);
        }
        return ("main.jsp");
    }
}