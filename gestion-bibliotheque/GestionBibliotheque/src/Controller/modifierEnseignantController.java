package controller;

import view.ConsulterEnsView;
import view.modifierEnseignantView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Connexion;
import model.EnseignantModel;

public class modifierEnseignantController extends Controller{
	
	private modifierEnseignantView mev ; 
	private ConsulterEnsView cev; 
	private Connexion currentCnx; 
	
	public modifierEnseignantController(modifierEnseignantView mev,ConsulterEnsView cev,  Connexion currentCnx) {
		
		this.mev = mev; 
		this.cev = cev; 
		this.currentCnx = currentCnx; 
		
	}
	
	public void initController() {
		
		initWindow(); 
		
		mev.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mev.dispose();
				
			}
		});
		
		mev.getBtnModifier().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cin = mev.getTxtCin().getText().trim(); 
				String nom = mev.getTxtNom().getText().trim(); 
				String prenom = mev.getTxtPrenom().getText().trim(); 
				String grade = mev.getComboGrade().getSelectedItem().toString().trim(); 
				String email = mev.getTxtEmail().getText().trim(); 
				String numTel = mev.getTxtNumTel().getText().trim(); 
				
				if( cin.length() == 0 || cin == null ) {
					mev.triggerErrorMessage("Saisir le cin de l'enseignant.", "Modifier Enseignant - Erreur"); 
					return; 
				}
				
				if( nom.length() == 0 || nom == null ) {
					mev.triggerErrorMessage("Saisir le nom de l'enseignant.", "Modifier Enseignant - Erreur"); 
					return; 
				}
				if( prenom.length() == 0 || prenom == null ) {
					mev.triggerErrorMessage("Saisir le prenom de l'enseignant.", "Modifier Enseignant - Erreur"); 
					return; 
				}
				if( email.length() == 0 || email == null ) {
					mev.triggerErrorMessage("Saisir l'email de l'enseignant.", "Modifier Enseignant - Erreur"); 
					return; 
				}
				if( numTel.length() == 0 || numTel == null ) {
					mev.triggerErrorMessage("Saisir le numero du telephone de l'enseignant.", "Modifier Enseignant - Erreur"); 
					return; 
				}
				
				EnseignantModel em = new EnseignantModel(cin, nom, prenom, grade, email, numTel,  currentCnx); 
				
				try {
					
					em.UpdateModel();
					mev.showMessage("Modification effectuée par succées.","Modification Enseignant - Message");  
					
				}catch(Exception ex) {
					
					ex.printStackTrace(); 
					mev.triggerErrorMessage("Une erreur est survenue lors de la modification de l'enseignant.", "Modifier Enseignant - Erreur"); 
					
				}
				
				
			}
		});
	}
	
	public void initWindow() {
		
		int row  = cev.getTblEns().getSelectedRow(); 
		
		String cin = cev.getTblModel().getValueAt(row, 0).toString();
		String nom = cev.getTblModel().getValueAt(row, 1).toString(); 
		String prenom = cev.getTblModel().getValueAt(row, 2).toString(); 
		String grade = cev.getTblModel().getValueAt(row, 3).toString();
		
		EnseignantModel em = new EnseignantModel(currentCnx); 
		
		ResultSet rs = null; 
		
		try {
			
			rs = em.getEns(cin); 
			
			if(rs.next() == false) {
				cev.triggerErrorMessage("Aucune données trouvées.", "Modifier Enseignant - Alerte");
			}else {
				
				String email = new String(); 
				String numTel = new String(); 
				
				do {
					
					email = rs.getString("email"); 
					numTel = rs.getString("numTel"); 
					
				}while(rs.next()); 
				
				mev.getTxtCin().setText(cin);
				mev.getTxtNom().setText(nom);
				mev.getTxtPrenom().setText(prenom);
				
				mev.getComboGrade().setSelectedItem(grade);
				
				mev.getTxtEmail().setText(email);
				mev.getTxtNumTel().setText(numTel);
			}
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			cev.triggerErrorMessage("Une erreur est survenue lors de la lecture des données. ", "Modifier Enseignant - Erreur");
			
		}
		
	}
}
