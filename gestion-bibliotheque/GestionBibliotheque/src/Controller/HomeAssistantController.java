package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Connexion;
import view.ConsulterEnsView;
import view.ConsulterEtudiantView;
import view.ConsulterLivreView;
import view.ConsulterTheseView;
import view.HomeAssistantView;

public class HomeAssistantController extends Controller {
	
	private HomeAssistantView homeAssView; 
	private Connexion cnxModel; 
	
	public HomeAssistantController(HomeAssistantView homeAssView, Connexion cnxModel) {
		
		this.homeAssView = homeAssView;
		this.cnxModel = cnxModel; 
		
	}
	
	public void initController() {
		
		this.homeAssView.getMenuItemConsulterLivre().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterLivreView clv = new ConsulterLivreView(); 
				ConsulterLivreController clvController = new ConsulterLivreController(clv, cnxModel); 
				clvController.initController();
				
			}
		});
		
		this.homeAssView.getMenuItemConsulterThese().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterTheseView ctv = new ConsulterTheseView(); 
				ConsulterTheseController ctController = new ConsulterTheseController(ctv, cnxModel); 
				ctController.initController(); 
				
			}
		});
		
		this.homeAssView.getMenuItemConsulterEtudiant().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterEtudiantView ctv = new ConsulterEtudiantView(); 
				ConsulterEtudiantController ceC = new ConsulterEtudiantController(ctv, cnxModel); 
				ceC.initController(); 
				
			}
		});
		
		this.homeAssView.getMenuItemConsulterEns().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterEnsView ctv = new ConsulterEnsView(); 
				ConsulterEnsController ceC = new ConsulterEnsController(ctv, cnxModel); 
				ceC.initController();
				
			}
		});
		
		this.homeAssView.getMenuItemUpdateDocs().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(homeAssView, "La base des donn�es des usages est � jours maintenant", "Mise � Jours De La Base De Donn�es.", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
	}
	
}
