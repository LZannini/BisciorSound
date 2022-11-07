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
	private JTextField textField;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public OpzioniAdmin(Controller c, JFrame frameChiamante) {
		controller = c;
		setTitle("Opzioni Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblNewLabel.setBounds(61, 36, 115, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 34, 161, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Scegliere l'operazione da effettuare: ");
		lblNewLabel_1.setBounds(10, 84, 301, 13);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("---");
		comboBox.addItem("Utenti che hanno effettuato piu' ascolti");
		comboBox.addItem("Fascia oraria in cui un utente ha effettuato piu' ascolti");
		comboBox.setBounds(10, 107, 325, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String scelta = (String)comboBox.getSelectedItem();
				if (scelta == "---")
				    JOptionPane.showMessageDialog(null, "Errore. Nessuna operazione scelta!");
				else if (scelta == "Utenti che hanno effettuato piu' ascolti") {
					UtentiPiuAscolti utenti_piu_ascolti = new UtentiPiuAscolti(controller, frameChiamante);
				    utenti_piu_ascolti.setVisible(true);
				    dispose();
				}			
				else if (scelta == "Fascia oraria in cui un utente ha effettuato piu' ascolti") {
					FasciaOrariaPiuAscolti fasciaoraria_piu_ascolti = new FasciaOrariaPiuAscolti(controller, frameChiamante);
					fasciaoraria_piu_ascolti.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(349, 107, 60, 21);
		contentPane.add(btnNewButton);
		
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
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
	}
}
