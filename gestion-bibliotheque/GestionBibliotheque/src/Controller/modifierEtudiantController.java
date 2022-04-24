package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import model.Connexion;
import model.EtudiantModel;
import view.ConsulterEtudiantView;
import view.modifierEtudiantView;

public class modifierEtudiantController extends Controller{
	
	private modifierEtudiantView mev; 
	private ConsulterEtudiantView cev; 
	private Connexion currentCnx;
	
	private String cin, nom, prenom, numTel, email, adresse; 
	
	public modifierEtudiantController(modifierEtudiantView mev,ConsulterEtudiantView cev, Connexion currentCnx) {
		super();
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
				
				
				cin = mev.getTxtCin().getText().trim(); 
				nom = mev.getTxtNom().getText().trim(); 
				prenom = mev.getTxtPrenom().getText().trim(); 
				numTel = mev.getTxtNumTel().getText().trim(); 
				adresse = mev.getTxtAdresse().getText().trim(); 
				email = mev.getTxtEmail().getText().trim(); 
				
				if( cin.length() == 0 || cin == null ) {
					
					mev.triggererrorMessage("Saisir CIN de l'etudiant","Modifier Etudiant - Erreur");
					return; 
					
				}
				
				if( nom.length() == 0 || nom == null ) {
					
					mev.triggererrorMessage("Saisir nom de l'etudiant","Modifier Etudiant - Erreur");
					return; 
					
				}
				
				if( prenom.length() == 0 || prenom == null ) {
					
					mev.triggererrorMessage("Saisir prenom de l'etudiant","Modifier Etudiant - Erreur");
					return; 
					
				}
				
				if( numTel.length() == 0 || numTel == null ) {
					
					mev.triggererrorMessage("Saisir le numero du telephone de l'etudiant","Modifier Etudiant - Erreur");
					return; 
					
				}
				
				if( adresse.length() == 0 || adresse == null ) {
					
					mev.triggererrorMessage("Saisir l'adresse de l'etudiant","Modifier Etudiant - Erreur");
					return; 
					
				}
				
				if( email.length() == 0 || email == null ) {
					
					mev.triggererrorMessage("Saisir l'email de l'etudiant","Modifier Etudiant - Erreur");
					return; 
					
				}
				
				EtudiantModel em = new EtudiantModel(cin, nom, prenom, numTel, email, adresse, currentCnx); 
				
				try {
					
					em.updateEtudiant(); 
					mev.showMessage("L'etudiant modifié avec succés.", "Modifier Etudiant - Message "); 
					
				}catch(Exception ex) {
					
					ex.printStackTrace(); 
					mev.triggererrorMessage("Une erreur est survenue lors de la modification de l'etudiant", "Modifier Etudiant - Erreur"); 
					
				}
				
			}
		});
	}
	
	
	public void initWindow() {
		
		int row = cev.getTblEtudiant().getSelectedRow(); 
		
		cin = cev.getTblModel().getValueAt(row, 0).toString(); 
		nom = cev.getTblModel().getValueAt(row, 1).toString(); 
		prenom = cev.getTblModel().getValueAt(row, 2).toString(); 
		adresse = cev.getTblModel().getValueAt(row, 3).toString(); 
		
		ResultSet rs = null; 
		
		
		
		try {
			
			EtudiantModel em = new EtudiantModel(currentCnx); 
			rs = em.getEtudiant(cin); 
			
			if(rs.next() == false) {
				
				cev.triggerErrorMessage("Aucun etudiant trouvée.", "Modifier Etudiant - Erreur");
				
			}else {
				
				do {
					
					email = rs.getString("email"); 
					numTel = rs.getString("numTel"); 
					
				}while(rs.next()); 
				
				mev.getTxtCin().setText(cin);
				mev.getTxtNom().setText(nom);
				mev.getTxtPrenom().setText(prenom);
				mev.getTxtEmail().setText(email);
				mev.getTxtNumTel().setText(numTel);
				mev.getTxtAdresse().setText(adresse);
				
			}
		}catch(Exception ex) {
			
			ex.printStackTrace();
			cev.triggerErrorMessage("Une erreur est survenue lors de la lecture des données.", "Modifier Etudiant - Erreur");
			
		}
		
		
	}
	
	
}
