package GUI;

import Model.*;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

import DAELIMINARE.checkLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.*;

public class pagina_iniziale extends JFrame {

	JFrame start_frame;
	private Controller controller;
	private JTextField username_textField;
	private JPasswordField password_textField;
	public static String nomeLogin = " ";
	public static String passwordLogin = " ";
	String check_username = " ";
	Connection conn = null;
	boolean tryLogin = false;
	ImageIcon img_benvenuto;

	/**
	 * Create the application.
	 */
	public pagina_iniziale(Controller c) {
		controller = c;
		initialize();
		start_frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		start_frame = new JFrame("");
		start_frame.getContentPane().setBackground(new Color(255, 204, 0));
		start_frame.setBounds(100, 100, 450, 300);
		start_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start_frame.getContentPane().setLayout(null);

		username_textField = new JTextField();
		username_textField.setBounds(98, 99, 96, 19);
		start_frame.getContentPane().add(username_textField);
		username_textField.setColumns(10);

		password_textField = new JPasswordField();
		password_textField.setBounds(98, 160, 96, 19);
		start_frame.getContentPane().add(password_textField);
		password_textField.setColumns(10);

		JLabel username_label = new JLabel("Username: ");
		username_label.setBounds(63, 76, 72, 13);
		start_frame.getContentPane().add(username_label);

		JLabel password_label = new JLabel("Password: ");
		password_label.setBounds(63, 138, 72, 13);
		start_frame.getContentPane().add(password_label);

		JButton login_button = new JButton("Login");
		login_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeLogin = username_textField.getText();
				passwordLogin = password_textField.getText();

				try {
					tryLogin = DAELIMINARE.checkLogin.checkCredentials(conn, nomeLogin, passwordLogin);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (tryLogin == false) {
					JOptionPane.showMessageDialog(null, "Errore Credenziali sbagliate!");
					username_textField.setText("");
					password_textField.setText("");
				}

				else {
					JOptionPane.showMessageDialog(null, "Login effettuato con successo!");
					home_utente home = new home_utente(controller, start_frame);
					home.setVisible(true);
					start_frame.dispose();
				}
			}
		});

		login_button.setBounds(98, 205, 209, 21);
		start_frame.getContentPane().add(login_button);

		JLabel noAccount_label = new JLabel("Non hai un account?");
		noAccount_label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		noAccount_label.setBounds(191, 189, 90, 13);
		start_frame.getContentPane().add(noAccount_label);

		JLabel registrati_label = new JLabel("Registrati");
		registrati_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrazione registration_frame = new registrazione(controller, start_frame);
				registration_frame.setVisible(true);
			}
		});
		registrati_label.setForeground(Color.BLUE);
		registrati_label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		registrati_label.setBounds(270, 189, 51, 13);
		start_frame.getContentPane().add(registrati_label);

		JLabel adminAccess_label = new JLabel("Accedi come amministratore");
		adminAccess_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				admin_login adminLogin_frame = new admin_login(controller, start_frame);
				adminLogin_frame.setVisible(true);
				start_frame.dispose();
			}
		});
		adminAccess_label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		adminAccess_label.setForeground(Color.BLUE);
		adminAccess_label.setBounds(199, 225, 122, 13);
		start_frame.getContentPane().add(adminAccess_label);

		JLabel img_label = new JLabel("");
		img_label.setBounds(46, 0, 428, 73);
		img_label.setIcon(new ImageIcon(pagina_iniziale.class.getResource("/immagini/img_benvenuto.png")));
		start_frame.getContentPane().add(img_label);

		JLabel img2_label = new JLabel("");
		img2_label.setIcon(new ImageIcon(pagina_iniziale.class.getResource("/immagini/icona_cuffie.png")));
		img2_label.setBounds(331, 20, 367, 261);
		start_frame.getContentPane().add(img2_label);
	}

	public static String getNomeLogin() {
		return nomeLogin;
	}

	public static String getPasswordLogin() {
		return passwordLogin;
	}
}
