package GUI;

import java.awt.BorderLayout;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class OpzioniAdmin extends JFrame {

	private JPanel contentPane;
	private static JTextField trackField;
	private Controller controller;
	private JFrame frame;
	private static String nomeTraccia = null;
	private static String nomeUtente = null;
	private JTextField userField;
	
	/**
	 * Create the frame.
	 */
	public OpzioniAdmin(Controller c, JFrame frameChiamante) {
		frame = this;
		controller = c;
		setTitle("Opzioni Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		
		JButton back_button = new JButton("Home");
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAdmin home_admin = new HomeAdmin(controller, frameChiamante);
				home_admin.setVisible(true);
				dispose();
			}
		});
		back_button.setBounds(10, 232, 85, 21);
		contentPane.add(back_button);
		
		JLabel lblNewLabel = new JLabel("Inserire Traccia: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(25, 60, 115, 13);
		contentPane.add(lblNewLabel);
		
		trackField = new JTextField();
		trackField.setBounds(120, 57, 161, 19);
		contentPane.add(trackField);
		trackField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Utenti che hanno effettuato piu' ascolti: ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.ITALIC, 10));
		lblNewLabel_1.setBounds(10, 34, 301, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnOKtrack = new JButton("OK");
		btnOKtrack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
					nomeTraccia = trackField.getText();
					if (controller.trackData(nomeTraccia) == null) {
						JOptionPane.showMessageDialog(null, "La traccia inserita non e' presente nella libreria musicale!");
						trackField.setText("");
						return;
					}
					UtentiPiuAscoltiTracce utenti_piu_ascolti = new UtentiPiuAscoltiTracce(controller, frameChiamante);
				    utenti_piu_ascolti.setVisible(true);
				    dispose();
			}
		});
		btnOKtrack.setBounds(288, 56, 53, 20);
		contentPane.add(btnOKtrack);
		
		JButton btnNewButton_1 = new JButton("Lista Utenti");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaUtenti lista_admin = new ListaUtenti(controller, frameChiamante);
				lista_admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(290, 195, 115, 58);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fascia oraria in cui un utente ha effettuato piu' ascolti: ");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.ITALIC, 10));
		lblNewLabel_1_1.setBounds(10, 105, 301, 13);
		contentPane.add(lblNewLabel_1_1);
				
		JLabel lblNewLabel_2 = new JLabel("Inserire Utente: ");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(25, 131, 115, 13);
		contentPane.add(lblNewLabel_2);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(120, 128, 161, 19);
		contentPane.add(userField);
		
		JButton btnOKuser = new JButton("OK");
		btnOKuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeUtente = userField.getText();
				boolean check = controller.controllaRegistrazioneUtente(nomeUtente);
				if (check == false) {
					JOptionPane.showMessageDialog(null, "L'utente '" +nomeUtente+ "' non e' registrato!");
					return;
				}
				FasciaOrariaPiuAscolti fasciaOrariaPiuAscolti = new FasciaOrariaPiuAscolti(c, frameChiamante);
				fasciaOrariaPiuAscolti.setVisible(true);
				dispose();
			}
		});
		btnOKuser.setBounds(288, 127, 53, 20);
		contentPane.add(btnOKuser);
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(OpzioniAdmin.class.getResource("/immagini/icona_admin.jpg")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
	}
	
	public static String getTrack() {
		
		return nomeTraccia;	
	}
	
	public static String getUser() {
		
		return nomeUtente;	
	}
}
