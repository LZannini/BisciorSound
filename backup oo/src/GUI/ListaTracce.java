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
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.Toolkit;

public class ListaTracce extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	boolean checkAdmin = false;
	private String scelta = null;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public ListaTracce(Controller c, JFrame frameChiamante) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaTracce.class.getResource("/immagini/icona bs.png")));
		frame = this;
		controller = c;
		setTitle("Lista Tracce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);

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
				} else {
					HomeUtente home_utente = new HomeUtente(controller, frameChiamante);
					home_utente.setVisible(true);
					dispose();
				}
				;
			}
		});
		back_button.setBounds(10, 232, 85, 21);
		contentPane.add(back_button);

		JList listaTracce = new JList();
		listaTracce.setBounds(190, 235, 160, 197);
		contentPane.add(listaTracce);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 315, 210);
		contentPane.add(scrollPane);

		controller.listaTracce(listaTracce);

		JButton button_cover = new JButton("Mostra Cover");
		button_cover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListaCover lista_cover = new ListaCover(controller, frameChiamante);
				lista_cover.setVisible(true);
				dispose();
			}
		});
		button_cover.setBounds(296, 232, 128, 21);
		contentPane.add(button_cover);

		JButton btnPreferiti = new JButton("<html>Aggiungi ai<br />Preferiti</html>");
		btnPreferiti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scelta = (String) listaTracce.getSelectedValue();
				if (scelta == null)
					JOptionPane.showMessageDialog(null, "Errore. Nessuna traccia scelta!");
				else {
					controller.addPreferitoTraccia(controller.trackData(scelta), controller.userData());
					JOptionPane.showMessageDialog(null, "La traccia '"+scelta+"' è stata aggiunta ai preferiti!");
				}
			}
		});
		btnPreferiti.setBounds(335, 50, 90, 49);
		contentPane.add(btnPreferiti);
		
		JButton btnAscolto = new JButton("");
		btnAscolto.setIcon(new ImageIcon(ListaTracce.class.getResource("/immagini/icona_play.png")));
		btnAscolto.setBackground(new Color(255, 204, 0));
		btnAscolto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scelta = (String) listaTracce.getSelectedValue();
				if (scelta == null)
					JOptionPane.showMessageDialog(null, "Errore. Nessuna traccia scelta!");
				else {
					if (controller.controllaAscoltoTraccia(controller.trackData(scelta), controller.userData())) 
						controller.aggiornaAscoltoTraccia(controller.trackData(scelta), controller.userData());
					else
						controller.aggiungiAscoltoTraccia(controller.trackData(scelta), controller.userData());
					
					JOptionPane.showMessageDialog(null, "La traccia '" + scelta +  "'e' stata ascoltata!");
				}
			}
		});
		btnAscolto.setBounds(357, 140, 45, 45);
		contentPane.add(btnAscolto);
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.addMouseListener(new MouseAdapter() {
		});
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 486, 261);
		contentPane.add(imgBG_label);
		
		scrollPane.setViewportView(listaTracce);
	}
}
