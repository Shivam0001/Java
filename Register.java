package Project;
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame {
	JFrame f=new JFrame();
	JButton signup;
	private JTextField username;
	private JTextField password;
	private JTextField customer_no;
	private JTextField name;
	private JTextField mobile;
	private JTextField email;
	private JTextField address;

	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs;
	public static void main(String[] args) {
		new Register();
	}

	public Register() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Register window = new Register();
					customer_no.setEditable(false);
					signup.setEnabled(false);
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100,600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(148, 56, 74, 29);
		getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(148, 99, 82, 29);
		getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(291, 60, 131, 20);
		getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(291, 103, 131, 20);
		getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblPersonalDetails = new JLabel("PERSONAL DETAILS");
		lblPersonalDetails.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPersonalDetails.setBounds(185, 156, 258, 29);
		getContentPane().add(lblPersonalDetails);
		
		JLabel lblCustomerNo = new JLabel("Customer No.");
		lblCustomerNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerNo.setBounds(110, 196, 98, 20);
		getContentPane().add(lblCustomerNo);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(110, 266, 66, 20);
		getContentPane().add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileNo.setBounds(110, 316, 66, 20);
		getContentPane().add(lblMobileNo);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailId.setBounds(110, 373, 56, 20);
		getContentPane().add(lblEmailId);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(110, 429, 56, 20);
		getContentPane().add(lblAddress);
		
		customer_no = new JTextField();
		customer_no.setBounds(291, 196, 172, 20);
		getContentPane().add(customer_no);
		customer_no.setEditable(false);
		customer_no.setColumns(10);
		
		name = new JTextField();
		name.setBounds(291, 268, 170, 20);
		getContentPane().add(name);
		name.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(291, 316, 172, 20);
		getContentPane().add(mobile);
		mobile.setColumns(10);
		
		email = new JTextField();
		email.setBounds(292, 379, 171, 20);
		getContentPane().add(email);
		email.setColumns(10);
		
		address = new JTextField();
		address.setBounds(291, 429, 172, 20);
		getContentPane().add(address);
		address.setColumns(10);
		
		 signup = new JButton("SIGN UP NOW");
		signup.setEnabled(false);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try
				{
					
					if(username.getText().equals("") || password.getText().equals("") ||name.getText().equals("")||mobile.getText().equals("")||email.getText().equals("")||address.getText().equals("") )
						JOptionPane.showMessageDialog(f,"Please Enter All The Details");
					else
					{
					
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity","root","");
					stmt=con.createStatement();
					stmt.executeUpdate("INSERT INTO registeruser(username,password,cust_no,name,mobile,email,address)" 
					+ "VALUES('" +username.getText() + "','" + password.getText() + "','" + Integer.parseInt(customer_no.getText()) + "','" + name.getText() + "','" + mobile.getText() + "','" + email.getText() + "','" + address.getText() + "')");
				
					JOptionPane.showMessageDialog(f,"***Registered Succesfully, LogIn Now***");
					setVisible(false);
					
					username.setText("");password.setText("");customer_no.setText("");name.setText("");mobile.setText("");
					email.setText("");address.setText("");
					new UserLogin();
					con.close();
					stmt.close();
					}
				}
				catch(Exception error)
				{
					JOptionPane.showMessageDialog(f,error);
				}
			}
		});
		signup.setFont(new Font("Arial", Font.BOLD, 14));
		signup.setBounds(208, 484, 131, 29);
		getContentPane().add(signup);
		
		
		JButton generate = new JButton("Generate CustomerNo");
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				signup.setEnabled(true);
				try
				{
					int n,num;
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity","root","");
					stmt=con.createStatement();
					rs= stmt.executeQuery("select count(*) from registeruser ");
				rs.next();
				n=rs.getInt(1);
				System.out.println(n);
					num=(n+1+100);
				    customer_no.setText(num+"");
					
					
					/*username.setText("");password.setText("");customer_no.setText("");name.setText("");mobile.setText("");
					email.setText("");address.setText("");
					new UserLogin();
					*/
				}
				catch(Exception error)
				{
					System.out.println("Error :"+error);
				}
			}
		});
		generate.setFont(new Font("Arial", Font.BOLD, 14));
		generate.setBounds(268, 227, 214, 20);
		getContentPane().add(generate);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Electricity();
			}
		});
		back.setBounds(10, 11, 66, 20);
		getContentPane().add(back);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 139, 564, 11);
		getContentPane().add(separator);
		
		
	}

}







