package school_Mangement;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Help {

	private JFrame frame;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help();
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
	public Help() {
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
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help info = new Help();
				info.main(null);
			}
		});
		btnNewButton_1.setBounds(919, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("About");
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About info = new About();
				info.main(null);
			}
		});
		btnNewButton_1_2.setBounds(805, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(86, 0, 245, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HELP");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(454, 54, 231, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane txtpnYouMust = new JTextPane();
		txtpnYouMust.setBackground(UIManager.getColor("Button.shadow"));
		txtpnYouMust.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		txtpnYouMust.setText("1. You must log in fast to access data from database.\r\n2. Choice any Option for data Insert, Delete, Update, Save to database.\r\n3. Only Admin can able to delete any data from database.\r\n4. You can back up your Data.\r\n5. You can search Data from a large number data.\r\n6. Birth day type must be:dd-mm-yyyy(Ex:17-08-2002)\r\n7. ID must be Unique and recommending 4 digits for Students, Teachers and Employees.\r\n8. You can change your(Admin) password.\r\n9. For any help Please Email me: yuvan.kumar2020@vitstudent.ac.in , sabarinath.2020@vitstudent.ac.in \r\n");
		txtpnYouMust.setBounds(139, 142, 802, 281);
		frame.getContentPane().add(txtpnYouMust);
	}

}
