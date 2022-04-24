package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Connexion;
import model.EmpruntModel;
import view.EnregistrerEmpruntView;
import view.VerifierDispoExemplaireView;
import view.VerifierExemplaireEnCoursView;

public class VerifierDispoExemplaireController extends Controller{
	
	private VerifierDispoExemplaireView verDispoView; 
	private VerifierExemplaireEnCoursView verExView; 
	private Connexion currentCnx; 
	private String numInvantaire; 
	
	public VerifierDispoExemplaireController(VerifierDispoExemplaireView verDispoView, VerifierExemplaireEnCoursView verExView ,Connexion currConnexion) {
		
		this.verDispoView = verDispoView; 
		this.verExView = verExView; 
		this.currentCnx = currConnexion; 
		
	}
	
	@Override
	public void initController() {
		
		this.verDispoView.getBtnEmprunter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				EnregistrerEmpruntView enrEmpView = new EnregistrerEmpruntView(); 
				EnregistrerEmpruntController eec = new EnregistrerEmpruntController(enrEmpView, verDispoView, verExView, currentCnx, numInvantaire); 
				eec.initController(); 
				
				
				
			}
		});
		
		this.verDispoView.getBtnSearch().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String titre = verDispoView.getTxtTitre().getText().trim(); 
				String table = new String(); 
				EmpruntModel em = new EmpruntModel(currentCnx); 
				ResultSet rs = null; 
				
				verDispoView.getLblSecondText().setText(null);
				verDispoView.getLblThirdText().setText(null);
				
				if(verDispoView.getBtnEmprunter().isEnabled() == true ) {
					verDispoView.getBtnEmprunter().setEnabled(false); 
				}
				
				
				if(verDispoView.getRadioExemplaire().isSelected() == true) {
					
					table = "exemplaire"; 
					
					verDispoView.getLblId().setText(new String("ISBN:"));
					verDispoView.getLblSecond().setText(new String("Titre:")); 
					verDispoView.getLblThird().setText(new String("Auteur:")); 
					
					if(titre.length() == 0) {
						
						JOptionPane.showMessageDialog(verDispoView, "Saisir le ISBN de l'exemplaire", "Alerte", JOptionPane.WARNING_MESSAGE); 		 
					
					}else {
						
						try { 
							
							rs = em.getCurrentExemplaire(titre.trim()); 
							
							if(rs.next() == false ) {
								verDispoView.triggerWarningMessage("Aucun exemplaire disponible", "Enregistrer emprunte - Alerte"); 
							}else {
								
								do {
									if(rs.getString(1) == null || rs.getString(2) == null || rs.getString(3) == null || 
											rs.getString(4) == null) {
										verDispoView.triggerErrorMessage("Une erreur est surevnue lors du chargement des données. Saisir l'identifiant du document correctement. ", "Enregistrer Emprunt - erreur");
									}else {
										
										verDispoView.getLblSecondText().setText(rs.getString("titre")); 
										verDispoView.getLblThirdText().setText(rs.getString("nom") + " " + rs.getString("prenom")); 
										verDispoView.getLblNombreExemplaireDisponible().setText(rs.getString("nbrDispo")); 
										numInvantaire = rs.getString("numinvantaire"); 
										if(Integer.parseInt(rs.getString("nbrDispo")) >= 1 )
											verDispoView.getBtnEmprunter().setEnabled(true); 
										
									}
									
								}while(rs.next()) ; 
							}
								
							
							
						}catch(SQLException ex){
							
							ex.printStackTrace();
							verDispoView.triggerSQLError("Une erreur est surevenue lors de la recuperation des données." , "Enregistrer Emprunt - erreur"); 
							emptyFields();
							
						}catch(Exception ex) {
							
							verDispoView.triggerSQLError("Une erreur est surevenue lors de la recuperation des données." , "Enregistrer Emprunt - erreur"); 
							emptyFields(); 
						}
						
					}
					
				}else if(verDispoView.getRadioThese().isSelected() == true ) {
					
					table = "these";
					
					verDispoView.getLblId().setText(new String("Titre:"));
					verDispoView.getLblSecond().setText(new String("Auteur: ")); 
					verDispoView.getLblThird().setText(null); 
					
					if(titre.length() == 0) {
						
						JOptionPane.showMessageDialog(verDispoView, "Saisir le titre de la thèse", "Alerte", JOptionPane.WARNING_MESSAGE);
					
					}else {
						System.out.println(titre);
						rs = em.getCurrentThese(titre.trim()); 
						
						try {
							while(rs.next()) {
								
								verDispoView.getLblSecondText().setText(rs.getString("nom") + " " + rs.getString("prenom")); 
								verDispoView.getLblNombreExemplaireDisponible().setText(rs.getString("nbrDispo"));
								if(Integer.parseInt(rs.getString("nbrDispo")) >= 1 ) {
									
									verDispoView.getBtnEmprunter().setEnabled(true); 
									
								}
								
							}
							
						}catch(SQLException ex) {
							ex.printStackTrace(); 
						}
						
					}
				}
				

				

				
				
				
			}
		});
		
		this.verDispoView.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				verDispoView.dispose();
				
			}
		});
		
		this.verDispoView.getRadioThese().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				emptyFields(); 
				changeTextLabels("Titre", "Auteur", null);
				
			}
		});
		
		this.verDispoView.getRadioExemplaire().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				emptyFields(); 
				changeTextLabels("ISBN:", "Titre:", "Auteur:");
				
			}
		});
		
	}
	
	private void changeTextLabels(String first, String second, String third) {
		
		verDispoView.getLblId().setText(first);
		verDispoView.getLblSecond().setText(second); 
		verDispoView.getLblThird().setText(third);
		
	}
	
	private void emptyFields() {
		verDispoView.getTxtTitre().setText(null);
		verDispoView.getLblSecondText().setText(null);
		verDispoView.getLblThirdText().setText(null);
		verDispoView.getLblNombreExemplaireDisponible().setText(null);
		verDispoView.getTxtTitre().requestFocus();
	}
	
	public String getNumIvantaire() {
		return numInvantaire; 
	}
	
}
