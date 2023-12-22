package school_Mangement;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class employeeInformation {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2_4;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2;
	private JTextField jtxtaddress;
	private JTextField jtxtdob;
	private JTextField jtxtgender;
	private JTextField jtxtlname;
	private JTextField jtxtfname;
	private JTextField jtxtempid;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_2;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JScrollPane scrollPane;
	private JTable table;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField jtxtmobno;
	private JTextField jtxtsalary;
	private JTextField jtxtdesgn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeInformation window = new employeeInformation();
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
	public void updateTable() {
		if(conn != null) {
			try {
				String sql = "SELECT Emp_ID,Fname,Lname,Gender,DOB,Address,Mob_no,Salary,Designation FROM employeeData";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
	        }
		}
	 }
	/**
	 * Create the application.
	 */
	public employeeInformation() {
		initialize();
		clock();
		conn = employeeData.ConnectDB();
		updateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(112, 128, 144));
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnNewButton_2 = new JButton("New button");
		Image img = new ImageIcon(this.getClass().getResource("/home_icon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//return home page
				@SuppressWarnings("unused")
				Modules info = new Modules();
				Modules.main(null);
			}
		});
		btnNewButton_2.setBounds(0, 0, 86, 70);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("Help");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Help info = new Help();
				Help.main(null);
			}
		});
		btnNewButton_1.setBounds(1256, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1_2 = new JButton("About");
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				About info = new About();
				About.main(null);
			}
		});
		btnNewButton_1_2.setBounds(1143, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(85, 0, 220, 40);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("EMPLOYEE INFORMATION SYSTEM");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(366, 9, 664, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2_4 = new JLabel("DOB (dd/MM/YYYY)");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(65, 320, 179, 35);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		jtxtaddress = new JTextField();
		jtxtaddress.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtaddress.setColumns(10);
		jtxtaddress.setBounds(254, 374, 253, 40);
		frame.getContentPane().add(jtxtaddress);
		
		jtxtdob = new JTextField();
		jtxtdob.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtdob.setColumns(10);
		jtxtdob.setBounds(254, 320, 253, 35);
		frame.getContentPane().add(jtxtdob);
		
		lblNewLabel_2_1_1 = new JLabel("GENDER");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(85, 258, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		jtxtgender = new JTextField();
		jtxtgender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtgender.setColumns(10);
		jtxtgender.setBounds(254, 258, 253, 35);
		frame.getContentPane().add(jtxtgender);
		
		jtxtlname = new JTextField();
		jtxtlname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtlname.setColumns(10);
		jtxtlname.setBounds(254, 205, 253, 35);
		frame.getContentPane().add(jtxtlname);
		
		lblNewLabel_2_2 = new JLabel("LAST NAME");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(85, 205, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		jtxtfname = new JTextField();
		jtxtfname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtfname.setColumns(10);
		jtxtfname.setBounds(254, 145, 253, 35);
		frame.getContentPane().add(jtxtfname);
		
		lblNewLabel_2_1 = new JLabel("FIRST NAME");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(85, 145, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		lblNewLabel_2 = new JLabel("EMPLOYEE ID (YYEMP0000)");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(24, 91, 220, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		jtxtempid = new JTextField();
		jtxtempid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtempid.setColumns(10);
		jtxtempid.setBounds(254, 91, 253, 35);
		frame.getContentPane().add(jtxtempid);
		
		btnNewButton = new JButton("Add New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = 0;
					String value1 = jtxtempid.getText();
		        	boolean chk1 = value1.regionMatches(2, "EMP", 0, 3);
					String value2 = jtxtfname.getText();
					String value3 = jtxtlname.getText();
					String value4 = jtxtgender.getText();
					if(value4.equals("MALE")|| value4.equals("male") || value4.equals("female") || value4.equals("FEMALE")) {
						num=5;
					}
					String value5 = jtxtdob.getText();
					Date date1 =null;
					try {
						date1 = new SimpleDateFormat("dd/MM/yyyy").parse(value5);
						int v1 = date1.getDate();
						
					} catch (ParseException ev) {
						// TODO Auto-generated catch block
						num = 2;
					}
					String value6 = jtxtaddress.getText();
					String value7 = jtxtmobno.getText();
					try {
						int i = Integer.parseInt(value7);
					} catch (Exception ev) {
						int add = value7.length()+1;
						if(add>11) {
							num=3;
						}
					}
					String value8 = jtxtsalary.getText();
					try {
						int i = Integer.parseInt(value8);
					} catch (Exception ev) {
						num=4;
					}
					String value9 = jtxtdesgn.getText();
		        	if(value1.equals("") || value2.equals("") || value3.equals("") || value4.equals("") || value5.equals("") || 
							value6.equals("") || value7.equals("") || value8.equals("") || value9.equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the complete data");
					} else if(chk1==false) {
						JOptionPane.showMessageDialog(null, "Please Enter the Employee ID in correct Format");
					} else if(chk1==false) {
						JOptionPane.showMessageDialog(null, "Please Enter the Teacher ID in correct Format");
					} else if(num==2) {
						JOptionPane.showMessageDialog(null, "Eneter the date in correct Format");
					} else if(num==3) {
						JOptionPane.showMessageDialog(null, "Enter the correct mobile number");
					} else if(value7.length() > 10) {
						JOptionPane.showMessageDialog(null, "The Mobile Number should contain only 10 numbers");
					} else if(num==4) {
						JOptionPane.showMessageDialog(null, "Enter the correct salary amount");
					} else if(num!=5) {
						JOptionPane.showMessageDialog(null, "Enter the correct Gender");
					}
		        	else {
		        	String sql = "INSERT INTO employeeData(Emp_ID,Fname,Lname,Gender,DOB,Address,Mob_no,Salary,Designation)"
								+ "VALUES(?,?,?,?,?,?,?,?,?)";
		        	pst = employeeData.ConnectDB().prepareStatement(sql);
					pst.setString(1, value1);
					pst.setString(2, value2);
					pst.setString(3, value3);
					pst.setString(4, value4);
					pst.setString(5, value5);
					pst.setString(6, value6);
					pst.setString(7, value7);
					pst.setString(8, value8);
					pst.setString(9, value9);
					pst.execute();
					JOptionPane.showMessageDialog(null, "System Update Completed");
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model. addRow(new Object[] {
							jtxtempid.getText(),
							jtxtfname.getText(),
							jtxtlname.getText(),
							jtxtgender.getText(),
							jtxtdob.getText(),
							jtxtaddress.getText(),
							jtxtmobno.getText(),
							jtxtsalary.getText(),
							jtxtdesgn.getText()
					});
					if(table.getSelectedRow() == -1) {
						if(table.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "Student Update Confirmed", "Student Information System",
									JOptionPane.OK_OPTION);
						}
					}
				}
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, "Database Error");
				}
				jtxtempid.setText(null);
				jtxtfname.setText(null);
				jtxtlname.setText(null);
				jtxtgender.setText(null);
				jtxtdob.setText(null);
				jtxtaddress.setText(null);
				jtxtmobno.setText(null);
				jtxtsalary.setText(null);
				jtxtdesgn.setText(null);
			}
		});
	
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(207, 624, 100, 35);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtempid.setText(null);
				jtxtfname.setText(null);
				jtxtlname.setText(null);
				jtxtgender.setText(null);
				jtxtdob.setText(null);
				jtxtaddress.setText(null);
				jtxtmobno.setText(null);
				jtxtsalary.setText(null);
				jtxtdesgn.setText(null);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(65, 624, 100, 35);
		frame.getContentPane().add(btnNewButton_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(554, 91, 788, 487);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emp_ID", "Fname", "Lname", "Gender", "DOB", "Address", "Mob_no", "Salary", "Designation"
			}
		));
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("ADDRESS");
		lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_3.setBounds(85, 375, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("MOBILE NUMBER");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(85, 433, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		jtxtmobno = new JTextField();
		jtxtmobno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtmobno.setColumns(10);
		jtxtmobno.setBounds(254, 433, 253, 35);
		frame.getContentPane().add(jtxtmobno);
		
		jtxtsalary = new JTextField();
		jtxtsalary.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtsalary.setColumns(10);
		jtxtsalary.setBounds(254, 486, 253, 35);
		frame.getContentPane().add(jtxtsalary);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("SALARY");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(85, 486, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("DESIGNATION");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_2.setBounds(85, 544, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_2);
		
		jtxtdesgn = new JTextField();
		jtxtdesgn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtdesgn.setColumns(10);
		jtxtdesgn.setBounds(254, 544, 253, 35);
		frame.getContentPane().add(jtxtdesgn);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = 0;
					String value1 = jtxtempid.getText();
		        	boolean chk1 = value1.regionMatches(2, "TEA", 4, 3);
					String value2 = jtxtfname.getText();
					String value3 = jtxtlname.getText();
					String value4 = jtxtgender.getText();
					if(value4.equals("MALE")|| value4.equals("male") || value4.equals("female") || value4.equals("FEMALE")) {
						num=5;
					}
					String value5 = jtxtdob.getText();
					Date date1 =null;
					try {
						date1 = new SimpleDateFormat("dd/MM/yyyy").parse(value5);
						int v1 = date1.getDate();
						
					} catch (ParseException ev) {
						// TODO Auto-generated catch block
						num = 2;
					}
					String value6 = jtxtaddress.getText();
					String value7 = jtxtmobno.getText();
					try {
						int i = Integer.parseInt(value7);
					} catch (Exception ev) {
						int add = value7.length()+1;
						if(add>11) {
							num=3;
						}
					}
					String value8 = jtxtsalary.getText();
					try {
						int i = Integer.parseInt(value8);
					} catch (Exception ev) {
						num=4;
					}
					String value9 = jtxtdesgn.getText();
		        	if(value1.equals("") || value2.equals("") || value3.equals("") || value4.equals("") || value5.equals("") || 
							value6.equals("") || value7.equals("") || value8.equals("") || value9.equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the complete data");
					} else if(chk1==false) {
						JOptionPane.showMessageDialog(null, "Please Enter the Employee ID in correct Format");
					} else if(num==2) {
						JOptionPane.showMessageDialog(null, "Eneter the date in correct Format");
					} else if(num==3) {
						JOptionPane.showMessageDialog(null, "Enter the correct mobile number");
					} else if(value7.length() > 10) {
						JOptionPane.showMessageDialog(null, "The Mobile Number should contain only 10 numbers");
					} else if(num==4) {
						JOptionPane.showMessageDialog(null, "Enter the correct salary amount");
					} else if(num!=5) {
						JOptionPane.showMessageDialog(null, "Enter the correct Gender");
					}
		        	else {
					String sql = "UPDATE employeeData SET Emp_ID="+"\""+value1 +
							"\""+" , Fname="+"\""+value2+"\""+", Lname="+"\""+value3+
							"\""+", Gender ="+"\""+value4+"\""+", DOB="+"\""+value5+"\""
							+", Address="+"\""+value6+"\""+", Mob_no="+"\""+value7+"\""+
							", Salary = "+"\""+value8+"\""+", Designation= "+"\""+ value9 +"\""+ 
							" WHERE Emp_ID = "+"\""+value1+"\"";
					pst = employeeData.ConnectDB().prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Updated Successfully");
				} 
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, "Updation Error");
				}
			}
		});
		btnNewButton_4.setBounds(349, 625, 100, 35);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_5.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				try {
					String value1 = jtxtempid.getText();
					@SuppressWarnings("unused")
					String sql = "DELETE FROM employeeData WHERE Emp_ID = "+"\""+value1+"\"";
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, "Deletion Error");
				}
			}
		});
		btnNewButton_5.setBounds(491, 624, 100, 35);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Print");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				MessageFormat header = new MessageFormat("Printing in Progress");
				@SuppressWarnings("unused")
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				try {
					table.print();
				}
				catch(Exception ev) {
					System.err.format("No printer Found", ev.getMessage());
				}
			}
		});

		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_6.setBounds(653, 624, 108, 35);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Exit");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					@SuppressWarnings("unused")
					Modules info = new Modules();
					Modules.main(null);
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_7.setBounds(807, 624, 108, 35);
		frame.getContentPane().add(btnNewButton_7);
	}
}
