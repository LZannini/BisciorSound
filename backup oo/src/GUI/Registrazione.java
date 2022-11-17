package GUI;
import java.awt.BorderLayout;
import Controller.*;
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
import javax.swing.ImageIcon;

public class Registrazione extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private Controller controller;
	private JTextField utenteRG_field;
	private JPasswordField passwordRG_field;
	private JPasswordField CpasswordRG_field;
	static String utente_rg= " ";
	static String password_rg= " ";
	String cpassword_rg= " ";


	/**
	 * Create the frame.
	 */
	public Registrazione(Controller c, JFrame frameChiamante) {
		frame = this;
		controller = c;
		setTitle("Registrazione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		
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
				if (utente_rg.length() == 0 || password_rg.length() == 0) {
					JOptionPane.showMessageDialog(null, "Attenzione, bisogna riempire tutti i campi!");
					return;
				}
				else if (cpassword_rg.equals(password_rg)) {
					controller.registraUtente();
					if (password_rg.length() > 5 && utente_rg.length() > 3) {
						JOptionPane.showMessageDialog(null, "L'utente '"+utente_rg+"' è stato registrato!");
						dispose();
					}
					else {
						passwordRG_field.setText("");
						CpasswordRG_field.setText("");
					}					
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
		
		JLabel img_label = new JLabel("");
		img_label.setIcon(new ImageIcon(Registrazione.class.getResource("/immagini/icona_registrazione.png")));
		img_label.setBounds(209, 0, 411, 250);
		contentPane.add(img_label);
	}
	
	public static String getNomeReg(){
		
			return utente_rg;
	}
	
	public static String getPasswordReg() {
		
		    return password_rg;
	}
}
