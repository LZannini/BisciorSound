package GUI;

import java.awt.BorderLayout;
import Controller.*;
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

public class home_admin extends JFrame {
	
    JFrame frame;
	private JPanel contentPane;
	private Controller controller;
    String nomeLoginAdmin = " ";

	/**
	 * Create the frame.
	 */
	public home_admin(Controller c, JFrame frameChiamante) {
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
				lista_ascolti ascolti_frame = new lista_ascolti(controller, frameChiamante);
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
		
	    nomeLoginAdmin = admin_login.getNomeLoginAdmin();
		JLabel label_saluto = new JLabel("Ciao, "+nomeLoginAdmin+"!");
		label_saluto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		label_saluto.setBounds(282, 241, 170, 20);
		contentPane.add(label_saluto);
	}
}
