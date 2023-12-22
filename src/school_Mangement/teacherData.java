package school_Mangement;

import java.sql.*;
import javax.swing.*;
public class teacherData {
	public static Connection ConnectDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:teacherData.db");
			JOptionPane.showMessageDialog(null, "connection made");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			return null;
		}
	}
}
