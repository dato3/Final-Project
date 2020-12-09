package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;
import ProjectDAO.NewsDAO;

public class Blog extends Action {
	private UserDAO userDAO;
	private NewsDAO newsDAO;
	
	public Blog(Model model) {
        userDAO = model.getUserDAO();
        newsDAO = model.getNewsDAO();
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
        try {
			request.setAttribute("news", newsDAO.getNews());
			if (user == null) {
	            return "blog.jsp";
	        }
	        else {
	        	request.setAttribute("user", user);
	        }
		} catch (MyDAOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
        return ("blog.jsp");
    }
}