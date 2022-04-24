package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.TheseModel;
import view.AjouterTheseView;

public class AjouterTheseController extends Controller{
	
	private AjouterTheseView ajouterThese;
	private TheseModel tm; 

	
    public AjouterTheseController(AjouterTheseView ajouterThese, TheseModel tm) {
		super();
		this.ajouterThese = ajouterThese;
		this.tm = tm; 
	}
	
	@Override
	public void initController() {
		this.ajouterThese.getBtnAnnuler().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterThese.dispose();
				
			}
			
		});
        this.ajouterThese.getBtnAjouter().addActionListener(new ActionListener() {
        
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nom = ajouterThese.getTxtNom().getText();
				String prenom = ajouterThese.getTxtPrenom().getText();
				String titre = ajouterThese.getTxtTitre().getText();
				Date date = ajouterThese.getTxtDateS().getDate(); 
				
				if(titre.length() == 0 || titre == null) {
					
					ajouterThese.triggerErrorMessage("Champ Titre incorrecte !", "Ajouter These - Erreur", JOptionPane.ERROR_MESSAGE);
					return ; 
				}
				if(nom.length() == 0 || nom == null) {
					
					ajouterThese.triggerErrorMessage( "Champ nom incorrecte !", "Ajouter These - Erreur", JOptionPane.ERROR_MESSAGE);
					return ; 
				}
				if(prenom.length() == 0 || prenom == null) {
					
					ajouterThese.triggerErrorMessage( "Champ Prenom incorrecte !", "Ajouter These - Erreur", JOptionPane.ERROR_MESSAGE);
					return ; 
				}
				if(date == null) {
					
					ajouterThese.triggerErrorMessage("Champ Date de soutenance incorrecte !", "Ajouter These - Erreur", JOptionPane.ERROR_MESSAGE);
					return ; 
				}
				
				try {
					
					tm.ajouterThese(titre, nom, prenom, date); 
					ajouterThese.showMessage("These ajoutée avec succées", "Ajouter These - Message", JOptionPane.INFORMATION_MESSAGE); 
					
					ajouterThese.getTxtTitre().setText(null); 
					ajouterThese.getTxtNom().setText(null); 
					ajouterThese.getTxtPrenom().setText(null); 
					ajouterThese.getTxtDateS().setDate(new Date()); 
					
				}catch(Exception ex) {
					
					ex.printStackTrace();
					ajouterThese.triggerErrorMessage("Une erreur est survenue lors de l'ajout du thése", "Ajouter These - Erreur", JOptionPane.ERROR_MESSAGE); 
					
				}
		
				
			}
		});
	}}


