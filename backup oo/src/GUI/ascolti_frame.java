package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class ascolti_frame extends JFrame {

	private JPanel contentPane;
	Connection conn = null;
	boolean checkAdmin = false;
	String user = GUI.adminLogin_frame.getNomeLoginAdmin();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ascolti_frame frame = new ascolti_frame();
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
	public ascolti_frame() {
		setTitle("Ascolti");
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
				}
			}
		});
		back_button.setBounds(10, 232, 85, 21);
		contentPane.add(back_button);
		
		JList listaAscolti = new JList();
		listaAscolti.setBounds(190, 235, 160, 197);
		contentPane.add(listaAscolti);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 210);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(listaAscolti);
	}

}
