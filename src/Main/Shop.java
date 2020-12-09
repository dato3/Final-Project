package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.MedicinesDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;

public class Shop extends Action {
	private UserDAO userDAO;
	private MedicinesDAO medicinesDAO;
	
	public Shop(Model model) {
        userDAO = model.getUserDAO();
        medicinesDAO = model.getMedicinesDAO();
    }
	
	public String getName() {
        return "shop.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = 30;
        int rows;
        try {
        	rows = medicinesDAO.getNumberOfRows();
			int nOfPages = rows / recordsPerPage;
			if (rows % recordsPerPage != 0) {
				nOfPages++;
			}
			request.setAttribute("medicines", medicinesDAO.getMedicinesById(currentPage));
			request.setAttribute("noOfPages", nOfPages);
	        request.setAttribute("currentPage", currentPage);
			if (user == null) {
	            return "shoppage.jsp";
	        }
	        else {
	        	request.setAttribute("user", user);
	        }
		} catch (MyDAOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
        return ("shoppage.jsp");
    }
}