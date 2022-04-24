package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Connexion;
import model.EmpruntModel;
import model.ExemplaireModel;
import model.TheseModel;
import view.AfficherRetardJrsView;
import view.AfficherRetardMoisView;
import view.EnregistrerRetourExemplaireView;
import view.EnregistrerRetourTheseView;
import view.HomeBibliothecaireView;
import view.VerifierExemplaireEnCoursView;

public class HomeBibController extends Controller{
	
	private HomeBibliothecaireView homeView;
	private Connexion cnxModel; 
	
	public HomeBibController(HomeBibliothecaireView homeView, Connexion cnxModel) {
		
		this.homeView = homeView; 
		this.cnxModel = cnxModel;
	
	}
	
	@Override
	public void initController() {
		
		homeView.getNewMenuItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VerifierExemplaireEnCoursView verExView = new VerifierExemplaireEnCoursView(); 
				VerifierExemplaireEnCoursController verExC = new VerifierExemplaireEnCoursController(verExView, cnxModel); 
				verExC.initController();
				
			}
		});
		
		homeView.getRetardJrs().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AfficherRetardJrsView affRetardView = new AfficherRetardJrsView();
				TheseModel tm = new TheseModel(cnxModel); 
				EmpruntModel em = new EmpruntModel(cnxModel); 
				AfficherRetardController arc = new AfficherRetardController(affRetardView, em); 
				arc.initController();
				
			}
		});
		
		homeView.getRetardMois().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AfficherRetardMoisView affRetardView = new AfficherRetardMoisView();
				TheseModel tm = new TheseModel(cnxModel); 
				EmpruntModel em = new EmpruntModel(cnxModel); 
				AfficherRetardMoisController arc = new AfficherRetardMoisController(affRetardView, em); 
				arc.initController();
				
			}
		});
		
		homeView.getMenuItemRetourExemplaire().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EnregistrerRetourExemplaireView enrRetourEx = new EnregistrerRetourExemplaireView(); 
				EnregistrerRetourExemplaireController enrRetourController = new EnregistrerRetourExemplaireController(enrRetourEx, cnxModel);
				enrRetourController.initController();
				
			}
		});
		
		homeView.getMenuItemRetourThese().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EnregistrerRetourTheseView enrRetourTh = new EnregistrerRetourTheseView(); 
				EnregistrerRetourTheseController ertController = new EnregistrerRetourTheseController(enrRetourTh, cnxModel); 
				ertController.initController();
				
			}
		});
		
	}

	
}
