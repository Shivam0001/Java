package Project;

import java.awt.*;
import javax.swing.*;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JCalendar;


public class CalculateBill extends JFrame {


	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new CalculateBill();
	}

	/**
	 * Create the application.
	 */
	public CalculateBill() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//CalculateBill window = new CalculateBill();
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELECTRICITY BILL CALCULATION");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 18));
		lblNewLabel.setBounds(126, 0, 322, 48);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(128, 61, 96, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblUstomerName = new JLabel("Customer Name");
		lblUstomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUstomerName.setBounds(126, 129, 108, 14);
		getContentPane().add(lblUstomerName);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(221, 94, 89, 24);
		getContentPane().add(btnSearch);
		
		JLabel lblBillNo = new JLabel("Bill No.");
		lblBillNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBillNo.setBounds(126, 172, 81, 14);
		getContentPane().add(lblBillNo);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setBounds(129, 219, 51, 14);
		getContentPane().add(lblMonth);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExpiryDate.setBounds(126, 322, 98, 24);
		getContentPane().add(lblExpiryDate);
		
		JLabel lblUnitConsumed = new JLabel("Unit Consumed");
		lblUnitConsumed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnitConsumed.setBounds(126, 432, 103, 24);
		getContentPane().add(lblUnitConsumed);
		
		JLabel lblBillAmount = new JLabel("Bill Amount");
		lblBillAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBillAmount.setBounds(126, 476, 76, 14);
		getContentPane().add(lblBillAmount);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalculate.setBounds(207, 519, 96, 31);
		getContentPane().add(btnCalculate);
		
		textField = new JTextField();
		textField.setBounds(324, 59, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 127, 86, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(322, 169, 86, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
		getContentPane().add(choice);
		choice.setBounds(322, 213, 86, 20);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 564, 7);
		getContentPane().add(separator);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(262, 264, 186, 146);
		getContentPane().add(calendar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(324, 434, 86, 24);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(324, 473, 89, 24);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);


	}
}
