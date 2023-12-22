package school_Mangement;

import java.sql.*;
import javax.swing.*;
public class employeeData {

	public static Connection ConnectDB() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:employeeData.db");
					JOptionPane.showMessageDialog(null, "Connection Made");
			        return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			return null;
		}
	}

}
