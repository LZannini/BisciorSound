package GUI;
import java.awt.BorderLayout;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class adminLogin_frame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField adminusername_field;
	private JPasswordField adminpassword_field;
	public static String nomeLoginAdmin = " ";
	public static String passwordLoginAdmin = " ";
    Connection conn = null;
	boolean checkLogin = false;

	/**
	 * Create the frame.
	 */
	public adminLogin_frame(Controller c, JFrame frameChiamante) {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		adminusername_field = new JTextField();
		adminusername_field.setBounds(126, 73, 96, 19);
		contentPane.add(adminusername_field);
		adminusername_field.setColumns(10);
		
		adminpassword_field = new JPasswordField();
		adminpassword_field.setBounds(126, 133, 96, 19);
		contentPane.add(adminpassword_field);
		adminpassword_field.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(96, 51, 73, 13);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(96, 110, 73, 13);
		contentPane.add(lblPassword);
		
		JButton adminLogin_button = new JButton("Login as Admin");
		adminLogin_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeLoginAdmin = adminusername_field.getText();
				passwordLoginAdmin = adminpassword_field.getText();
				
				try {
					checkLogin = DAELIMINARE.checkLoginAdmin.checkCredentialsAdmin(conn, nomeLoginAdmin, passwordLoginAdmin);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (checkLogin == false) {
					JOptionPane.showMessageDialog(null, "Errore. Credenziali sbagliate!");
					adminusername_field.setText("");
					adminpassword_field.setText("");
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Admin Login effettuato con successo!");
					home_admin home_admin = new home_admin(controller, frameChiamante);
					home_admin.setVisible(true);
					dispose();
				}
			}
		});
		adminLogin_button.setBounds(96, 176, 191, 21);
		contentPane.add(adminLogin_button);
		
		JButton back_button = new JButton("Annulla");
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pagina_iniziale pagina_iniziale = new pagina_iniziale(controller);
				pagina_iniziale.start_frame.setVisible(true);
				dispose();
				
			}
		});
		back_button.setBounds(96, 207, 191, 21);
		contentPane.add(back_button);
	}

	public static String getNomeLoginAdmin() {
		
		return nomeLoginAdmin;
	}
	
	public static String getPasswordLoginAdmin() {
		
		return passwordLoginAdmin;
	}
}
