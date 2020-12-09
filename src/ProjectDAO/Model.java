package ProjectDAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Model {
    private UserDAO userDAO;
    private RecentMedicineDAO recentMedicineDAO;
    private FeaturedMedicineDAO featuredMedicineDAO;
    private NewsDAO newsDAO;
    private MedicinesDAO medicinesDAO;
    private CartDAO cartDAO;

    public Model(ServletConfig config) throws ServletException {
        try {
            String jdbcDriver = config.getInitParameter("jdbcDriverName");
            String jdbcURL = config.getInitParameter("jdbcURL");
            userDAO = new UserDAO(jdbcDriver, jdbcURL, "users");
            recentMedicineDAO = new RecentMedicineDAO(jdbcDriver, jdbcURL, "recent_medicines");
            featuredMedicineDAO = new FeaturedMedicineDAO(jdbcDriver, jdbcURL, "featured_medicines");
            newsDAO = new NewsDAO(jdbcDriver, jdbcURL, "news");
            medicinesDAO = new MedicinesDAO(jdbcDriver, jdbcURL, "medicines");
            cartDAO = new CartDAO(jdbcDriver, jdbcURL, "cart_table");
        } catch (MyDAOException e) {
            throw new ServletException(e);
        }
    }
    public UserDAO getUserDAO() {
    	return userDAO;
    }
    public RecentMedicineDAO getRecentMedicineDAO() {
    	return recentMedicineDAO;
    }
    public FeaturedMedicineDAO getFeaturedMedicineDAO() {
    	return featuredMedicineDAO;
    }
    public NewsDAO getNewsDAO() {
    	return newsDAO;
    }
    public MedicinesDAO getMedicinesDAO() {
    	return medicinesDAO;
    }
    public CartDAO getCartDAO() {
    	return cartDAO;
    }
}
