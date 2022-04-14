package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Connexion;
import model.EnseignantModel;
import model.LivreModel;
import view.ConsulterLivreView;
import view.HomeAssistantView;

public class ConsulterLivreController extends Controller{
	
	private ConsulterLivreView consulterLivreView; 
	private Connexion currentCnx; 
	
	
	
	public ConsulterLivreController(ConsulterLivreView consulterLivreView, Connexion currentCnx) {
		super();
		this.consulterLivreView = consulterLivreView;
		this.currentCnx = currentCnx;
	}



	public void initController() {
		
		getLivre();
		
		consulterLivreView.getBtnSuprimer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = consulterLivreView.getTblLivre().getSelectedRow(); 
				Object livreIsbn = consulterLivreView.getTblModelLivre().getValueAt(selectedIndex, 0);
				
				int rep = consulterLivreView.ConfermToDelete("Vous etes sur de supprimer le livre: " + livreIsbn + " ? " , "Attention! "); 
				
				if(rep == JOptionPane.YES_OPTION) {
					
					try {
						
						LivreModel tm = new LivreModel(livreIsbn.toString(), currentCnx); 
						
						try {
							
							tm.deleteLivre(livreIsbn.toString());
							
							consulterLivreView.showMessage("Livre Suprimmé. ", "Supression Livre "); 
							
							getLivre(); 
							
						}catch(Exception ex) {
							ex.printStackTrace(); 
							
							consulterLivreView.triggerErrorMessage("Une erreur est survenue lors de la execution de votre demande. ", "Supression Livre - Erreur ");
						}
						
					}catch(Exception ex) { 
						consulterLivreView.triggerErrorMessage("Une erreur est survenue lors de la execution de votre demande. ", "Supression Livre - Erreur ");
						ex.printStackTrace();
						
					}
					
					
			}
		}});
		
	}
	
	public void getLivre() {
		
		consulterLivreView.getTblModelLivre().setRowCount(0);
		
		try {
			
			ResultSet rs = currentCnx.requete("livre"); 
			Object [] data = new Object[3]; 
			int row = 0; 
			
			if(rs.next() == false) {
				consulterLivreView.showMessage("Aucun livre trouvé", "Consulter Livre - information");
			}else {
				do {
					
					data[0] = rs.getString(1); 
					data[1] = rs.getString(2); 
					data[2] = rs.getString(3);
					
					consulterLivreView.getTblModelLivre().insertRow(row, data);
					row++; 
					
				}while(rs.next()); 
			}
			
		}catch(Exception e) {
			
			consulterLivreView.triggerErrorMessage("Une erreur est survenu lors de chargement des données", "Consulter Livres - Erreur"); 
			
		}
		
	}
	
}
