package ProjectDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBeans.Cart;
import DataBeans.User;

public class CartDAO {
    private List<Connection> connectionPool = new ArrayList<Connection>();

    private String jdbcDriver;
    private String jdbcURL;
    private String tableName;

    public CartDAO(String jdbcDriver, String jdbcURL, String tableName)
            throws MyDAOException {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;
        this.tableName = tableName;
        if (!tableExists()) {
        	createTable();        	
        } else {
        	deleteTable();
        }
    }

    private synchronized Connection getConnection() throws MyDAOException {
        if (connectionPool.size() > 0) {
            return connectionPool.remove(connectionPool.size() - 1);
        }

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new MyDAOException(e);
        }

        try {
            return DriverManager.getConnection(jdbcURL, "system", "oracle");
        } catch (SQLException e) {
            throw new MyDAOException(e);
        }
    }

    private synchronized void releaseConnection(Connection con) {
        connectionPool.add(con);
    }

    public Cart[] read(String userName) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "
                    + tableName + " WHERE userName=?");
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            List<Cart> list = new ArrayList<Cart>();
            while(rs.next()) {
            	Cart cart = new Cart();
                cart.setUserName(rs.getString("userName"));
                cart.setMedicineName(rs.getString("medicine_name"));
                cart.setImage(rs.getString("image"));
                cart.setPrice(rs.getInt("price"));
                cart.setVendorCode(rs.getLong("vendor_code"));
                cart.setBarcode(rs.getLong("barcode"));
                cart.setAvailability(rs.getInt("availability"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setTotalPrice(rs.getInt("totalPrice"));
                list.add(cart);
            }

            rs.close();
            pstmt.close();
            releaseConnection(con);
            return list.toArray(new Cart[list.size()]);

        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    private boolean tableExists() throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "
                    + tableName);
            ResultSet rs = pstmt.executeQuery();
            rs.close();
            releaseConnection(con);
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            return false;
        }
        return true;
    }
    private void createTable() throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE "
                    + tableName
                    + " (userName VARCHAR(255) NOT NULL, medicine_name VARCHAR(255) NOT NULL, image VARCHAR(255), price NUMBER(10), vendor_code number(8), barcode number(20), availability number(5), quantity number(5), totalPrice number(20))");
            stmt.close();

            releaseConnection(con);

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public void create(Cart cart) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO "
                    + tableName + " (userName,medicine_name,image,price,vendor_code,barcode,availability,quantity,totalPrice) VALUES (?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, cart.getUserName());
            pstmt.setString(2, cart.getMedicineName());
            pstmt.setString(3, cart.getImage());
            pstmt.setInt(4, cart.getPrice());
            pstmt.setLong(5, cart.getVendorCode());
            pstmt.setLong(6, cart.getBarcode());
            pstmt.setInt(7, cart.getAvailability());
            pstmt.setInt(8, cart.getQuantity());
            pstmt.setInt(9, cart.getTotalPrice());
            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("Insert updated " + count + " rows");

            pstmt.close();
            releaseConnection(con);

        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public void deleteTable() throws MyDAOException {
    	Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM "
                    + tableName);
            ResultSet rs = pstmt.executeQuery();
            rs.close();
            pstmt.close();
            releaseConnection(con);

        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public void removeRow(String medicineName) throws MyDAOException {
    	Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM "
                    + tableName + " WHERE medicine_name=?");
            pstmt.setString(1, medicineName);
            ResultSet rs = pstmt.executeQuery();
            rs.close();
            pstmt.close();
            releaseConnection(con);

        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public int totalCalulation(String userName) throws MyDAOException {
    	Connection con = null;
    	try {
    		con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT SUM(totalPrice) FROM "+tableName+" WHERE userName=?");
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            int res;
            if(rs.next()) {
            	res = rs.getInt("sum(totalPrice)");            	
            } else {
            	res = 0;
            }
            rs.close();
            pstmt.close();
            releaseConnection(con);
            return res;
    	} catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public void InsFeaturedProcedure(String medName, int quantity) throws MyDAOException {
    	Connection con = null;
    	try {
    		con = getConnection();
    		PreparedStatement pstmt = con.prepareStatement("BEGIN ins_featured(?,?); END;");
    		pstmt.setString(1, medName);
    		pstmt.setInt(2, quantity);
    		ResultSet rs = pstmt.executeQuery();
    		rs.close();
            pstmt.close();
            releaseConnection(con);
    	} catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public void DelInsMedProcedure(String medName) throws MyDAOException {
    	Connection con = null;
    	try {
    		con = getConnection();
    		PreparedStatement pstmt = con.prepareStatement("BEGIN del_ins_med(?, SYSDATE); END;");
    		pstmt.setString(1, medName);
    		ResultSet rs = pstmt.executeQuery();
    		rs.close();
            pstmt.close();
            releaseConnection(con);
    	} catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public void BuyLogInsert(int order_num, String userName, String medName, int quantity, int tot_price) throws MyDAOException {
    	Connection con = null;
    	try {
    		con = getConnection();
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO buy_log(order_number, userName, date_bought, medicine_name, quantity_bought, tot_price) VALUES (?, ?, SYSDATE, ?, ?, ?)");
    		pstmt.setInt(1, order_num);
    		pstmt.setString(2, userName);
    		pstmt.setString(3, medName);
    		pstmt.setInt(4, quantity);
    		pstmt.setInt(5, tot_price);
    		ResultSet rs = pstmt.executeQuery();
    		rs.close();
            pstmt.close();
            releaseConnection(con);
    	} catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
}