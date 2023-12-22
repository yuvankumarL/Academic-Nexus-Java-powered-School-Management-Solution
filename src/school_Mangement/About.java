package school_Mangement;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class About {

	private JFrame frame;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
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
					
					lblNewLabel.setText("Date: " + day + "/" + month + "/" + year +"    Time " + hour + ":" + minutes + ":" + second);
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
	public About() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		Image img = new ImageIcon(this.getClass().getResource("/home_icon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//return home page
				Modules info = new Modules();
				info.main(null);
			}
		});
		btnNewButton_2.setBounds(0, 0, 86, 70);
		frame.getContentPane().add(btnNewButton_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(86, 0, 211, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("             ABOUT US");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(360, 48, 402, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane txtpnWeAreThe = new JTextPane();
		txtpnWeAreThe.setBackground(UIManager.getColor("Button.shadow"));
		txtpnWeAreThe.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtpnWeAreThe.setText("We are the Technical Terms of School Information system. This application is developed in an aim to manage the record of School which includes students -, Teacher and Employees, All the data Entered here can be exported as digital format Through Database. Admin\u2019s User Name and Password is designed by Primary key. For any Queries regarding Application you can Contact us through Above Given Email.");
		txtpnWeAreThe.setBounds(86, 139, 880, 195);
		frame.getContentPane().add(txtpnWeAreThe);
		frame.setBounds(100, 100, 1049, 538);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
