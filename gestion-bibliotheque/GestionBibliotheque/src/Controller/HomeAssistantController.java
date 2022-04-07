package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ConsulterEnsView;
import view.ConsulterEtudiantView;
import view.ConsulterLivreView;
import view.ConsulterTheseView;
import view.HomeAssistantView;

public class HomeAssistantController extends Controller {
	
	private HomeAssistantView homeAssView; 
	
	public HomeAssistantController(HomeAssistantView homeAssView) {
		
		this.homeAssView = homeAssView;
		
	}
	
	public void initController() {
		
		this.homeAssView.getMenuItemConsulterLivre().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterLivreView clv = new ConsulterLivreView(); 
				 
			}
		});
		
		this.homeAssView.getMenuItemConsulterThese().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterTheseView ctv = new ConsulterTheseView(); 
				
			}
		});
		
		this.homeAssView.getMenuItemConsulterEtudiant().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterEtudiantView ctv = new ConsulterEtudiantView(); 
				
			}
		});
		
		this.homeAssView.getMenuItemConsulterEns().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ConsulterEnsView ctv = new ConsulterEnsView(); 
				
			}
		});
		
	}
	
}
