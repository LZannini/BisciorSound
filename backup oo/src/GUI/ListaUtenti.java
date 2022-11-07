package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConfigurazioneDB.ConnessioneDB;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;

import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import Controller.*;

public class ListaUtenti extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public ListaUtenti(Controller c, JFrame frameChiamante) {
		frame = this;
		controller = c;
		setTitle("Lista Utenti");
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
				OpzioniAdmin opzioni_admin = new OpzioniAdmin(controller, frameChiamante);
				opzioni_admin.setVisible(true);
				dispose();
			}
		});
		back_button.setBounds(10, 232, 115, 21);
		contentPane.add(back_button);
		
		JList listaUtenti = new JList();
		listaUtenti.setBounds(190, 235, 160, 197);
		contentPane.add(listaUtenti);

		JLabel label_utenti = new JLabel("Utenti: ");
		label_utenti.setForeground(Color.BLACK);
		label_utenti.setBounds(10, 10, 45, 13);
		contentPane.add(label_utenti);
		
		JLabel label_admin = new JLabel("Admin: ");
		label_admin.setBounds(266, 10, 45, 13);
		contentPane.add(label_admin);
		
		JList listaAdmin = new JList();
		listaAdmin.setBounds(266, 25, 160, 197);
		contentPane.add(listaAdmin);
		
		JButton bottone_admin = new JButton("<html>Mostra<br /> Admin</html>");
		bottone_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.listaAdmin(listaAdmin);
			}
		});
		bottone_admin.setBounds(180, 187, 76, 35);
		contentPane.add(bottone_admin);
		
		JButton bottone_utenti = new JButton("<html>Mostra<br /> Utenti</html>");
		bottone_utenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.listaUtenti(listaUtenti);
		}
		});
		bottone_utenti.setBounds(180, 25, 76, 35);
		contentPane.add(bottone_utenti);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 160, 197);
		contentPane.add(scrollPane);
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		scrollPane.setViewportView(listaUtenti);
	}
}
