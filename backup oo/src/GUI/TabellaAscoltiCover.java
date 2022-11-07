package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import Controller.*;

public class TabellaAscoltiCover extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Controller controller;
	private boolean checkAdmin = false;


	/**
	 * Create the frame.
	 */
	public TabellaAscoltiCover(Controller c, JFrame frameChiamante) {
		controller = c;
		setTitle("Ascolti Cover");
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
					HomeAdmin home_admin = new HomeAdmin(controller, frameChiamante);
					home_admin.setVisible(true);
					dispose();
				}
				else {
				    HomeUtente home_utente = new HomeUtente(controller, frameChiamante);
				    home_utente.setVisible(true);
				    dispose();
				}
			}
		});
		back_button.setBounds(10, 232, 85, 21);
		contentPane.add(back_button);
		
		table = new JTable();
		table.setBounds(10, 11, 414, 210);
		contentPane.add(table);
		
		JButton btn_tack = new JButton("Mostra Tracce");
		btn_tack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TabellaAscoltiTracce tabella_ascoltiTracce = new TabellaAscoltiTracce(c, frameChiamante);
				tabella_ascoltiTracce.setVisible(true);
				dispose();
			}
		});
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		btn_tack.setBounds(296, 232, 128, 21);
		contentPane.add(btn_tack);
	}
}
