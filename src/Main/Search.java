package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.MedicinesDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;

public class Search extends Action {
	private UserDAO userDAO;
	private MedicinesDAO medicinesDAO;
	
	public Search(Model model) {
        userDAO = model.getUserDAO();
        medicinesDAO = model.getMedicinesDAO();
    }
	
	public String getName() {
        return "search.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        String txt = request.getParameter("inputText");
        int recordsPerPage = 30;
        int rows;
        try {
        	rows = medicinesDAO.getNumberOfRowsByName(txt.toLowerCase());
			int nOfPages = rows / recordsPerPage;
			if (rows % recordsPerPage != 0) {
				nOfPages++;
			}
			request.setAttribute("inputTxt", txt);
			request.setAttribute("medicines", medicinesDAO.readMedicinesByName(txt.toLowerCase(),currentPage));
			request.setAttribute("noOfPages", nOfPages);
	        request.setAttribute("currentPage", currentPage);
			if (user == null) {
	            return "searchpage.jsp";
	        }
	        else {
	        	request.setAttribute("user", user);
	        }
		} catch (MyDAOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
        return ("searchpage.jsp");
    }
}