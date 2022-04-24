package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Connexion;
import model.EnseignantModel;
import model.TheseModel;
import view.ConsulterEnsView;
import view.modifierEnseignantView;

public class ConsulterEnsController extends Controller{
	
	private ConsulterEnsView consEnsView; 
	private Connexion currentCnx;
	
	public ConsulterEnsController(ConsulterEnsView consEnsView, Connexion currentCnx) {
		super();
		this.consEnsView = consEnsView;
		this.currentCnx = currentCnx;
	} 
	
	public void initController() {
		
		getEns(); 
		
		consEnsView.getBtnSuprimer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = consEnsView.getTblEns().getSelectedRow(); 
				
				if(selectedIndex < 0 ) {
					
					consEnsView.triggerErrorMessage("Selectionner un etudiant à supprimer", "Alerte"); 
					return ; 
					
				}
				Object ensCin = consEnsView.getTblModel().getValueAt(selectedIndex, 0);
				
				int rep = consEnsView.ConfermToDelete("Vous etes sur de supprimer l'enseignant : " + ensCin + " ? " , "Attention! "); 
				
				if(rep == JOptionPane.YES_OPTION) {
					
					try {
						
						EnseignantModel tm = new EnseignantModel(ensCin.toString(), currentCnx); 
						
						try {
							
							tm.deleteEns(ensCin.toString());
							
							consEnsView.showMessage("Enseignant suprimmée. ", "Supression Enseignant "); 
							
							getEns(); 
							
						}catch(Exception ex) {
							ex.printStackTrace(); 
							
							consEnsView.triggerErrorMessage("Une erreur est survenue lors de la execution de votre demande. ", "Supression Enseignant - Erreur ");
						}
						
					}catch(Exception ex) { 
						
						ex.printStackTrace();
						
					}
					
					
			}
		}});
		
		consEnsView.getBtnModifier().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = consEnsView.getTblEns().getSelectedRow(); 
				
				if(row < 0) {
					
					consEnsView.triggerErrorMessage("Selectionner un enseignant.", "Modifier Enseignant - Alerte");
					
				}else {
					
					modifierEnseignantView mev = new modifierEnseignantView(); 
					modifierEnseignantController mec = new modifierEnseignantController(mev, consEnsView, currentCnx); 
					mec.initController();
					
				}
				
			}
		});
		
		
	}
	
	private void getEns() {
		
		consEnsView.getTblModel().setRowCount(0);
		
		try {
			
			EnseignantModel em = new EnseignantModel(currentCnx); 
			ResultSet rs = em.getEns(); 
			Object [] data = new Object[4]; 
			int row = 0; 
			
			if(rs.next() == false) {
				consEnsView.showMessage("Aucun enseignant trouvé", "Consulter enseignant - information");
			}else {
				do {
					
					data[0] = rs.getString(1); 
					data[1] = rs.getString(2); 
					data[2] = rs.getString(3);
					data[3] = rs.getString(4);
					
					consEnsView.getTblModel().insertRow(row, data);
					row++; 
					
				}while(rs.next()); 
			}
			
		}catch(Exception e) {
			
			consEnsView.triggerErrorMessage("Une erreur est survenu lors de chargement des données", "Consulter Enseignant - Erreur"); 
			e.printStackTrace(); 
			
		}
		
	}
	
}
