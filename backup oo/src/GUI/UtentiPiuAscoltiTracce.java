package GUI;

import java.awt.BorderLayout;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class UtentiPiuAscoltiTracce extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JFrame frame;
	private JTable tabUtentiPiuAscoltiTraccia;
	private String tracciaInserita = OpzioniAdmin.getTrack(); 

	/**
	 * Create the frame.
	 */
	public UtentiPiuAscoltiTracce(Controller c, JFrame frameChiamante) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UtentiPiuAscoltiTracce.class.getResource("/immagini/icona bs.png")));
		frame = this;
		controller = c;
		setTitle("Utenti che hanno effettuato più ascolti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		
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
		
		tabUtentiPiuAscoltiTraccia = new JTable();
		tabUtentiPiuAscoltiTraccia.setBounds(10, 37, 414, 184);
		contentPane.add(tabUtentiPiuAscoltiTraccia);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 210);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tabUtentiPiuAscoltiTraccia);
		
		controller.utentiPiuAscoltiTracciaData(tabUtentiPiuAscoltiTraccia, controller.trackData(tracciaInserita));
	
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		JButton button_cover = new JButton("Mostra Cover");
		button_cover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (controller.controllaEsistenzaCover(tracciaInserita)) {
					UtentiPiuAscoltiCover utentiPiuAscoltiCover = new UtentiPiuAscoltiCover(c, frameChiamante);
					utentiPiuAscoltiCover.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Attenzione. Non e' presente una cover di ''" + tracciaInserita + "'' nella libreria musicale!");
			}
		});
		button_cover.setBounds(296, 232, 128, 21);
		contentPane.add(button_cover);	
	}
}
