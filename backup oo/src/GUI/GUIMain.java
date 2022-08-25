package GUI;

import Controller.Controller;
import java.awt.*;
import javax.swing.*;

public class GUIMain {

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

}
