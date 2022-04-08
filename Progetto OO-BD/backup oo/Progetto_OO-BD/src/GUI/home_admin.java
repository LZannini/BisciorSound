package GUI;

import java.awt.BorderLayout;
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

public class home_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_admin frame = new home_admin();
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
	public home_admin() {
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
				tracce_frame tracce_frame = new tracce_frame();
				tracce_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button);
		
		JButton button_1 = new JButton("Album");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				album_frame album_frame = new album_frame();
				album_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_1);
		
		JButton button_2 = new JButton("Ascolti");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ascolti_frame ascolti_frame = new ascolti_frame();
				ascolti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_2);
		
		JButton button_3 = new JButton("Preferiti");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				preferiti_frame preferiti_frame = new preferiti_frame();
				preferiti_frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(button_3);
		
		JButton btnNewButton = new JButton("Opzioni Admin");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				opzioni_admin opzioni_admin = new opzioni_admin();
				opzioni_admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(145, 232, 130, 21);
		contentPane.add(btnNewButton);
	}
}
