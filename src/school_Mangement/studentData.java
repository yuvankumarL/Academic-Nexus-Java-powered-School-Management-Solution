package school_Mangement;

import java.sql.*;
import javax.swing.*;

public class studentData {
	public static Connection ConnectDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:studentData.db");
			JOptionPane.showMessageDialog(null, "connection Made");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			return null;
		}
	}
}
