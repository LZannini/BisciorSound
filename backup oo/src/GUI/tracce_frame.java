package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class tracce_frame extends JFrame {

	private JPanel contentPane;
	Connection conn = null;
	boolean checkAdmin = false;
	String user = GUI.adminLogin_frame.getNomeLoginAdmin();
	String scelta = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tracce_frame frame = new tracce_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tracce_frame() {
		setTitle("Lista Tracce");
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
					checkAdmin = ImplementazioniPG_DAO.controllaUtente.checkUserAdmin(conn, user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (checkAdmin == true) {
					home_admin home_admin = new home_admin();
					home_admin.setVisible(true);
					dispose();
				}
				else {
				    home_utente home_utente = new home_utente();
				    home_utente.setVisible(true);
				    dispose();
				};
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
		
		
		
		ImplementazioniPG_DAO.listaTracce.mostra_tracce(listaTracce);
		
		JButton button_cover = new JButton("Mostra Cover");
		button_cover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cover_frame lista_cover = new cover_frame();
				lista_cover.setVisible(true);
				dispose();
			}
		});
		button_cover.setBounds(296, 231, 128, 21);
		contentPane.add(button_cover);
		
		JButton btnPreferiti = new JButton("<html>Aggiungi ai<br />Preferiti</html>");
		btnPreferiti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scelta = (String) listaTracce.getSelectedValue();
				if (scelta == null)
				    JOptionPane.showMessageDialog(null, "Errore. Nessuna traccia scelta!");
				else
                    ImplementazioniPG_DAO.gestionePreferiti.aggiungi_preferito(scelta);				
 			}
		});
		btnPreferiti.setBounds(335, 50, 89, 49);
		contentPane.add(btnPreferiti);
		
		scrollPane.setViewportView(listaTracce);
	}
}
