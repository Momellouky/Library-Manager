package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Connexion;
import model.LivreModel;
import model.TheseModel;
import view.AjouterLivreView;
import view.AjouterTheseView;
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
				
				JOptionPane.showMessageDialog(homeAssView, "La base de données des usagers est à jour", "Mise à Jours De La Base De Données.", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		this.homeAssView.getMenuItemThese().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AjouterTheseView atv = new AjouterTheseView(); 
				TheseModel atm = new TheseModel(cnxModel); 
				AjouterTheseController atc = new AjouterTheseController(atv, atm); 
				atc.initController();
				
			}
		});
		
		this.homeAssView.getMenuItemLivre().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AjouterLivreView alv = new AjouterLivreView();
				LivreModel lm = new LivreModel(cnxModel); 
				AjouterLivreController atm = new AjouterLivreController(alv, lm); 
				atm.initController();
				
			}
		});
		
		this.homeAssView.getMenuItemUpdateUsers().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(homeAssView, "La base de données des usagers est à jour", "Mise à Jours De La Base De Données.", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
	}
	
}
