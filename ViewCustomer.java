package Project;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class ViewCustomer extends JFrame {
		JFrame f;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		private JTable table,table1;
		
	public static void main(String[] args) {
		new ViewCustomer();
		
	}

	public ViewCustomer() {
		getContentPane().setLayout(null);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ViewCustomer window = new ViewCustomer();
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 0, 550, 300);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);	
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(43, 300, 550, 300);
		getContentPane().add(scrollPane1);
		table1 = new JTable();
		scrollPane1.setViewportView(table1);	
		try
		{
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
	}
}

