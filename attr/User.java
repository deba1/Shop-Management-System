package attr;

import java.lang.*;
import java.sql.*;
import attr.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import activity.*;

public abstract class User {
	protected String userId;
	protected String password;
	private static final String UPDATE_PASSWORD_QUERY = "UPDATE `login` SET `password`=? WHERE (`userId`=? AND `password`=?)";
	protected int status;
	
	public User(String userId) {
		if (!userId.isEmpty())
			this.userId = userId;
		else
			throw new IllegalArgumentException("Fill in the User ID");
	}
	
	public abstract void fetch();

	public static DefaultTableModel search(String keyword, String byWhat) {
		return null;
	}

	public abstract void delete();

	public String getUserId() {
		return userId;
	}
	public void setStatus(int stts) {
		this.status = stts;
	}
	public void setPassword(String passwd) {
		if (!passwd.isEmpty())
			this.password = passwd;
		else
			throw new IllegalArgumentException("Fill in the password");
	}
	
	public static int checkStatus(String uid, String pass) {
		int result = -1;
		String query = "SELECT `userId`, `password`, `status` FROM `login`;";     
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
                String userId = rs.getString("userId");
                String password = rs.getString("password");
				int status = rs.getInt("status");
				
				if(userId.equals(uid) && password.equals(pass)) {
					result = status;
				}
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
			ex.printStackTrace();
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
		return result;
	}
	
	public void changePassword(ChangePasswordActivity a, String oldPass, String newPass) {
		Connection con = null;
        Statement st = null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con =  DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			PreparedStatement ps = con.prepareStatement(UPDATE_PASSWORD_QUERY);
			ps.setString(1, newPass);
			ps.setString(2, this.userId);
			ps.setString(3, oldPass);
			int res = ps.executeUpdate();//insert

			System.out.println("data inserted");
			if (res > 0) {
				JOptionPane.showMessageDialog(null,"Password Updated!");
			a.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null,"Password didn't match!");
			}
		}
        catch(Exception ex) {
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
}