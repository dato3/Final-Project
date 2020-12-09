package ProjectDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataBeans.Medicine;
import DataBeans.User;

public class MedicinesDAO {
    private List<Connection> connectionPool = new ArrayList<Connection>();

    private String jdbcDriver;
    private String jdbcURL;
    private String tableName;

    public MedicinesDAO(String jdbcDriver, String jdbcURL, String tableName)
            throws MyDAOException {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;
        this.tableName = tableName;
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

    public Medicine[] readMedicinesByName(String medicineName, int currentPage) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "
                    + tableName + " WHERE LOWER(medicine_name) LIKE ? OFFSET "+(currentPage-1)*30+" ROWS FETCH FIRST 30 ROWS ONLY");
            
            pstmt.setString(1, medicineName+"%");
            ResultSet rs = pstmt.executeQuery();
            List<Medicine> list = new ArrayList<Medicine>();
            while (rs.next()) {
                Medicine bean = new Medicine();
                bean.setMedicineName(rs.getString("medicine_name"));
                bean.setImage(rs.getString("image"));
                bean.setPrice(rs.getInt("price"));
                bean.setVendorCode(rs.getLong("vendor_code"));
                bean.setBarcode(rs.getLong("barcode"));
                bean.setAvailability(rs.getInt("availability"));
                list.add(bean);
            }
            pstmt.close();
            releaseConnection(con);

            return list.toArray(new Medicine[list.size()]);
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    
    public Medicine[] getMedicines() throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "
                    + tableName);
          
            ResultSet rs = pstmt.executeQuery();

            List<Medicine> list = new ArrayList<Medicine>();
            while (rs.next()) {
                Medicine bean = new Medicine();
                bean.setMedicineName(rs.getString("medicine_name"));
                bean.setImage(rs.getString("image"));
                bean.setPrice(rs.getInt("price"));
                bean.setVendorCode(rs.getLong("vendor_code"));
                bean.setBarcode(rs.getLong("barcode"));
                bean.setAvailability(rs.getInt("availability"));
                list.add(bean);
            }
            pstmt.close();
            releaseConnection(con);

            return list.toArray(new Medicine[list.size()]);
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public Medicine[] getMedicinesById(int currentPage) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "
                    + tableName + " OFFSET "+(currentPage-1)*30+" ROWS FETCH FIRST 30 ROWS ONLY");
          
            ResultSet rs = pstmt.executeQuery();

            List<Medicine> list = new ArrayList<Medicine>();
            while (rs.next()) {
                Medicine bean = new Medicine();
                bean.setMedicineName(rs.getString("medicine_name"));
                bean.setImage(rs.getString("image"));
                bean.setPrice(rs.getInt("price"));
                bean.setVendorCode(rs.getLong("vendor_code"));
                bean.setBarcode(rs.getLong("barcode"));
                bean.setAvailability(rs.getInt("availability"));
                list.add(bean);
            }
            pstmt.close();
            releaseConnection(con);

            return list.toArray(new Medicine[list.size()]);
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }
    }
    public int getNumberOfRows() throws MyDAOException{
    	int numOfRows;
    	Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(medicine_name) FROM "+tableName);
          
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	numOfRows = rs.getInt("count(medicine_name)");
            } else {
            	numOfRows = 0;
            }
            pstmt.close();
            releaseConnection(con);
            return numOfRows;
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }

    }
    public int getNumberOfRowsByName(String medicineName) throws MyDAOException{
    	int numOfRows;
    	Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(medicine_name) FROM "+tableName+" WHERE LOWER(medicine_name) LIKE ?");
            pstmt.setString(1, medicineName+"%");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	numOfRows = rs.getInt("count(medicine_name)");
            } else {
            	numOfRows = 0;
            }
            pstmt.close();
            releaseConnection(con);
            return numOfRows;
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            throw new MyDAOException(e);
        }

    }
    public Medicine readMedicine(String medicineName) throws MyDAOException {
        Connection con = null;
        try {
            con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "
                    + tableName + " WHERE medicine_name=?");
            pstmt.setString(1, medicineName);
            ResultSet rs = pstmt.executeQuery();

            Medicine med;
            if (!rs.next()) {
                med = null;
            } else {
            	med = new Medicine();
            	med.setMedicineName(rs.getString("medicine_name"));
            	med.setImage(rs.getString("image"));
            	med.setPrice(rs.getInt("price"));
            	med.setVendorCode(rs.getLong("vendor_code"));
            	med.setBarcode(rs.getLong("barcode"));
            	med.setAvailability(rs.getInt("availability"));
            }

            rs.close();
            pstmt.close();
            releaseConnection(con);
            return med;

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