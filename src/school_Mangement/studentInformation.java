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

public class studentInformation {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_4;
	private JLabel lblNewLabel_2_1_3;
	private JTextField jtxtstudid;
	private JTextField jtxtFname;
	private JTextField jtxtLname;
	private JTextField jtxtgender;
	private JTextField jtxtdob;
	private JTextField jtxtaddress;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField jtxtmobno;
	private JTextField jtxtclass;
	private JTextField jtxtsection;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentInformation window = new studentInformation();
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
		if (conn != null) {
			try {
				String sql = "SELECT Stu_ID,Fname,Lname,Gender,DOB,Address,Mobile_no,Class,Section FROM studentData";
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
	public studentInformation() {
		initialize();
		clock();
		conn = studentData.ConnectDB();
		updateTable();
		
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
		btnNewButton_1_2.setBounds(1142, 0, 114, 35);
		frame.getContentPane().add(btnNewButton_1_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(85, 0, 269, 35);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("STUDENTS INFORMATION SYSTEM");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(414, 0, 599, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		jtxtstudid = new JTextField();
		jtxtstudid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtstudid.setColumns(10);
		jtxtstudid.setBounds(263, 81, 223, 35);
		frame.getContentPane().add(jtxtstudid);
		
		lblNewLabel_2 = new JLabel("STUDENT ID (YYSTU0000)");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(46, 81, 207, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("FIRST NAME");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(94, 139, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		jtxtFname = new JTextField();
		jtxtFname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtFname.setColumns(10);
		jtxtFname.setBounds(263, 139, 223, 35);
		frame.getContentPane().add(jtxtFname);
		
		lblNewLabel_2_2 = new JLabel("LAST NAME");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(94, 204, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		jtxtLname = new JTextField();
		jtxtLname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtLname.setColumns(10);
		jtxtLname.setBounds(263, 211, 223, 35);
		frame.getContentPane().add(jtxtLname);
		
		lblNewLabel_2_1_1 = new JLabel("GENDER");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(94, 262, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		jtxtgender = new JTextField();
		jtxtgender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtgender.setColumns(10);
		jtxtgender.setBounds(263, 262, 223, 35);
		frame.getContentPane().add(jtxtgender);
		
		lblNewLabel_2_4 = new JLabel("DOB (dd/MM/YYYY)");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(57, 316, 196, 35);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		jtxtdob = new JTextField();
		jtxtdob.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtdob.setColumns(10);
		jtxtdob.setBounds(263, 323, 223, 35);
		frame.getContentPane().add(jtxtdob);
		
		lblNewLabel_2_1_3 = new JLabel("ADDRESS");
		lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_3.setBounds(85, 374, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_3);
		
		jtxtaddress = new JTextField();
		jtxtaddress.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtaddress.setColumns(10);
		jtxtaddress.setBounds(263, 374, 223, 35);
		frame.getContentPane().add(jtxtaddress);
		
		btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtstudid.setText(null);
				jtxtFname.setText(null);
				jtxtLname.setText(null);
				jtxtgender.setText(null);
				jtxtdob.setText(null);
				jtxtaddress.setText(null);
				jtxtmobno.setText(null);
				jtxtclass.setText(null);
				jtxtsection.setText(null);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(57, 652, 114, 35);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton = new JButton("Add New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=0;
				String value1 = jtxtstudid.getText();
				boolean chk1 = value1.regionMatches(2, "STU", 0, 3);
				String value2 = jtxtFname.getText();
				String value3 = jtxtLname.getText();
				String value4 = jtxtgender.getText();
				if(value4.equals("MALE")|| value4.equals("male") || value4.equals("female") || value4.equals("FEMALE")) {
					num=5;
				}
				String value5 = jtxtdob.getText();
				Date date1 =null;
				try {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(value5);
					
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
				String value8 = jtxtclass.getText();
				String value9 = jtxtsection.getText();
				try {
					if(value1.equals("") || value2.equals("") || value3.equals("") || value4.equals("") || value5.equals("") || 
							value6.equals("") || value7.equals("") || value8.equals("") || value9.equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the complete data");
					} else if(chk1==false) {
						JOptionPane.showMessageDialog(null, "Please Enter the Student ID in correct Format");
					} else if(num==2) {
						JOptionPane.showMessageDialog(null, "Eneter the date in correct Format");
					} else if(num==3) {
						JOptionPane.showMessageDialog(null, "Enter the correct mobile number");
					} else if(value7.length() > 10) {
						JOptionPane.showMessageDialog(null, "The Mobile Number should contain only 10 numbers");
					} else if(num!=5) {
						JOptionPane.showMessageDialog(null, "Enter the correct Gender");
					}
					else {
						String sql = "INSERT INTO studentData(Stu_ID,Fname,Lname,Gender,DOB,Address,Mobile_no,Class,Section)"
								+ "VALUES(?,?,?,?,?,?,?,?,?)";
						pst = studentData.ConnectDB().prepareStatement(sql);
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
						JOptionPane.showMessageDialog(null, "Student Information Added");
						
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model. addRow(new Object[] {
								jtxtstudid.getText(),
								jtxtFname.getText(),
								jtxtLname.getText(),
								jtxtgender.getText(),
								jtxtdob.getText(),
								jtxtaddress.getText(),
								jtxtmobno.getText(),
								jtxtclass.getText(),
								jtxtsection.getText()
						});
						if(table.getSelectedRow() == -1) {
							if(table.getRowCount() == 0) {
								JOptionPane.showMessageDialog(null, "Student Update Confirmed", "Student Information System",
										JOptionPane.OK_OPTION);
							}
						}
						jtxtstudid.setText("");
						jtxtFname.setText("");
						jtxtLname.setText("");
						jtxtgender.setText("");
						jtxtdob.setText("");
						jtxtaddress.setText("");
						jtxtmobno.setText("");
						jtxtclass.setText("");
						jtxtsection.setText("");
					}
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev);
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(215, 652, 129, 35);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(586, 81, 761, 506);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stud_ID", "Fname", "Lname", "Gender", "DOB", "Address", "Mob_no", "Class", "Section"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("MOBILE NUMBER");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(94, 432, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		jtxtmobno = new JTextField();
		jtxtmobno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtmobno.setColumns(10);
		jtxtmobno.setBounds(263, 432, 223, 35);
		frame.getContentPane().add(jtxtmobno);
		
		jtxtclass = new JTextField();
		jtxtclass.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtclass.setColumns(10);
		jtxtclass.setBounds(263, 490, 223, 35);
		frame.getContentPane().add(jtxtclass);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Class");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(94, 490, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Section");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_2.setBounds(94, 551, 159, 35);
		frame.getContentPane().add(lblNewLabel_2_1_2);
		
		jtxtsection = new JTextField();
		jtxtsection.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtsection.setColumns(10);
		jtxtsection.setBounds(263, 551, 223, 35);
		frame.getContentPane().add(jtxtsection);
		
		JButton btnNewButton_6 = new JButton("Update Data");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = 0;
					String value1 = jtxtstudid.getText();
					boolean chk1 = value1.regionMatches(2, "STU", 0, 3);
					String value2 = jtxtFname.getText();
					String value3 = jtxtLname.getText();
					String value4 = jtxtgender.getText();
					if(value4.equals("MALE")|| value4.equals("male") || value4.equals("female") || value4.equals("FEMALE")) {
						num=5;
					}
					String value5 = jtxtdob.getText();
					Date date1 = null;
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
					String value8 = jtxtclass.getText();
					String value9 = jtxtsection.getText();
					
					if(value1.equals("") || value2.equals("") || value3.equals("") || value4.equals("") || value5.equals("") 
							|| value6.equals("") || value7.equals("") || value8.equals("") || value9.equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter the complete Data");
					} else if(chk1==false) {
						JOptionPane.showMessageDialog(null, "Please Enter the Employee ID in correct Format");
					} else if(num==2) {
						JOptionPane.showMessageDialog(null, "Eneter the date in correct Format");
					} else if(num==3) {
						JOptionPane.showMessageDialog(null, "Enter the correct mobile number");
					} else if(value7.length() > 10) {
						JOptionPane.showMessageDialog(null, "The Mobile Number should contain only 10 numbers");
					} else if(num!=5) {
						JOptionPane.showMessageDialog(null, "Enter the correct Gender");
					}
					else {
						String sql = "UPDATE studentData SET Stu_ID="+"\""+value1 +
								"\""+" , Fname="+"\""+value2+"\""+", Lname="+"\""+value3+
								"\""+", Gender ="+"\""+value4+"\""+", DOB="+"\""+value5+"\""
								+", Address="+"\""+value6+"\""+", Mobile_no="+"\""+value7+"\""+
								", Class = "+"\""+value8+"\""+", Section="+"\""+ value9 +"\""+ 
								" WHERE Stu_ID = "+"\""+value1+"\"";
						pst = conn.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Updated Successfully");
					}
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev);
				}
				jtxtstudid.setText("");
				jtxtFname.setText("");
				jtxtLname.setText("");
				jtxtgender.setText("");
				jtxtdob.setText("");
				jtxtaddress.setText("");
				jtxtmobno.setText("");
				jtxtclass.setText("");
				jtxtsection.setText("");
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_6.setBounds(380, 652, 114, 35);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_4 = new JButton("Delete Data");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String value1 = jtxtstudid.getText();
					@SuppressWarnings("unused")
					String sql = "DELETE FROM studentData WHERE Stu_ID = "+"\""+value1+"\"";
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setBounds(527, 652, 114, 35);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Print");
		btnNewButton_5.addActionListener(new ActionListener() {
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
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_5.setBounds(678, 652, 108, 35);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_7 = new JButton("Exit");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("unused")
					Modules info = new Modules();
					Modules.main(null);
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_7.setBounds(826, 652, 108, 35);
		frame.getContentPane().add(btnNewButton_7);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
