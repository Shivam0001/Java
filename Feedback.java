package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Feedback extends JFrame {
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Feedback();
	}

	/**
	 * Create the application.
	 */
	public Feedback() {
		getContentPane().setLayout(null);
		
		JLabel lblFeedback = new JLabel("FEEDBACK");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblFeedback.setBounds(176, 37, 224, 58);
		getContentPane().add(lblFeedback);
		
		JLabel lblCustomerNo = new JLabel("Customer No.");
		lblCustomerNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerNo.setBounds(142, 170, 127, 45);
		getContentPane().add(lblCustomerNo);
		
		JLabel lblFeedback_1 = new JLabel("Feedback");
		lblFeedback_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFeedback_1.setBounds(142, 298, 127, 45);
		getContentPane().add(lblFeedback_1);
		
		textField = new JTextField();
		textField.setBounds(314, 184, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(314, 238, 199, 187);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(207, 485, 127, 38);
		getContentPane().add(btnNewButton);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Feedback window = new Feedback();
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
		
	}

}
