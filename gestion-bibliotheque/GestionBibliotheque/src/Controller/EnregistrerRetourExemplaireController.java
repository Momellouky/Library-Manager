package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Util.DateChecker;
import model.Connexion;
import model.EmpruntModel;
import model.ExemplaireModel;
import view.EnregistrerRetourExemplaireView;

public class EnregistrerRetourExemplaireController extends Controller{
	
	private EnregistrerRetourExemplaireView enrRetEx; 
	private Connexion currentCnx; 
	
	public EnregistrerRetourExemplaireController(EnregistrerRetourExemplaireView enrRetEx , Connexion currentCnx) {
		
		this.currentCnx = currentCnx; 
		this.enrRetEx = enrRetEx; 
	
	}
	
	public void initController() {
		
		enrRetEx.getDtDateRetour().setDate(DateChecker.getSysDate());
		
		changeStateComboEtat(false); 
		
		enrRetEx.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				enrRetEx.dispose();
				
			}
		});
		
		enrRetEx.getCheckBoxEmprunt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(enrRetEx.getCheckBoxEmprunt().isSelected() == true ) { 
					
					changeStateComboEtat(true); 
				}else {
					
					changeStateComboEtat(false);
					
				}
				
			}
		});
		
		enrRetEx.getBtnEnregistrer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cin = enrRetEx.getTxtCin().getText().trim(); 
				
				if(cin == null || cin.length() == 0 || cin.length() > 8 ) {
					enrRetEx.triggerErrorMessage("Saisir le CIN correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				String numInv = enrRetEx.getTxtNumInv().getText().trim(); 
				
				if(numInv == null || numInv.length() == 0 || numInv.length() > 13 ) {
					enrRetEx.triggerErrorMessage("Saisir le numero d'invantaire correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				
				Date dtEmprunt = enrRetEx.getDtDateEmprunt().getDate(); 
				
				if(	dtEmprunt == null) {
					enrRetEx.triggerErrorMessage("Un problème est survenu lors de la lecture de la date d'emprunt, essaye de saisir la date d'emprunt correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				
				Date dtRetour = enrRetEx.getDtDateRetour().getDate(); 
				
				if(	dtRetour == null) {
					enrRetEx.triggerErrorMessage("Un problème est survenu lors de la lecture de la date de retour, essaye de saisir la date d'emprunt correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				if(dtEmprunt.compareTo(dtRetour) > 0 ) {
					enrRetEx.triggerErrorMessage("La date de retour ne doit pas etre inferieure à la date d'emprunt! ", "Enregistrer Retour - erreur de saisie"); 
					return;
				}
				
				try {
					
					long diffBetweenDates = DateChecker.differenceInDays(dtEmprunt, dtRetour); 
					if(diffBetweenDates > 31 ) {
						
						enrRetEx.triggerWarningMessage("La date de retour ne peut pas depasser la date d'emprunt de plus d'un mois. Vous pouver declarer la these comme perdu si la date de retour est correct. ", "Enregistrer Retour - Alerte ");
						return; 
						
					}
					
				}catch(Exception ex) {
					
					enrRetEx.triggerErrorMessage("Une erreur est survenue. Essayer en inserant une date de retour qui ne depasse pas la date d'emprunt de plus d'un mois", "Enregistrer Retour - Echec ");
					return ; 
					
				}
				
				EmpruntModel em = new EmpruntModel(currentCnx, cin, numInv, dtEmprunt, dtRetour); 
				
				try {
					
					em.enregistrerEmprunte();
					if(enrRetEx.getComboEtat().isEnabled() == true ) {
						
						String etat = enrRetEx.getComboEtat().getSelectedItem().toString().trim();
						
						ExemplaireModel exM = new ExemplaireModel(etat, numInv, currentCnx);
						
						try {
							
							exM.updateEtat(); 
							enrRetEx.showMessage("Enregistrement effectué avec succes. ", "Enregistrer Retour "); 
							
						}catch(Exception ex) {
							
							enrRetEx.triggerErrorMessage("Une erreur est survenue lors de l'enregistrement du retour. Resseyer s'il vous plait. ", "Enregistrement Retour - Erreur d'enregistrement"); 
							return ; 
							
						}
						
						
					}else {
						
						enrRetEx.showMessage("L'enregistrement est fait avec succes. ", "Enregistrer Retour ");
						
					}
					
					
				}catch(Exception ex) {
					ex.printStackTrace(); 
					enrRetEx.triggerErrorMessage("Une erreur est servenue lors de l'enregistrement de l'emprunt. Ressayer s'il vous plait. ", "Enregistrer Retour - erreur d'enregistrement des données" ); 
					return; 
				}
			
				clearTextFields();
				enrRetEx.getTxtCin().requestFocus();
				
			}
		});
		
	}
	
	
	private void changeStateComboEtat(boolean b) {
		
		enrRetEx.getComboEtat().setEnabled(b);
		
	}
	
	
	private void clearTextFields() {
		
		enrRetEx.getTxtCin().setText(null);
		enrRetEx.getTxtNumInv().setText(null);
		enrRetEx.getDtDateEmprunt().setDate(null);
		
		enrRetEx.getDtDateRetour().setDate(DateChecker.getSysDate());
		
		enrRetEx.getCheckBoxEmprunt().setSelected(false);
		
		enrRetEx.getComboEtat().setSelectedIndex(0);
		
		enrRetEx.getComboEtat().setEnabled(false);
		
	}
	
	

}
