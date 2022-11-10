package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.Color;

public class UtentiPiuAscoltiCover extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable tabUtentiPiuAscoltiCover;
	private String tracciaInserita = OpzioniAdmin.getTrack(); 

	/**
	 * Create the frame.
	 */
	public UtentiPiuAscoltiCover(Controller c, JFrame frameChiamante) {
		setTitle("Utenti che hanno effettuato più ascolti (Cover)");
		controller = c;
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
				tracciaInserita = null;
				OpzioniAdmin opzioni_admin = new OpzioniAdmin(controller, frameChiamante);
				opzioni_admin.setVisible(true);
				dispose();
			}
		});
		back_button.setBounds(10, 232, 115, 21);
		contentPane.add(back_button);
		
		tabUtentiPiuAscoltiCover = new JTable();
		tabUtentiPiuAscoltiCover.setBounds(10, 37, 414, 184);
		contentPane.add(tabUtentiPiuAscoltiCover);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 210);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tabUtentiPiuAscoltiCover);
		
		controller.utentiPiuAscoltiCoverData(tabUtentiPiuAscoltiCover, controller.trackData(tracciaInserita));
	
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		JButton button_tracce = new JButton("Mostra Tracce");
		button_tracce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UtentiPiuAscoltiTracce utentiPiuAscoltiTracce = new UtentiPiuAscoltiTracce(c, frameChiamante);
				utentiPiuAscoltiTracce.setVisible(true);
				dispose();
			}
		});
		button_tracce.setBounds(296, 232, 128, 21);
		contentPane.add(button_tracce);
	}

}
