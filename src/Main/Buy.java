package Main;

import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ProjectDAO.UserDAO;
import DataBeans.Cart;
import DataBeans.User;
import ProjectDAO.CartDAO;
import ProjectDAO.Model;
import ProjectDAO.MyDAOException;

public class Buy extends Action {
	private UserDAO userDAO;
	private CartDAO cartDAO;
	
	public Buy(Model model) {
        userDAO = model.getUserDAO();
        cartDAO = model.getCartDAO();
    }
	
	public String getName() {
        return "buy.do";
    }

    public String performGet(HttpServletRequest request) {
    	return performPost(request);
    }
    
    public String performPost(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String username = request.getParameter("userName");
        String emailAddr = request.getParameter("emailaddress");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNumber");
        String bankNum = request.getParameter("bankNumber");
        String orderNum = getRandomNumberString();
        double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));
        
        try {
        	User userOf = userDAO.read(emailAddr);
        	String text = "Hey "+userOf.getFirstName()+" "+userOf.getLastName()+", your order#"+orderNum+" has been successfully accepted.\n\n\nYour order will be delivered by the address: "+address
        			+ "\nUpon the arrival of the medicines, our courier will contact you by phone: "+phoneNum+"\nYou purchased Grand Total was: "+grandTotal+" KZT";
        	Cart[] cart = cartDAO.read(user.getUserName());
        	for(int t = 0;t < cart.length;t++) {
        		cartDAO.DelInsMedProcedure(cart[t].getMedicineName());
        		cartDAO.InsFeaturedProcedure(cart[t].getMedicineName(), cart[t].getQuantity());
        		cartDAO.BuyLogInsert(Integer.parseInt(orderNum), cart[t].getUserName(), cart[t].getMedicineName(), cart[t].getQuantity(), cart[t].getTotalPrice());
        	}
			cartDAO.deleteTable();
			session.setAttribute("totalPrice", cartDAO.totalCalulation(user.getUserName()));
			if (user == null) {
	            return "main.do";
	        }
	        else {
	        	request.setAttribute("user", user);
	        }
			try {
				JavaMailUtil.sendMail(emailAddr, text);
			} catch (MessagingException e1) {
				e1.printStackTrace();
			}
		} catch (MyDAOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
        return ("main.do");
    }
    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}