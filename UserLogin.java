package Project;
import java.sql.*; 
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame  {
	JFrame f=new JFrame();
	JButton lgn,back;
	JLabel login,username,password,error;
	JTextField user;
	JPasswordField pass;
	private JLabel lblNewLabel;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;


	public static void main(String[] args) {
		new UserLogin();

	}

	public UserLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Login window = new Login();
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
		
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		 back = new JButton("Back");
		 back.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Electricity();
		 	}
		 });
		back.setBounds(10, 11, 68, 23);
		getContentPane().add(back);
		
		 login = new JLabel("LOGIN");
		login.setFont(new Font("Tahoma", Font.BOLD, 18));
		login.setBounds(374, 190, 89, 41);
		getContentPane().add(login);
		
		 username = new JLabel("USERNAME");
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBounds(275, 285, 89, 33);
		getContentPane().add(username);
		
		 password = new JLabel("PASSWORD");
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(275, 367, 89, 23);
		getContentPane().add(password);
		
		
		
		 lgn = new JButton("LOGIN");
		 lgn.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try
		 		{
		 			int c = 0;
		 			Class.forName("com.mysql.jdbc.Driver");
		 			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root", "");
		 			stmt=con.createStatement();
		 			rs=stmt.executeQuery("Select username,password from registeruser order by r_id");
		 			while(rs.next())
		 			{
		 				String username=rs.getString("username");
		 				String password=rs.getString("password");
		 				//error.setText("print:"+password);
		 				if((user.getText().equalsIgnoreCase(username))&&(pass.getText().equalsIgnoreCase(password)))
		 				{
		 					setVisible(false);
							new User(username,password);
							 c=1;
							break;
		 				}
		 				
		 				
		 			}
		 			if(c!=1)
	 				{
						error.setText("Re-Enter Username and Password ");
						JOptionPane.showMessageDialog(f,"Wrong Username/Password");
						
						//JOptionPane.showMessageDialog(this,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);  
					}
	 				
					
		 		}
		 		catch(Exception error)
		 		{
		 			System.out.println("Error:"+error);
		 		}
//				if(user.getText().equalsIgnoreCase("shivam") && pass.getText().equalsIgnoreCase("jaswal") )
//				{
//					
//				}
				
		 	}
		 });
		lgn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lgn.setBounds(359, 456, 104, 33);
		getContentPane().add(lgn);
		
		 error = new JLabel("");
		error.setBounds(150, 460, 346, 23);
		getContentPane().add(error);
		
		user = new JTextField();
		user.setBounds(374, 277, 200, 41);
		getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(374, 360, 200, 41);
		getContentPane().add(pass);
		
		lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(7, 58, 247, 246);
		getContentPane().add(lblNewLabel);

	}

}
