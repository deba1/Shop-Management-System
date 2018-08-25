package attr;

import java.lang.*;
import java.sql.*;
import attr.*;

public class Employee extends User {
	private String employeeName;
	private String phoneNumber;
	private String role;
	private double salary;
	public Employee(String userId) {
		super(userId);
		
		this.setStatus(0);
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public double getSalary() {
		return salary;
	}
	
	public void fetch() {
		String query = "SELECT `userId`, `employeeName`, `phoneNumber`, `role`, `salary` FROM `employee`;";     
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
					this.employeeName = rs.getString("employeeName");
					this.phoneNumber = rs.getString("phoneNumber");
					this.role = rs.getString("role");
					this.salary = rs.getDouble("salary");
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