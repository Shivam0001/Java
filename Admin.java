package Project;
import java.sql.*;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;

//import com.toedter.calendar.JCalendar;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	JButton btnnext,VC,CB,UP,LG,btn1, btn2,btn3,btn4,btn5,btn6,btnNorth,btnSouth,btnEast,btnWest,btnCenter;
	Panel UpdatePanel,CalculatePanel, ViewCustomer;
	JTextField textField,textField_1,textField_2,textField_3,textField_4;
	JFrame f;
    JTable table,table1 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		new Admin();
	}

	/**
	 * Create the application.
	 */
	public Admin() {
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
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cl=new CardLayout();
		Panel sp=new Panel(cl);
		getContentPane().setLayout(new BorderLayout());

	//UPDATE COST	
		UpdatePanel=new Panel(null);
		JLabel lblUpdatePerUnit = new JLabel("Update Per Unit Cost");
		lblUpdatePerUnit.setForeground(Color.BLACK);
		lblUpdatePerUnit.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUpdatePerUnit.setBounds(137, 11, 373, 63);
		UpdatePanel.add(lblUpdatePerUnit);
		
		JLabel label = new JLabel("");
		label.setBounds(115, 106, 441, 285);
		Image img = new ImageIcon(this.getClass().getResource("/money.png")).getImage();
		label.setIcon(new ImageIcon(img));
		UpdatePanel.add(label);
		
		JLabel lblKwh = new JLabel("1 Killo-watt Hour(KwH) Cost");
		lblKwh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKwh.setBounds(109, 447, 179, 37);
		UpdatePanel.add(lblKwh);
		
		JTextField cost = new JTextField();
		cost.setBounds(343, 455, 76, 22);
		UpdatePanel.add(cost);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(222, 506, 96, 22);
		UpdatePanel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					float x=Float.parseFloat(cost.getText());
					//System.out.println(x);
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root","");
					PreparedStatement preparedStatement = myConn.prepareStatement("update costperunit set cost = ? "  );
					preparedStatement.setFloat(1,x );
					preparedStatement.executeUpdate();
				
					JOptionPane.showMessageDialog(f,"Update Registered Successfully");
					cost.setText("");
					
					myConn.close();
				}
				
				catch (Exception exc) {
					JOptionPane.showMessageDialog(f,"Please enter the rate");
					exc.printStackTrace();
				}
				
			}
		});

		
		//CALCULATE BILL
		CalculatePanel=new Panel(null);
		
		
		JLabel lblNewLabel = new JLabel("ELECTRICITY BILL CALCULATION");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 18));
		lblNewLabel.setBounds(126, 0, 322, 48);
		CalculatePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(128, 61, 96, 24);
		CalculatePanel.add(lblNewLabel_1);
		
		JLabel lblUstomerName = new JLabel("Customer Name");
		lblUstomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUstomerName.setBounds(126, 129, 108, 14);
		CalculatePanel.add(lblUstomerName);
		
		JLabel lblBillNo = new JLabel("Bill No.");
		lblBillNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBillNo.setBounds(126, 241, 51, 14);
		CalculatePanel.add(lblBillNo);
		
		textField = new JTextField();
		textField.setBounds(324, 59, 86, 24);
		CalculatePanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 127, 150, 24);
		CalculatePanel.add(textField_1);
		textField_1.setColumns(30);
		textField_1.setEditable(false);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 240, 86, 20);
		CalculatePanel.add(textField_2);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(221, 94, 89, 24);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root","");
					
					String x=textField.getText();
					//System.out.println(x);
					Statement st=myConn.createStatement();
					ResultSet rs = st.executeQuery("Select name from registeruser where cust_no = " + textField.getText());
				 	rs.next();
				 	String a=rs.getString("name");
					textField_1.setText(a);
					
					 
				}
				
				catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(f,"Enter the Customer Number");
					
				}
			}
		});
		CalculatePanel.add(btnSearch);
		
		
		
		
		
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setBounds(126, 186, 81, 14);
		CalculatePanel.add(lblMonth);
		
		JLabel lblUnitConsumed = new JLabel("Unit Consumed");
		lblUnitConsumed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnitConsumed.setBounds(126, 305, 103, 24);
		CalculatePanel.add(lblUnitConsumed);
		
		JLabel lblBillAmount = new JLabel("Bill Amount");
		lblBillAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBillAmount.setBounds(131, 388, 76, 14);
		CalculatePanel.add(lblBillAmount);
		
		Choice choice1 = new Choice();
		choice1.add("Jan");
		choice1.add("Feb");
		choice1.add("Mar");
		choice1.add("Apr");
		choice1.add("May");
		choice1.add("Jun");
		choice1.add("Jul");
		choice1.add("Aug");
		choice1.add("Sep");
		choice1.add("Oct");
		choice1.add("Nov");
		choice1.add("Dece");
		CalculatePanel.add(choice1);
		choice1.setBounds(324, 180, 86, 24);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 564, 7);
		CalculatePanel.add(separator);
		
		textField_3 = new JTextField();
		textField_3.setBounds(322, 307, 86, 24);
		CalculatePanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(324, 385, 89, 24);
		CalculatePanel.add(textField_4);
		textField_4.setEditable(false);
		textField_4.setColumns(10);


		 btnnext = new JButton("Next Bill");
		btnnext.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnnext.setBounds(305, 478, 96, 31);
		btnnext.setEnabled(false);
		CalculatePanel.add(btnnext);
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(" ");
				
				textField_1.setText(" ");
				textField_2.setText(" ");
				textField_3.setText(" ");
				textField_4.setText(" ");
				
				setVisible(false);
				new Admin();
				
			}
		});
	
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalculate.setBounds(199, 478, 96, 31);
		CalculatePanel.add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("Cust No:" + textField.getText());
				
				btnnext.setEnabled(true);
				try {
					int x;
					String query = " insert into bill (custno,billno,Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dece,units,status)"
					        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root","");
					
					PreparedStatement preparedStatement = myConn.prepareStatement(query);
					preparedStatement.setString(1, textField.getText());
					preparedStatement.setString(16,"unpaid");
				    //preparedStatement.setString(2, textField_2.getText());
				    int i=3;
				    float price;
				    
				    Statement st=myConn.createStatement();
					ResultSet rs = st.executeQuery("Select cost from costperunit ");
				 	rs.next();
				 	float rate =rs.getFloat("cost");
				    
				    int units=Integer.parseInt(textField_3.getText());
				    price = (float)(units * rate);
				  
				   // System.out.println(units + " : " + price);
				    
				    preparedStatement.setFloat(3, 0.0f);
				    
				    if(choice1.getSelectedItem()=="Jan")
				    { 
				    	textField_2.setText("1");
				    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==3)
				    			preparedStatement.setFloat(3, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Feb")
				    {
				    	textField_2.setText("2");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==4)
				    			preparedStatement.setFloat(4, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Mar")
				    { 
				    	textField_2.setText("3");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==5)
				    			preparedStatement.setFloat(5, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Apr")
				    { 
				    	textField_2.setText("4");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==6)
				    			preparedStatement.setFloat(6, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="May")
				    { 
				    	textField_2.setText("5");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==7)
				    			preparedStatement.setFloat(7, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Jun")
				    { 
				    	textField_2.setText("6");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==8)
				    			preparedStatement.setFloat(8, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Jul")
				    { 
				    	textField_2.setText("7");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==9)
				    			preparedStatement.setFloat(9, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Aug")
				    { 
				    	textField_2.setText("8");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==10)
				    			preparedStatement.setFloat(10, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Sep")
				    { 
				    	textField_2.setText("9");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==11)
				    			preparedStatement.setFloat(11, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Oct")
				    { 
				    	textField_2.setText("10");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==12)
				    			preparedStatement.setFloat(12, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else if(choice1.getSelectedItem()=="Nov")
				    { 
				    	textField_2.setText("11");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==13)
				    			preparedStatement.setFloat(13, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    else 
				    { 
				    	textField_2.setText("12");
			    	preparedStatement.setInt(2, Integer.parseInt(textField_2.getText()));
				    	for(i=3;i<=14;i++)
				    	{
				    		if(i==14)
				    			preparedStatement.setFloat(14, (price) );
				    		else
				    			preparedStatement.setFloat(i, 0.0f );
				    	}
				    }
				    
				   preparedStatement.setInt(15, units);
				   textField_4.setText(price + " ");
				   
				 	preparedStatement.executeUpdate();
					
				 	JOptionPane.showMessageDialog(f,"Bill Calculated Successfully");
				 	textField.setText(" ");
					
					textField_1.setText(" ");
					textField_2.setText(" ");
					textField_3.setText(" ");
					textField_4.setText(" ");
					btnCalculate.setEnabled(false);
				 
				}
				
				catch (Exception exc) {
					JOptionPane.showMessageDialog(f,"Please enter all the Details/ \n Bill already Created");
					btnCalculate.setEnabled(false);
					exc.printStackTrace();
					
				}
				
				
			}
		});
		
		
		//VIEW CUSTOMER
	
		ViewCustomer=new Panel(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 550, 300);
		ViewCustomer.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 310, 550, 300);
		ViewCustomer.add(scrollPane1);
		table1 = new JTable();
		scrollPane1.setViewportView(table1);
		
			
		
		try
		{
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity","root","");
			stmt=con.createStatement();
			rs=stmt.executeQuery("Select cust_no,name,mobile,email,address from registeruser order by r_id"); 					
			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs=stmt.executeQuery("Select custno,status from bill "); 					
			table1.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception error)
		{
			JOptionPane.showMessageDialog(f,"Error:"+error);
			//System.out.println("Error :"+error);
		}
		
		
		
		//BUTTONS card Layout
	
		
		//sp.add(UpdatePanel);
		sp.add(CalculatePanel);
		sp.add(UpdatePanel);
		sp.add(ViewCustomer);
		
		Panel button=new Panel();
		button.setLayout(new GridLayout(1,4));

		CB=new JButton("Calculate Bill");
		CB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.first(sp);
				//cl.next(sp);
			}
		});
		CB.setBounds(146, 0, 146, 561);
		button.add(CB);
		UP=new JButton("Update Cost");
		UP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.first(sp) ;
				cl.next(sp);
			}
		});
		UP.setBounds(292, 0, 146, 561);
		button.add(UP);


		VC=new JButton("View Customers");
		VC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.first(sp) ;
				cl.next(sp);
				cl.next(sp);
			}
		});
		VC.setBounds(0, 0, 146, 561);
		button.add(VC);

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
