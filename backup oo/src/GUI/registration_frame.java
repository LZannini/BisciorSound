package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registration_frame extends JFrame {

	private JPanel contentPane;
	private JTextField utenteRG_field;
	private JPasswordField passwordRG_field;
	private JPasswordField CpasswordRG_field;
	String utente_rg= " ";
	String password_rg= " ";
	String cpassword_rg= " ";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration_frame frame = new registration_frame();
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
	public registration_frame() {
		setTitle("Registrazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_rg1 = new JLabel("Username: ");
		label_rg1.setBounds(121, 33, 77, 13);
		contentPane.add(label_rg1);
		
		utenteRG_field = new JTextField();
		utenteRG_field.setBounds(145, 50, 104, 19);
		contentPane.add(utenteRG_field);
		utenteRG_field.setColumns(10);
		
		JLabel label_rg2 = new JLabel("Password: ");
		label_rg2.setBounds(121, 79, 77, 13);
		contentPane.add(label_rg2);
		
		passwordRG_field = new JPasswordField();
		passwordRG_field.setBounds(145, 97, 104, 19);
		contentPane.add(passwordRG_field);
		passwordRG_field.setColumns(10);
		
		JLabel label_rg3 = new JLabel("Conferma Password: ");
		label_rg3.setBounds(60, 126, 123, 13);
		contentPane.add(label_rg3);
		
		CpasswordRG_field = new JPasswordField();
		CpasswordRG_field.setBounds(145, 142, 104, 19);
		contentPane.add(CpasswordRG_field);
		CpasswordRG_field.setColumns(10);
		
		JButton rg_button = new JButton("Registrati");
		rg_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				utente_rg = utenteRG_field.getText();
				password_rg = passwordRG_field.getText();
				cpassword_rg = CpasswordRG_field.getText();
				if (cpassword_rg.equals(password_rg)) {
					DAELIMINARE.registration.inserisci_utente(utente_rg, password_rg);
					JOptionPane.showMessageDialog(null, "L'utente "+utente_rg+" è stato registrato!");
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore. Le password non coincidono!");
					passwordRG_field.setText("");
					CpasswordRG_field.setText("");
				}
			}
		});
		rg_button.setBounds(87, 181, 218, 21);
		contentPane.add(rg_button);
		
		JButton back_button = new JButton("Annulla");
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		back_button.setBounds(87, 211, 218, 21);
		contentPane.add(back_button);
	}
	
	public static String getNomeReg(String utente_rg){
		
			return utente_rg;
	}
	
	public static String getPasswordReg(String password_rg) {
		
		    return password_rg;
	}
		
}
