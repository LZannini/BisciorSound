package GUI;

import Controller.Controller;
import java.awt.*;
import javax.swing.*;
public class GUIMain {
	
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c= new Controller();
					pagina_iniziale start_frame = new pagina_iniziale(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUIMain(Controller c) {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
