package Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UpdateCost extends JFrame{

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new UpdateCost();
		
	}

	/**
	 * Create the application.
	 */
	public UpdateCost() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UpdateCost window = new UpdateCost();
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
		
		JLabel lblUpdatePerUnit = new JLabel("Update Per Unit Cost");
		lblUpdatePerUnit.setForeground(Color.BLACK);
		lblUpdatePerUnit.setBackground(SystemColor.activeCaption);
		lblUpdatePerUnit.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUpdatePerUnit.setBounds(137, 11, 373, 63);
		getContentPane().add(lblUpdatePerUnit);
		
		JLabel label = new JLabel("");
		label.setBounds(115, 106, 441, 285);
		Image img = new ImageIcon(this.getClass().getResource("/money.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		getContentPane().add(label);
		
		JLabel lblKwh = new JLabel("1 Killo-watt Hour(KwH) Cost");
		lblKwh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKwh.setBounds(109, 447, 179, 37);
		getContentPane().add(lblKwh);
		
		JTextField cost = new JTextField();
		cost.setBounds(343, 455, 76, 22);
		getContentPane().add(cost);
		
		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(222, 506, 96, 22);
		getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//String query="update costperunit set cost = " + Float.parseFloat(cost.getText()) + " where unit=1" ;
					Class.forName("com.mysql.jdbc.Driver");
					float x=Float.parseFloat(cost.getText());
					System.out.println(x);
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root","");
					PreparedStatement preparedStatement = myConn.prepareStatement("update costperunit set cost = ? "  );
					preparedStatement.setFloat(1,x );
					preparedStatement.executeUpdate();
				
					
					
					myConn.close();
				}
				
				catch (Exception exc) {
					
					exc.printStackTrace();
				}
				
			}
		});
	
	}
}
