package GUI;

import java.awt.BorderLayout;
import Controller.*;
import Model.Utente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class HomeAdmin extends JFrame {
	
    JFrame frame;
	private JPanel contentPane;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public HomeAdmin(Controller c, JFrame frameChiamante) {
		controller = c;
		frame = this;
		setTitle("Home - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 293, 28);
		contentPane.add(menuBar);
		
		JButton button = new JButton("Tracce");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaTracce tracce_frame = new ListaTracce(controller, frameChiamante);
				tracce_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button);
		
		JButton button_1 = new JButton("Album");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaAlbum album_frame = new ListaAlbum(controller, frame);
				album_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_1);
		
		JButton button_2 = new JButton("Ascolti");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TabellaAscoltiTracce ascolti_frame = new TabellaAscoltiTracce(controller, frameChiamante);
				ascolti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_2);
		
		JButton button_3 = new JButton("Preferiti");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaPreferitiTracce preferiti_frame = new ListaPreferitiTracce(controller, frameChiamante);
				preferiti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_3);
		
		JButton btnNewButton = new JButton("Opzioni Admin");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpzioniAdmin opzioni_admin = new OpzioniAdmin(controller, frameChiamante);
				opzioni_admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(145, 196, 130, 21);
		contentPane.add(btnNewButton);
		
	    Utente U = controller.userData();
		JLabel label_user = new JLabel(U.getUsername());
		label_user.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		label_user.setBounds(40, 230, 162, 20);
		contentPane.add(label_user);
		
		JLabel img_label = new JLabel("");
		img_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int logout = JOptionPane.showConfirmDialog(null, "Vuoi effettuare il logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);
				if (logout == JOptionPane.YES_OPTION) { 
					PaginaIniziale paginaIniziale = new PaginaIniziale(c);
					paginaIniziale.setVisible(true);
					dispose();
				}				
			}
		});
		img_label.setIcon(new ImageIcon(HomeAdmin.class.getResource("/immagini/icona_utente.png")));
		img_label.setBounds(10, 208, 27, 65);
		contentPane.add(img_label);
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 496, 261);
		contentPane.add(imgBG_label);
	}
}
