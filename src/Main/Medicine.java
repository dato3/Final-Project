package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.MedicinesDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;

public class Medicine extends Action {
	private UserDAO userDAO;
	private MedicinesDAO medicinesDAO;
	
	public Medicine(Model model) {
        userDAO = model.getUserDAO();
        medicinesDAO = model.getMedicinesDAO();
    }
	
	public String getName() {
        return "medicine.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String medicineName = request.getParameter("medicineName");
        try {
			request.setAttribute("medicine", medicinesDAO.readMedicine(medicineName));
			if (user == null) {
	            return "medicine.jsp";
	        }
	        else {
	        	request.setAttribute("user", user);
	        }
		} catch (MyDAOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
        return ("medicine.jsp");
    }
}