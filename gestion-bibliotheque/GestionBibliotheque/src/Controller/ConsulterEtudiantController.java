package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Connexion;
import model.EnseignantModel;
import model.EtudiantModel;
import model.LivreModel;
import view.ConsulterEtudiantView;
import view.modifierEtudiantView;

public class ConsulterEtudiantController extends Controller{
	
	private ConsulterEtudiantView consEtudiantView; 
	private Connexion currentCnx; 
	
	public ConsulterEtudiantController(ConsulterEtudiantView consEtudiantView, Connexion currentCnx) {
		super();
		this.consEtudiantView = consEtudiantView;
		this.currentCnx = currentCnx;
	}

	public void initController() {
		
	getEtudiant();
		
		consEtudiantView.getBtnSuprimer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedIndex = consEtudiantView.getTblEtudiant().getSelectedRow(); 
				
				if(selectedIndex < 0 ) {
					
					consEtudiantView.triggerErrorMessage("Selectionner un etudiant à supprimer", "Alerte"); 
					return ; 
					
				}
				Object cinEtud = consEtudiantView.getTblModel().getValueAt(selectedIndex, 0);
				
				int rep = consEtudiantView.ConfermToDelete("Vous etes sur de supprimer l'etudiant: " + cinEtud + " ? " , "Attention! "); 
				
				if(rep == JOptionPane.YES_OPTION) {
					
					try {
						
						EtudiantModel tm = new EtudiantModel(cinEtud.toString(), currentCnx); 
						
						try {
							
							tm.deleteEtudiant(cinEtud.toString());
							
							consEtudiantView.showMessage("Etudiant Suprimmé. ", "Supression Etudiant "); 
							
							getEtudiant(); 
							
						}catch(Exception ex) {
							ex.printStackTrace(); 
							
							consEtudiantView.triggerErrorMessage("Une erreur est survenue lors de la execution de votre demande. ", "Supression Etudiant - Erreur ");
						}
						
					}catch(Exception ex) { 
						consEtudiantView.triggerErrorMessage("Une erreur est survenue lors de la execution de votre demande. ", "Supression Etudiant - Erreur ");
						ex.printStackTrace();
						
					}
					
					
			}
		}});
		
		consEtudiantView.getBtnModifier().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = consEtudiantView.getTblEtudiant().getSelectedRow(); 
				
				if(row < 0 ) {
					
					consEtudiantView.triggerErrorMessage("Selectionner un etudiant", "Modifier Etudiant - Erreur"); 
					
				}else {
					
					modifierEtudiantView mev = new modifierEtudiantView(); 
					modifierEtudiantController mec = new modifierEtudiantController(mev, consEtudiantView, currentCnx); 
					mec.initController(); 
					
					
				}
				
				
			}
		});
		
	}
	
	public void getEtudiant() {
		
		consEtudiantView.getTblModel().setRowCount(0);
		
		try {
			
			
			EtudiantModel em = new EtudiantModel(currentCnx); 
			ResultSet rs = em.getEtudiant(); 
			Object [] data = new Object[4]; 
			int row = 0; 
			
			if(rs.next() == false) {
				consEtudiantView.showMessage("Aucun enseignant trouvé", "Consulter enseignant - information");
			}else {
				do {
					
					data[0] = rs.getString(1); 
					data[1] = rs.getString(2); 
					data[2] = rs.getString(3);
					data[3] = rs.getString(4);
					
					consEtudiantView.getTblModel().insertRow(row, data);
					row++; 
					
				}while(rs.next()); 
			}
			
		}catch(Exception e) {
			
			consEtudiantView.triggerErrorMessage("Une erreur est survenu lors de chargement des données", "Consulter Etudiant - Erreur"); 
			
		}
		
	}
	
	
}
