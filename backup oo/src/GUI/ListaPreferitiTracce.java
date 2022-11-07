package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import Controller.*;
import Model.Utente;

public class ListaPreferitiTracce extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	boolean checkAdmin = false;
	private String scelta = null;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public ListaPreferitiTracce(Controller c, JFrame frameChiamante) {
		frame = this;
		controller = c;
		setTitle("Lista Preferiti Tracce");
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
		
		JList listaPreferiti = new JList();
		listaPreferiti.addMouseListener(new MouseAdapter() {
		
		});
		listaPreferiti.setBounds(190, 235, 160, 197);
		contentPane.add(listaPreferiti);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 315, 210);
		contentPane.add(scrollPane);	
		
		controller.listaPreferiti(listaPreferiti, controller.userData());
		
		JButton remPreferiti_bttn = new JButton("Rimuovi ");
		remPreferiti_bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scelta = (String) listaPreferiti.getSelectedValue();
				if (scelta == null)
				    JOptionPane.showMessageDialog(null, "Errore. Nessuna traccia scelta!");
				else {
					controller.removePreferitoTraccia(controller.trackData(scelta), controller.userData());
					JOptionPane.showMessageDialog(null, "La traccia '"+scelta+"' è stata rimossa dai preferiti!");
					ListaPreferitiTracce preferiti_frame = new ListaPreferitiTracce(controller, frameChiamante);
					preferiti_frame.setVisible(true);
					dispose();
				}
			}
		});
		remPreferiti_bttn.setBounds(335, 50, 89, 49);
		contentPane.add(remPreferiti_bttn);
		
		JButton button_cover = new JButton("Mostra Cover");
		button_cover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaPreferitiCover preferiti_cover = null;
				try {
					preferiti_cover = new ListaPreferitiCover(controller, frameChiamante);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				preferiti_cover.setVisible(true);
				dispose();
			}
		});
		button_cover.setBounds(296, 232, 128, 21);
		contentPane.add(button_cover);
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		scrollPane.setViewportView(listaPreferiti);
	}
	
}
