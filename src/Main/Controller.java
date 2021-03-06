package Main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBeans.User;
import ProjectDAO.Model;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        Model model = new Model(getServletConfig());

        Action.add(new Login(model));
        Action.add(new Register(model));
        Action.add(new Logout(model));
        Action.add(new Main(model));
        Action.add(new Blog(model));
        Action.add(new About(model));
        Action.add(new Contact(model));
        Action.add(new Basket(model));
        Action.add(new Shop(model));
        Action.add(new Search(model));
        Action.add(new Medicine(model));
        Action.add(new AddToCart(model));
        Action.add(new Remove(model));
        Action.add(new Buy(model));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage, request, response);
    }

    /*
     * Extracts the requested action and (depending on whether the user is
     * logged in) perform it (or make the user login).
     * 
     * @param request
     * 
     * @return the next page (the view)
     */
    private String performTheAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String servletPath = request.getServletPath();
        User user = (User) session.getAttribute("user");
        String action = getActionName(servletPath);
        if (user != null) {
            return Action.perform(action, request);
        } else if (action.equals("main.do")) {
        	return Action.perform("main.do", request);
        } else if (action.equals("blog.do")) {
        	return Action.perform("blog.do", request);
        } else if (action.equals("about.do")) {
        	return Action.perform("about.do", request);
        } else if (action.equals("contact.do")) {
        	return Action.perform("contact.do", request);
        } else if (action.equals("shop.do")) {
        	return Action.perform("shop.do", request);
        } else if (action.equals("search.do")) {
        	return Action.perform("search.do", request);
        } else if (action.equals("medicine.do")) {
        	return Action.perform("medicine.do", request);
        }
        
        // If the user hasn't logged in, login is the only option
        // Note in this example, register is in the login action.
        if (action.equals("login.do")) {
            return Action.perform("login.do", request);
        }
        
        if (action.equals("register.do")) {
        	return Action.perform("register.do", request);
        }
        
        // The not-logged user is trying to execute an action other
        // than login.  This is usually due to his session timing
        // out but he could be fooling around.  Let's give him a
        // stale session error message.  Another option would be
        // to send him to login.jsp, instead.
        return "controller-stale-session.jsp";
    }

    /*
     * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
     * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
     * page (the view) This is the common case
     */
    private void sendToNextPage(String nextPage, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        if (nextPage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    request.getServletPath());
            return;
        }

        if (nextPage.endsWith(".do")) {
            response.sendRedirect(nextPage);
            return;
        }

        if (nextPage.endsWith(".jsp")) {
            RequestDispatcher d = request.getRequestDispatcher("WEB-INF/"
                    + nextPage);
            d.forward(request, response);
            return;
        }

        throw new ServletException(Controller.class.getName()
                + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }

    /*
     * Returns the path component after the last slash removing any "extension"
     * if present.
     */
    private String getActionName(String path) {
        // We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash + 1);
    }
}
