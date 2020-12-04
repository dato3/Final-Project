package ProjectDAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Model {
    private UserDAO userDAO;

    public Model(ServletConfig config) throws ServletException {
        try {
            String jdbcDriver = config.getInitParameter("jdbcDriverName");
            String jdbcURL = config.getInitParameter("jdbcURL");
            userDAO = new UserDAO(jdbcDriver, jdbcURL, "users");
        } catch (MyDAOException e) {
            throw new ServletException(e);
        }
    }
    public UserDAO getUserDAO() {
    	return userDAO;
    }
}
