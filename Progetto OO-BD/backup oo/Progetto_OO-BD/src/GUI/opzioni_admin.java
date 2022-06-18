package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class opzioni_admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opzioni_admin frame = new opzioni_admin();
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
	public opzioni_admin() {
		setTitle("Opzioni Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back_button = new JButton("Home Admin");
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home_admin home_admin = new home_admin();
				home_admin.setVisible(true);
				dispose();
			}
		});
		back_button.setBounds(10, 232, 115, 21);
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
		lblNewLabel_1.setBounds(10, 91, 301, 13);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("---");
		comboBox.addItem("Utenti che hanno effettuato più ascolti");
		comboBox.addItem("Fascia oraria in cui un utente ha effettuato più ascolti");
		comboBox.setBounds(10, 114, 325, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String scelta = (String)comboBox.getSelectedItem();
				if (scelta == "---")
				    JOptionPane.showMessageDialog(null, "Errore. Nessuna operazione scelta!");
				else if (scelta == "Utenti che hanno effettuato più ascolti") {
					utenti_piu_ascolti utenti_piu_ascolti = new utenti_piu_ascolti();
				    utenti_piu_ascolti.setVisible(true);
				    dispose();
				}			
				else if (scelta == "Fascia oraria in cui un utente ha effettuato più ascolti") {
					fasciaoraria_piu_ascolti fasciaoraria_piu_ascolti = new fasciaoraria_piu_ascolti();
					fasciaoraria_piu_ascolti.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(349, 114, 60, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lista Utenti");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lista_utenti lista_admin = new lista_utenti();
				lista_admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(290, 195, 115, 58);
		contentPane.add(btnNewButton_1);
	}
}
