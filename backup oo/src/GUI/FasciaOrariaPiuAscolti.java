package GUI;

import java.awt.BorderLayout;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class FasciaOrariaPiuAscolti extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable tabFasciaOrariaTracce;
	private JTable tabFasciaOrariaCover;
	private JFrame frame;
	private JLabel lbl_track;
	private JLabel lbl_cover;
	private String utenteInserito = OpzioniAdmin.getUser();

	/**
	 * Create the frame.
	 */
	public FasciaOrariaPiuAscolti(Controller c, JFrame frameChiamante) {
		controller = c;
		frame = this;
		setTitle("Fascia oraria in cui un utente ha effettuato pi\u00F9 ascolti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setResizable(false);
		
		JButton back_button = new JButton("Torna indietro");
		back_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				utenteInserito = null;
				OpzioniAdmin opzioni_admin = new OpzioniAdmin(controller, frameChiamante);
				opzioni_admin.setVisible(true);
				dispose();
			}
		});
		back_button.setBounds(10, 232, 115, 21);
		contentPane.add(back_button);
		
		tabFasciaOrariaTracce = new JTable();
		tabFasciaOrariaTracce.setBounds(10, 39, 414, 14);
		contentPane.add(tabFasciaOrariaTracce);
		
		tabFasciaOrariaCover = new JTable();
		tabFasciaOrariaCover.setBounds(10, 126, 414, 14);
		contentPane.add(tabFasciaOrariaCover);	
		
		JLabel imgBG_label = new JLabel("");
		imgBG_label.setIcon(new ImageIcon(HomeUtente.class.getResource("/immagini/icona_bg.png")));
		imgBG_label.setBounds(0, 0, 496, 261);
		contentPane.add(imgBG_label);
		
		lbl_track = new JLabel("Tracce: ");
		lbl_track.setForeground(new Color(0, 0, 0));
		lbl_track.setFont(new Font("Segoe UI Black", Font.ITALIC, 10));
		lbl_track.setBounds(10, 19, 46, 14);
		contentPane.add(lbl_track);
		
		lbl_cover = new JLabel("Cover:");
		lbl_cover.setFont(new Font("Segoe UI Black", Font.ITALIC, 10));
		lbl_cover.setBounds(10, 106, 46, 14);
		contentPane.add(lbl_cover);
		
		controller.mostraFasceOrariePiuAscolti(tabFasciaOrariaTracce, tabFasciaOrariaCover, utenteInserito);
	}
}
