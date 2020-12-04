package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.Model;

public class Blog extends Action {
	
	private UserDAO userDAO;
	
	public Blog(Model model) {
        userDAO = model.getUserDAO();
    }
	
	public String getName() {
        return "blog.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "blog.jsp";
        }
        else {
        	request.setAttribute("user", user);
        }
        return ("blog.jsp");
    }
}