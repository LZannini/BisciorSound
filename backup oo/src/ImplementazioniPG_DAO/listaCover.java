package ImplementazioniPG_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class listaCover {
	
    public static JList mostra_cover(JList lista) {
		
		String query = "select nome from cover order by nome";
		DefaultListModel model = new DefaultListModel();  

	    Statement st = null;
	    ResultSet rs = null;
	    Connection conn = null;
		
		
		try {
			conn = ConfigurazioneDB.ConnessioneDB.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    try {
			while (rs.next())
			{
			    String itemCodeNome = null;
				try {
					itemCodeNome = rs.getString("nome");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			    model.addElement(itemCodeNome);  
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    lista.setModel(model);

	    try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			st.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return lista;
	}

}
