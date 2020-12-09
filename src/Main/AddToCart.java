package Main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.User;
import ProjectDAO.CartDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;
import DataBeans.Cart;

public class AddToCart extends Action {
	private UserDAO userDAO;
	private CartDAO cartDAO;
	
	public AddToCart(Model model) {
        userDAO = model.getUserDAO();
        cartDAO = model.getCartDAO();
    }
	
	public String getName() {
        return "addtocart.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String userName = user.getUserName();
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String medicineName = request.getParameter("medicineName");
        String image = request.getParameter("image");
        int price = Integer.parseInt(request.getParameter("price"));
        long vendorCode = Long.parseLong(request.getParameter("vendorCode"));
        long barcode = Long.parseLong(request.getParameter("barcode"));
        int availability = Integer.parseInt(request.getParameter("availability"));
        int totalPrice = price * quantity;
        try {
			Cart cart = new Cart();
			cart.setUserName(userName);
			cart.setMedicineName(medicineName);
			cart.setImage(image);
			cart.setPrice(price);
			cart.setVendorCode(vendorCode);
			cart.setBarcode(barcode);
			cart.setAvailability(availability);
			cart.setQuantity(quantity);
			cart.setTotalPrice(totalPrice);
			if (user == null) {
	            return "main.do";
	        }
	        else {
	        	request.setAttribute("user", user);
	        }
			cartDAO.create(cart);
			session.setAttribute("totalPrice", cartDAO.totalCalulation(user.getUserName()));
		} catch (MyDAOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
        return ("main.do");
    }
}