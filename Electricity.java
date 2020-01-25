package Project;

import java.awt.EventQueue;


import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;

public class Electricity extends JFrame  {

	
  
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) /*throws Exception*/ {
		
		 new Electricity();
		
	}

	/**
	 * Create the application.
	 */
	public Electricity() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Electricity window = new Electricity();
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
		
		setTitle("ELECTRICITY BILLING SYSTEM");
		//getContentPane().setPreferredSize(new Dimension(70, 50));
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton admin = new JButton("");
		admin.setFont(new Font("Jokerman", Font.BOLD, 16));
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLogin();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/admin.jpg")).getImage();
		admin.setIcon(new ImageIcon(img));
		admin.setBounds(42, 87, 218, 210);
		getContentPane().add(admin);
		
		JButton user = new JButton("");
		user.setFont(new Font("Jokerman", Font.BOLD, 16));
		user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new UserLogin();
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/user.jpg")).getImage();
		user.setIcon(new ImageIcon(img1));
		user.setBounds(307, 87, 241, 210);
		getContentPane().add(user);
		
		JButton registration = new JButton("");
		registration.setFont(new Font("Jokerman", Font.BOLD, 16));
		registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Register();
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/Registration.png")).getImage();
		registration.setIcon(new ImageIcon(img2));
		registration.setBounds(199, 333, 202, 190);
		getContentPane().add(registration);
	}
}
