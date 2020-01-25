package Project;
import java.awt.*;

import javax.swing.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class User extends JFrame {
	String t,s;
	Panel ViewPanel,FeedbackPanel;
	JButton VB,FB,LG;
     JFrame f;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//new User();
		
	}

	/**
	 * Create the application.
	 */
	public User(String username,String password) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Admin window = new Admin();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize(username,password);
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String username,String password) {
		
		setBounds(0, 23, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cl=new CardLayout();
		Panel sp=new Panel(cl);
		getContentPane().setLayout(new BorderLayout());

		
		ViewPanel=new Panel(null);
		
		JLabel lblViewBill = new JLabel("View Bill");
		lblViewBill.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblViewBill.setBounds(209, 23, 174, 34);
		ViewPanel.add(lblViewBill);
	

		JTextField txt1 = new JTextField();
		txt1.setBounds(313, 101, 95, 29);
		ViewPanel.add(txt1);
		
		JTextField txt2 = new JTextField();
		txt2.setBounds(313, 295, 95, 34);
		txt2.setEditable(false);
		ViewPanel.add(txt2);
		
		JTextField txt3 = new JTextField();
		txt3.setBounds(313, 225, 95, 34);
		txt3.setEditable(false);
		ViewPanel.add(txt3);
		
		
		JLabel lblCustomerNo = new JLabel("Customer No.");
		lblCustomerNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerNo.setBounds(166, 96, 107, 34);
		ViewPanel.add(lblCustomerNo);
		
		JLabel lblbillno = new JLabel("Bill No.");
		lblbillno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblbillno.setBounds(166, 230, 112, 34);
		ViewPanel.add(lblbillno);
		
		
		JLabel lblServiceNo = new JLabel("Amount ");
		lblServiceNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServiceNo.setBounds(166, 285 , 112, 34);
		ViewPanel.add(lblServiceNo);
		
		JLabel lbllMonth = new JLabel("Month");
		lbllMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbllMonth.setBounds(166, 167, 112, 34);
		ViewPanel.add(lbllMonth);
		
		
		Choice choice = new Choice();
		choice.add("Jan");
		choice.add("Feb");
		choice.add("Mar");
		choice.add("Apr");
		choice.add("May");
		choice.add("Jun");
		choice.add("Jul");
		choice.add("Aug");
		choice.add("Sep");
		choice.add("Oct");
		choice.add("Nov");
		choice.add("Dece");
		choice.setBounds(313, 172, 100, 29);
		ViewPanel.add(choice);
	 
	
		
		JButton payment = new JButton("Make Payment");
		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt1.getText().equals(""))
					JOptionPane.showMessageDialog(f,"Please Enter all the Details ");
				else
				{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root","");
					Statement st=con.createStatement();
				rs=st.executeQuery("select status from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +Integer.parseInt(txt3.getText())+ "' "  );
			    rs.next();
			    t=rs.getString("status");
				//System.out.println("Status : " + t);
				if(t.equals("unpaid"))
				{
					//System.out.println("Status Inside if : " + t);
				     try {
				    	// System.out.println("Status Inside try : " + t);
	                st.executeUpdate("update bill set status='paid' where custno= '"+Integer.parseInt(txt1.getText())+"' and billno = '" +Integer.parseInt(txt3.getText())+"'");
	                Thread.sleep(1000);
				    payment.setEnabled(false);  
	                JOptionPane.showMessageDialog(f,"Payment Successful");
			        	  } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					 JOptionPane.showMessageDialog(f,e1);
				      }
				}
				else
				{
					//System.out.println("Status Inside else : " + t);
					JOptionPane.showMessageDialog(f,"Payment Already Done");
				}
				//textField.setText("");
			
				}
				
				catch(Exception eee)
				{
					//System.out.println(eee);
					JOptionPane.showMessageDialog(f,"Calculate Bill Amount First");
					
				}
					
				}
			}
		});	
		payment.setFont(new Font("Tahoma", Font.BOLD, 16));
		payment.setBounds(300, 375, 200, 34);
		ViewPanel.add(payment);
		
		
		
		JButton btnViewBill = new JButton("View Bill");
		btnViewBill.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				if(txt1.getText().equals(""))
					JOptionPane.showMessageDialog(f,"Please enter all the Details ");
				
				else
				{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root","");
					Statement st=con.createStatement();
				
				rs=st.executeQuery("select * from registeruser where username= '"+username+"' and password ='"+password+"' ");
				rs.next();
				int num;
				num=rs.getInt("cust_no");
				
				
				if(num== Integer.parseInt(txt1.getText()))	
				{	
					//rs.next();
				    
				    
				    if(choice.getSelectedItem()=="Jan")
				    	{
				    	
				    	txt3.setText("1");
				    	
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +1+ "' "  );
					    rs.next();
					    txt2.setText((rs.getFloat("Jan")) + " ");
				    	
				    	}
				    else if(choice.getSelectedItem()=="Feb")
				    	{
				    	txt3.setText("2");
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +2+ "' "  );
					    rs.next();
					    txt2.setText((rs.getFloat("Feb")) + " ");
					   
				    	}
				    else if(choice.getSelectedItem()=="Mar")
				    	{
				    	 txt3.setText("3"); 
				    	 rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +3+ "' "  );
						    rs.next();
						    txt2.setText((rs.getFloat("Mar")) + " ");
						  
				    	}
				    else if(choice.getSelectedItem()=="Apr")
				    	{
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +4+ "' "  );
					    rs.next();
					    txt2.setText((rs.getFloat("Apr")) + " ");
				    	txt3.setText("4");
				    
				    	}
				    else  if(choice.getSelectedItem()=="May")
				       {
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +5+ "' "  );
					    rs.next();
					    txt2.setText((rs.getFloat("May")) + " ");
				       txt3.setText("5");
				      
				       }
				    else if(choice.getSelectedItem()=="Jun")
				    	{
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +6+ "' "  );
					    rs.next();
				    	txt2.setText((rs.getFloat("Jun")) + " ");
				    	txt3.setText("6");
				    	
				    	}
				    else  if(choice.getSelectedItem()=="July")
				    	{
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +7+ "' "  );
					    rs.next();
				    	txt2.setText((rs.getFloat("July")) + " ");
				    	txt3.setText("7");
				    	}
				    else if(choice.getSelectedItem()=="Aug")
				    	{
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +8+ "' "  );
					    rs.next();
				    	txt2.setText((rs.getFloat("Aug")) + " ");
				    	txt3.setText("8");
				    
				    	}
				    else if(choice.getSelectedItem()=="Sep")
				    	{txt3.setText("9");
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +9+ "' "  );
					    rs.next();
				    	txt2.setText((rs.getFloat("Sep")) + " ");
				    
				    	}
				    else if(choice.getSelectedItem()=="Oct")
				    	{txt3.setText("10");
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +10+ "' "  );
					    rs.next();
				    	txt2.setText((rs.getFloat("Oct")) + " ");
				    
				    	}
				    else if(choice.getSelectedItem()=="Nov")
				    	{txt3.setText("11");
				    	rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +11+ "' "  );
					    rs.next();
				    	txt2.setText((rs.getFloat("Nov")) + " ");
				    	
				    	}
				    else
				    {txt3.setText("12");
				    rs=st.executeQuery("select * from bill where custno= '"+ Integer.parseInt(txt1.getText()) +"' and billno= '" +12+ "' "  );
				    rs.next();
				    	txt2.setText((rs.getFloat("Dece")) + " ");
				    
				    }
				    
				    
				 
					
				    payment.setEnabled(true);
				}
				else
				{

					JOptionPane.showMessageDialog(f,"CustomerNo mismatch with User ");
					txt1.setText("");
				}
				
				
				}
				
				catch(Exception exc)
				{
					//System.out.println(exc );
					/*if(exc.equals("java.sql.SQLException: Illegal operation on empty result set."))
						JOptionPane.showMessageDialog(f,"Enter the details first");
					else 
						JOptionPane.showMessageDialog(f,"Bill not updated");
			          */
					JOptionPane.showMessageDialog(f,"Bill not updated");
					txt3.setText("");
					payment.setEnabled(false);
				}
			
				}
				}
		});
		btnViewBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewBill.setBounds(150, 375, 119, 34);
		ViewPanel.add(btnViewBill);
	
		FeedbackPanel=new Panel(null);
		JLabel lblFeedback = new JLabel("FEEDBACK");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblFeedback.setBounds(176, 37, 224, 58);
		FeedbackPanel.add(lblFeedback);
		
		JLabel lblCustomerNo1 = new JLabel("Customer No.");
		lblCustomerNo1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerNo1.setBounds(142, 170, 127, 45);
		FeedbackPanel.add(lblCustomerNo1);
		
		JLabel lblFeedback_1 = new JLabel("Feedback");
		lblFeedback_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFeedback_1.setBounds(142, 298, 127, 45);
		FeedbackPanel.add(lblFeedback_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(314, 184, 86, 20);
		FeedbackPanel.add(textField);
		
		textField.setColumns(10);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(314, 238, 199, 187);
		FeedbackPanel.add(textArea1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root","");
					Statement stmt=myConn.createStatement();
					//stmt.executeUpdate("insert into bill (feedback)" + "values("+textArea1.getText() + " ");
					//System.out.println(textArea1.getText()+" ");
					//ForChecking//
					PreparedStatement preparedStatement = myConn.prepareStatement("select * from registeruser where username = ? and password =?"  );
					preparedStatement.setString(1,username );
					preparedStatement.setString(2,password );
					rs=preparedStatement.executeQuery();
				rs.next();
				int n;
				n=rs.getInt("cust_no");
				//System.out.println("n=" + n);
				
				if(n== Integer.parseInt(textField.getText()))	
				{	
					stmt.executeUpdate("update bill set feedback ='"+textArea1.getText() +"' where custno ='"+ Integer.parseInt(textField.getText())+"' ");
					JOptionPane.showMessageDialog(f,"Feedback Successfully Submitted ");
					textField.setText("");
					textArea1.setText("");
					
				}
				else
				{

					JOptionPane.showMessageDialog(f,"CustomerNo mismatch with user ");
					textField.setText("");
					textArea1.setText("");
				}
				}	
				catch(Exception exe)
				{
					JOptionPane.showMessageDialog(f,"Please Enter Details");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(207, 485, 127, 38);
		FeedbackPanel.add(btnNewButton);
		
		
		
		
		sp.add(ViewPanel);
		sp.add(FeedbackPanel);
		
		Panel button=new Panel();
		button.setLayout(new GridLayout(1,4));

		VB=new JButton("View Bill");
		VB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.first(sp) ;
			}
		});
		VB.setBounds(292, 0, 146, 561);
		button.add(VB);
		FB=new JButton("Feedback");
		FB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.first(sp);
				cl.next(sp);
			}
		});
		FB.setBounds(146, 0, 146, 561);
		button.add(FB);


		LG=new JButton("Logout");
		LG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Electricity();
			}
		});
		LG.setBounds(438, 0, 146, 561);
		button.add(LG);
		getContentPane().add(button,BorderLayout.NORTH);
		getContentPane().add(sp,BorderLayout.CENTER);
		
		
		
	}

}
