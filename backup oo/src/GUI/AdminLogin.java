package GUI;
import java.awt.BorderLayout;
import Controller.*;
import Model.Utente;

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
import javax.swing.ImageIcon;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private Controller controller;
	private JTextField adminusername_field;
	private JPasswordField adminpassword_field;
	public static String nomeLoginAdmin = " ";
	public static String passwordLoginAdmin = " ";
	boolean checkLogin = false;

	/**
	 * Create the frame.
	 */
	public AdminLogin(Controller c, JFrame frameChiamante) {
		frame = this;
		controller = c;
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		PaginaIniziale.setNomeLogin(null);
		
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
				Utente U = controller.userData();
				
				if (nomeLoginAdmin.length() == 0 || passwordLoginAdmin.length() == 0) {
					JOptionPane.showMessageDialog(null, "Attenzione, bisogna riempire tutti i campi!");
					return;
				}
				
				if (U == null) {
					JOptionPane.showMessageDialog(null, "Errore. Credenziali sbagliate!");
					adminusername_field.setText("");
					adminpassword_field.setText("");
					return;
				}
				
				try {
					checkLogin = controller.controllaLoginAdmin(U);
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
					HomeAdmin home_admin = new HomeAdmin(controller, frameChiamante);
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
				PaginaIniziale pagina_iniziale = new PaginaIniziale(controller);
				pagina_iniziale.start_frame.setVisible(true);
				dispose();
				
			}
		});
		back_button.setBounds(96, 207, 191, 21);
		contentPane.add(back_button);
		
		JLabel img_label = new JLabel("New label");
		img_label.setIcon(new ImageIcon(AdminLogin.class.getResource("/immagini/icona_admin.jpg")));
		img_label.setBounds(0, 0, 445, 261);
		contentPane.add(img_label);
	}

	public static String getNomeLoginAdmin() {
		
		return nomeLoginAdmin;
	}
	
	public static String getPasswordLoginAdmin() {
		
		return passwordLoginAdmin;
	}
}
