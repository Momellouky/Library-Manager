package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Util.DateChecker;
import model.Connexion;
import model.EmpruntModel;
import model.ExemplaireModel;
import view.EnregistrerRetourTheseView;

public class EnregistrerRetourTheseController extends Controller{

	private EnregistrerRetourTheseView enrTheseView ; 
	private Connexion currentCnx; 
	
	
	public EnregistrerRetourTheseController(EnregistrerRetourTheseView enrTheseView, Connexion currentCnx) {
		super();
		this.enrTheseView = enrTheseView;
		this.currentCnx = currentCnx;
	}


	public void initController() {
		
		enrTheseView.getDtDateRetour().setDate(DateChecker.getSysDate());
		
		enrTheseView.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				enrTheseView.dispose();
				
			}
		});
		
		enrTheseView.getBtnEnregistrer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cin = enrTheseView.getTxtCin().getText().trim(); 
				
				if(cin == null || cin.length() == 0 || cin.length() > 8 ) {
					enrTheseView.triggerErrorMessage("Saisir le CIN correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				String titre = enrTheseView.getTxtTitre().getText(); 
				
				if(titre == null || titre.length() == 0 || titre.length() > 500 ) {
					enrTheseView.triggerErrorMessage("Saisir le titre correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				
				Date dtEmprunt = enrTheseView.getDtDateEmprunt().getDate(); 
				
				if(	dtEmprunt == null) {
					enrTheseView.triggerErrorMessage("Un problème est survenu lors de la lecture de la date d'emprunt, essaye de saisir la date d'emprunt correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				
				Date dtRetour = enrTheseView.getDtDateRetour().getDate(); 
				
				if(	dtRetour == null) {
					enrTheseView.triggerErrorMessage("Un problème est survenu lors de la lecture de la date de retour, essaye de saisir la date d'emprunt correctement. ", "Enregistrer Retour - erreur de saisie"); 
					return; 
				}
				
				if(DateChecker.compareDates(dtEmprunt, dtRetour) > 0 ) {
					enrTheseView.triggerErrorMessage("La date de retour ne doit pas etre inferieure à la date d'emprunt! ", "Enregistrer Retour - erreur de saisie"); 
					return;
				}
				
				try {
					
					long diffBetweenDates = DateChecker.differenceInDays(dtEmprunt, dtRetour); 
					if(diffBetweenDates > 31 ) {
						enrTheseView.triggerWarningMessage("La date de retour ne peut pas depasser la date d'emprunt de plus d'un mois. Vous pouver declarer la these comme perdu si la date de retour est correct. ", "Enregistrer Retour - Alerte ");
						return; 
					}
					
				}catch(Exception ex) {
					
					enrTheseView.triggerErrorMessage("Une erreur est survenue. Essayer en inserant une date de retour qui ne depasse pas la date d'emprunt de plus d'un mois", "Enregistrer Retour - Echec ");
					
				}
				
				EmpruntModel em = new EmpruntModel(currentCnx, cin, titre, dtEmprunt, dtRetour); 
						
				try {
					
					em.enregistrerThese(); 
					enrTheseView.showMessage("L'enregistrement est fait avec succes. ", "Enregistrer Retour ");
					
				}catch(Exception ex) {
					
					ex.printStackTrace(); 
					enrTheseView.triggerErrorMessage("Une erreur est servenue lors de l'enregistrement de l'emprunt. Ressayer s'il vous plait. ", "Enregistrer Retour - erreur d'enregistrement des données" ); 
				}
				
				clearTextFields();
			}
		});
		
	}
	
	private void clearTextFields() {
		
		enrTheseView.getTxtCin().setText(null);
		enrTheseView.getTxtTitre().setText(null);
		enrTheseView.getDtDateEmprunt().setDate(null);
		
		enrTheseView.getDtDateRetour().setDate(DateChecker.getSysDate());

		
	}
	

}
