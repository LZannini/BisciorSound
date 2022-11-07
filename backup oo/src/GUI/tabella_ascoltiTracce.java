package GUI;
import Model.*;
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
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class tabella_ascoltiTracce extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	boolean checkAdmin = false;
	private JFrame frame;
	private JTable tabella;
	private JButton btn_cover;

	/**
	 * Create the frame.
	 */
	public tabella_ascoltiTracce(Controller c, JFrame frameChiamante) {
		frame = this;
		controller = c;
		setTitle("Ascolti Tracce");
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
				try {
					checkAdmin = controller.controllaLoginAdmin(controller.userData());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (checkAdmin == true) {
					home_admin home_admin = new home_admin(controller, frameChiamante);
					home_admin.setVisible(true);
					dispose();
				}
				else {
				    home_utente home_utente = new home_utente(controller, frameChiamante);
				    home_utente.setVisible(true);
				    dispose();
				}
			}
		});
		back_button.setBounds(10, 232, 85, 21);
		contentPane.add(back_button);
		
		tabella = new JTable();
		tabella.setBounds(10, 11, 414, 210);
		contentPane.add(tabella);
		
		Utente U = controller.userData();
		controller.mostra_ascoltiTracce(tabella, U);
		
		btn_cover = new JButton("Mostra Cover");
		btn_cover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabella_ascoltiCover tabella_ascoltiCover = new tabella_ascoltiCover(c, frameChiamante);
				tabella_ascoltiCover.setVisible(true);
				dispose();
			}
		});
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(home_utente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		btn_cover.setBounds(296, 232, 128, 21);
		contentPane.add(btn_cover);

	}

}
