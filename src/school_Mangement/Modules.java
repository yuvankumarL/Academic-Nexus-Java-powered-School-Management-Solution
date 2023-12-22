package school_Mangement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class Modules {

	private JFrame frame;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modules window = new Modules();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clock() {
		
		Thread clock = new Thread() {
			public void run() {
				try {
					for(;;) {
					Calendar cal = new GregorianCalendar();
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					
					int second = cal.get(Calendar.SECOND);
					int minutes = cal.get(Calendar.MINUTE);
					int hour = cal.get(Calendar.HOUR);
					
					lblClock.setText("Date: " + day + "/" + month + "/" + year +"    Time " + hour + ":" + minutes + ":" + second);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
	
	/**
	 * Create the application.
	 */
	public Modules() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBounds(100, 100, 1049, 538);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Teachers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Enter to the teacherInformation
				@SuppressWarnings("unused")
				teacherInformation info = new teacherInformation();
				teacherInformation.main(null);
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnNewButton.setBounds(111, 429, 129, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Enter to the studentInformation
				@SuppressWarnings("unused")
				studentInformation info = new studentInformation();
				studentInformation.main(null);
			}
		});
		btnStudents.setBackground(new Color(135, 206, 250));
		btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnStudents.setBounds(488, 429, 129, 28);
		frame.getContentPane().add(btnStudents);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Enter into employeeInformation
				@SuppressWarnings("unused")
				employeeInformation info = new employeeInformation();
				employeeInformation.main(null);
			}
		});
		btnEmployee.setBackground(new Color(135, 206, 235));
		btnEmployee.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEmployee.setBounds(819, 429, 129, 28);
		frame.getContentPane().add(btnEmployee);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/teacher.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBackground(new Color(230, 230, 250));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(55, 170, 257, 248);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Help info = new Help();
				Help.main(null);
			}
		});
		btnNewButton_1.setBounds(809, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("About");
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				About info = new About();
				About.main(null);
			}
		});
		btnNewButton_1_2.setBounds(695, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Log Out");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Admin info = new Admin();
				Admin.main(null);
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		btnNewButton_1_1.setBounds(919, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1_1);
		

		@SuppressWarnings("unused")
		Image img4 = new ImageIcon(this.getClass().getResource("/home_icon.png")).getImage();
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		Image img2 = new ImageIcon(this.getClass().getResource("/student (2).png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img2));
		lblNewLabel_3.setForeground(new Color(240, 255, 240));
		lblNewLabel_3.setBackground(new Color(230, 230, 250));
		lblNewLabel_3.setBounds(442, 174, 210, 241);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		Image img3 = new ImageIcon(this.getClass().getResource("/employee.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		lblNewLabel_4.setForeground(new Color(240, 255, 240));
		lblNewLabel_4.setBackground(new Color(230, 230, 250));
		lblNewLabel_4.setBounds(765, 180, 234, 229);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("REGISTER USERS");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_5.setBounds(405, 64, 315, 35);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("New button");
		Image img5 = new ImageIcon(this.getClass().getResource("/home_icon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img5));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(0, 0, 86, 70);
		frame.getContentPane().add(btnNewButton_2);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblClock.setForeground(new Color(0, 0, 0));
		lblClock.setBounds(87, 0, 297, 35);
		frame.getContentPane().add(lblClock);
	}
}
