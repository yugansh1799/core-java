package ishank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUp1 extends JFrame {

	private static final boolean False = false;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JPasswordField t3;
	private JPasswordField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp1 frame = new SignUp1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 597);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel u1 = new JLabel("Username");
		u1.setHorizontalAlignment(SwingConstants.CENTER);
		u1.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		u1.setBounds(35, 149, 91, 16);
		contentPane.add(u1);
		
		JLabel p1 = new JLabel("Password");
		p1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		p1.setBounds(54, 252, 81, 16);
		contentPane.add(p1);
		
		
		JLabel lblSignup = new JLabel("SignUp");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSignup.setBounds(224, 54, 118, 35);
		contentPane.add(lblSignup);
		
		JLabel e1 = new JLabel("Email Address");
		e1.setHorizontalAlignment(SwingConstants.CENTER);
		e1.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		e1.setBounds(35, 200, 118, 16);
		contentPane.add(e1);
		
		JLabel cp1 = new JLabel("Confirm Password");
		cp1.setHorizontalAlignment(SwingConstants.CENTER);
		cp1.setFont(new Font("Lucida Bright", Font.PLAIN, 13));
		cp1.setBounds(35, 306, 124, 16);
		contentPane.add(cp1);
		
		
		
		t1 = new JTextField();
		t1.setBounds(247, 146, 116, 22);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(247, 197, 116, 22);
		contentPane.add(t2);
		
		JButton b1 = new JButton("Submit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo","root","root");
					String s= "insert into details(Username,EmailAddress,Password,ConfirmPassowrd) values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
					Statement st= con.createStatement();
					int x=st.executeUpdate(s);
					if(x==0)
					{
						JOptionPane.showMessageDialog(null,"This is not valid ");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Data inserted Successfully");
					}
				
				
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		b1.setBounds(224, 451, 97, 25);
		contentPane.add(b1);
		
		t3 = new JPasswordField();
		t3.setBounds(247, 249, 116, 22);
		contentPane.add(t3);
		
		t4 = new JPasswordField();
		t4.setBounds(247, 303, 116, 22);
		contentPane.add(t4);
	}
}
