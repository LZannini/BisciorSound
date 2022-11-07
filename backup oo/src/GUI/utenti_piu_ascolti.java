package GUI;

import java.awt.BorderLayout;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class utenti_piu_ascolti extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public utenti_piu_ascolti(Controller c, JFrame frameChiamante) {
		controller = c;
		setTitle("Utenti che hanno effettuato più ascolti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back_button = new JButton("Torna indietro");
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				opzioni_admin opzioni_admin = new opzioni_admin(controller, frameChiamante);
				opzioni_admin.setVisible(true);
				dispose();
			}
		});
		back_button.setBounds(10, 232, 115, 21);
		contentPane.add(back_button);
		
		JList listaUtentiPiuAscolti = new JList();
		listaUtentiPiuAscolti.setBounds(190, 235, 160, 197);
		contentPane.add(listaUtentiPiuAscolti);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 210);
		contentPane.add(scrollPane);
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(home_utente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		scrollPane.setViewportView(listaUtentiPiuAscolti);
	}
}
