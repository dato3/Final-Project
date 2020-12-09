package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.CartDAO;
import ProjectDAO.FeaturedMedicineDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;
import ProjectDAO.NewsDAO;
import ProjectDAO.RecentMedicineDAO;

public class Main extends Action {
	private UserDAO userDAO;
	private RecentMedicineDAO recentMedicineDAO;
	private FeaturedMedicineDAO featuredMedicineDAO;
	private NewsDAO newsDAO;
	private CartDAO cartDAO;
	
	public Main(Model model) {
        userDAO = model.getUserDAO();
        recentMedicineDAO = model.getRecentMedicineDAO();
        featuredMedicineDAO = model.getFeaturedMedicineDAO();
        newsDAO = model.getNewsDAO();
        cartDAO = model.getCartDAO();
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
        try {
			request.setAttribute("recentMedicines", recentMedicineDAO.getRecentMedicines());
			request.setAttribute("featuredMedicines", featuredMedicineDAO.getFeaturedMedicines());
			request.setAttribute("news", newsDAO.getNews());
			if (user == null) {
	            return "main.jsp";
	        }
	        else {
	        	request.setAttribute("user", user);
	        }
		} catch (MyDAOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
        return ("main.jsp");
    }
}