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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class home_admin extends JFrame {
	
    JFrame frame;
	private JPanel contentPane;
	private Controller controller;
    Utente U;

	/**
	 * Create the frame.
	 */
	public home_admin(Controller c, JFrame frameChiamante) {
		controller = c;
		setTitle("Home - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 293, 28);
		contentPane.add(menuBar);
		
		JButton button = new JButton("Tracce");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lista_tracce tracce_frame = new lista_tracce(controller, frameChiamante);
				tracce_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button);
		
		JButton button_1 = new JButton("Album");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lista_album album_frame = new lista_album(controller, frame);
				album_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_1);
		
		JButton button_2 = new JButton("Ascolti");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabella_ascoltiTracce ascolti_frame = new tabella_ascoltiTracce(controller, frameChiamante);
				ascolti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_2);
		
		JButton button_3 = new JButton("Preferiti");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lista_preferiti preferiti_frame = new lista_preferiti(controller, frameChiamante);
				preferiti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_3);
		
		JButton btnNewButton = new JButton("Opzioni Admin");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				opzioni_admin opzioni_admin = new opzioni_admin(controller, frameChiamante);
				opzioni_admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(145, 196, 130, 21);
		contentPane.add(btnNewButton);
		
	    U = controller.userData();
		JLabel label_user = new JLabel(U.getUsername());
		label_user.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		label_user.setBounds(40, 230, 162, 20);
		contentPane.add(label_user);
		
		JLabel img_label = new JLabel("");
		img_label.setIcon(new ImageIcon(home_admin.class.getResource("/immagini/icona_utente.png")));
		img_label.setBounds(10, 193, 85, 94);
		contentPane.add(img_label);
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(home_utente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 496, 261);
		contentPane.add(imgBG_label);
	}
}
