package Project;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; class ViewBill extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ViewBill();
	}

	/**
	 * Create the application.
	 */
	public ViewBill() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ViewBill window = new ViewBill();
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
		
		JLabel lblCustomerNo = new JLabel("Customer No.");
		lblCustomerNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerNo.setBounds(166, 145, 107, 34);
		getContentPane().add(lblCustomerNo);
		
		JLabel lblServiceNo = new JLabel("Service No.");
		lblServiceNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServiceNo.setBounds(166, 216, 112, 34);
		getContentPane().add(lblServiceNo);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setBounds(166, 277, 112, 34);
		getContentPane().add(lblMonth);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(313, 150, 95, 29);
		getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(313, 221, 100, 29);
		getContentPane().add(textArea_1);
		
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
		choice.add("Dec");
		choice.setBounds(313, 289, 95, 34);
		getContentPane().add(choice);
		
		JButton btnViewBill = new JButton("View ");
		btnViewBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewBill.setBounds(218, 379, 119, 34);
		getContentPane().add(btnViewBill);
		
		JLabel lblViewBill = new JLabel("View Bill");
		lblViewBill.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblViewBill.setBounds(209, 23, 174, 34);
		getContentPane().add(lblViewBill);
	}

}
