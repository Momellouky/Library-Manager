package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.LivreModel;
import view.AjouterLivreView;

public class AjouterLivreController extends Controller{
     
	private AjouterLivreView view;
	private LivreModel lm; 
     
     
     
	public AjouterLivreController(AjouterLivreView view, LivreModel lm) {
		super();
		this.view = view;
		this.lm = lm;
	}



	public AjouterLivreController(AjouterLivreView view) {
		super();
		this.view = view;
	}



	@Override
	public void initController() {
		
	     this.view.getBtnCancel().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					view.dispose();
					
				}
			
			});
	     this.view.getBtnAdd().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
	                    String motCle= view.getTxtMotCl().getText();
	                    if(motCle.length()==0){
	                    	JOptionPane.showMessageDialog(view, "champ vide");	
	                    }
	                    
	                    view.getMotCl().add(view.getMotCl().size(), motCle);
				}
			});
	     
	     this.view.getBtnSave().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String isbn= view.getTxtISBN().getText().trim();
				String titre= view.getTxtTitre().getText().trim();
				Date date= view.getTxtDateEd().getDate();
				String resume= view.getTxtRes().getText().trim();
				String numInv=view.getTxtNumInv().getText().trim();
			
				if(isbn.length() == 0) {
						
						JOptionPane.showMessageDialog(null , "Champ ISBN incorrecte !", "Connexion", JOptionPane.ERROR_MESSAGE);
						return; 
					}
				
				if(titre.length() == 0) {
					
					JOptionPane.showMessageDialog(null , "Champ Titre incorrecte !", "Connexion", JOptionPane.ERROR_MESSAGE);
					return ; 
				}
					
				if(date == null) {
					
					JOptionPane.showMessageDialog(null , "Champ Date d'edition incorrecte !", "Connexion", JOptionPane.ERROR_MESSAGE);
					return ; 
				}
				
				if(resume.length() == 0) {
					
					JOptionPane.showMessageDialog(null , "Champ resume incorrecte !", "Connexion", JOptionPane.ERROR_MESSAGE);
					return ; 
				}
				
				if(view.getCheckboxExpl().isSelected()) {
					
					if(numInv.length()==0) {
						JOptionPane.showMessageDialog(null , "Champ numero d'inventaire incorrecte !", "Connexion", JOptionPane.ERROR_MESSAGE);
						return ; 
					}
					
				}
				
				try {
					
					Object [] motsCles = view.getMotCl().toArray();
					if(view.getCheckboxExpl().isSelected()) {
						lm.insertExemplaire(numInv, isbn, titre, date, resume, motsCles); 
					}else {
						
						lm.insertLivre(isbn, titre, date, resume, motsCles);
						
					}
					
					view.showMessage("Document ajouté", "Message", JOptionPane.INFORMATION_MESSAGE); 
					
				}catch(Exception ex) {
					
					ex.printStackTrace();
					view.triggerErrorMessage("Une erreur est survenue lors de l'ajout du document", "Alerte", JOptionPane.ERROR_MESSAGE); 
					
				}
    
			}
		});
	     this.view.getCheckboxExpl().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getTxtNumInv().setEnabled(true);
				
			}
		});
		
	}

}
