package attr;

import java.lang.*;
import javax.swing.*;
import java.sql.*;
import attr.*;
import activity.*;

public class Customer extends User {
	private String customerName;
	private String phoneNumber;
	private String address;
	public Customer(String userId) {
		super(userId);
		
		this.setStatus(1);
	}
	
	public void setCustomerName(String name) {
		if (!name.isEmpty())
			this.customerName = name;
		else
			throw new IllegalArgumentException("Fill in the name");
	}
	public void setPhoneNumber(int num) {
		this.phoneNumber = "+880"+num;
	}
	public void setAddress(String address) {
		if (!address.isEmpty())
			this.address = address;
		else
			throw new IllegalArgumentException("Fill in the address");
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}

	public void createCustomer(JFrame sa) {
		String query1 = "INSERT INTO `login` VALUES ('"+userId+"','"+password+"',"+status+");";
		String query2 = "INSERT INTO `customer` VALUES ('"+userId+"','"+customerName+"','"+phoneNumber+"','"+address+"');";
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
		System.out.println(query2);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);//insert
			st.execute(query2);
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Account Created!");
			sa.setVisible(false);
			new LoginActivity().setVisible(true);
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to create account!");
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public void fetch() {
		String query = "SELECT `userId`, `customerName`, `phoneNumber`, `address` FROM `customer`;";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
				if (userId.equals(rs.getString("userId"))) {
					this.customerName = rs.getString("customerName");
					this.phoneNumber = rs.getString("phoneNumber");
					this.address = rs.getString("address");
				}
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
}