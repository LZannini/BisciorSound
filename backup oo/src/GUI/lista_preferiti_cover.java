package GUI;
import Model.*;
import Controller.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ImplementazioniPG_DAO.PreferitiCoverImplementazionePG_DAO;
import Model.*;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class lista_preferiti_cover extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	Connection conn = null;
	boolean checkAdmin = false;
	String user = GUI.admin_login.getNomeLoginAdmin();
	String scelta = null;
	Cover C;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public lista_preferiti_cover(Controller c, JFrame frameChiamante) throws SQLException {
		setTitle("Lista Preferiti (Cover)");
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
					checkAdmin = controller.ControlloAdmin(controller.UserData());;
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
		
		JList listaPreferiti = new JList();
		listaPreferiti.addMouseListener(new MouseAdapter() {
		
		});
		listaPreferiti.setBounds(190, 235, 160, 197);
		contentPane.add(listaPreferiti);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 315, 210);
		contentPane.add(scrollPane);	
		
		PreferitiCoverImplementazionePG_DAO preferitiCoverImplementazionePG_DAO = new PreferitiCoverImplementazionePG_DAO();
		preferitiCoverImplementazionePG_DAO.mostra_preferiti_cover(listaPreferiti, C, controller.UserData());
		
		JButton remPreferiti_bttn = new JButton("Rimuovi ");
		remPreferiti_bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scelta = (String) listaPreferiti.getSelectedValue();
				if (scelta == null)
				    JOptionPane.showMessageDialog(null, "Errore. Nessuna cover scelta!");
				else {
					DAELIMINARE.gestionePreferiti.rimuovi_preferito_cover(scelta);
					lista_preferiti_cover preferiti_frame = null;
					try {
						preferiti_frame = new lista_preferiti_cover(controller, frameChiamante);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					preferiti_frame.setVisible(true);
					dispose();
				}
			}
		});
		remPreferiti_bttn.setBounds(335, 50, 89, 49);
		contentPane.add(remPreferiti_bttn);
		
		JButton button_cover = new JButton("Mostra Tracce");
		button_cover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lista_preferiti preferiti_frame = new lista_preferiti(controller, frameChiamante);
				preferiti_frame.setVisible(true);
				dispose();
			}
		});
		button_cover.setBounds(296, 231, 128, 21);
		contentPane.add(button_cover);
		
		scrollPane.setViewportView(listaPreferiti);
	}
}