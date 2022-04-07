package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.AfficherRetardView;
import view.HomeBibliothecaireView;
import view.VerifierExemplaireEnCoursView;

public class HomeBibController extends Controller{
	
	private HomeBibliothecaireView homeView;
	
	public HomeBibController(HomeBibliothecaireView homeView) {
		
		this.homeView = homeView; 
	
	}
	
	@Override
	public void initController() {
		
		homeView.getNewEmpruntMenuItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VerifierExemplaireEnCoursView verExView = new VerifierExemplaireEnCoursView(); 
				VerifierExemplaireEnCoursController verExC = new VerifierExemplaireEnCoursController(verExView); 
				verExC.initController();
				
			}
		});
		
		homeView.getAfficherRetardMenuItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AfficherRetardView affRetardView = new AfficherRetardView(); 
				AfficherRetardController verExC = new AfficherRetardController(affRetardView); 
				verExC.initController();
				
			}
		});
		
		
	}

	
}
