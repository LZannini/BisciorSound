package GUI;

import java.awt.BorderLayout;
import Controller.*;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class home_utente extends JFrame {
	
    JFrame frame;
	private JPanel contentPane;
	private Controller controller;
	String nomeLogin = " ";

	/**
	 * Create the frame.
	 */
	public home_utente(Controller c, JFrame frameChiamante) {
		setTitle("Home");
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
				tracce_frame tracce_frame = new tracce_frame(controller, frameChiamante);
				tracce_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button);
		JButton button_1 = new JButton("Album");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				album_frame album_frame = new album_frame(controller, frame);
				album_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_1);
		JButton button_2 = new JButton("Ascolti");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ascolti_frame ascolti_frame = new ascolti_frame(controller, frameChiamante);
				ascolti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_2);
		JButton button_3 = new JButton("Preferiti");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preferiti_frame preferiti_frame = new preferiti_frame(controller, frameChiamante);
				preferiti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_3);
		
		nomeLogin = pagina_iniziale.getNomeLogin();
		JLabel label_saluto = new JLabel("Ciao, "+nomeLogin+"!");
		label_saluto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		label_saluto.setBounds(264, 241, 170, 20);
		contentPane.add(label_saluto);
	}
}
