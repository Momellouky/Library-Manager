package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Connexion;
import view.HomeAssistantView;
import view.HomeBibliothecaireView;
import view.LoginView;

public class LoginController extends Controller{

	private LoginView lv; 
	
	private String assMail, bibMail; 
	private String assMdp, bibMdp; 
	private Connexion cnxModel; 
	
	public LoginController(LoginView lv) { 
		
		this.lv = lv; 
		
//		assMail = new String("assistant.fatma.hachimi@usmba.ac.ma"); 
		assMail = new String("mail"); 
		bibMail = new String("bibliothecaire.fatma.hachimi@usmba.ac.ma"); 
//		assMdp = new String("1234abcd"); 
		assMdp = new String("pass"); 
		bibMdp = new String("4321cda"); 
		
		cnxModel = new Connexion(); 
		
	}
	
	public void initController() {
		
		this.lv.getBtnCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int rep = JOptionPane.showConfirmDialog(lv, "Vous êtes entrain de vous déconnecter de l'application. Continuer ?", "Deconnexion de l'application", JOptionPane.OK_CANCEL_OPTION); 
				
				if(rep == JOptionPane.OK_OPTION)
					System.exit(0);
				
				
			}
		});
		
		this.lv.getBtnSignIn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(lv.getTxtEmail().getText().length() == 0 ) {
					
					JOptionPane.showMessageDialog(lv, "Saisir l'e-mail correctement pour vous connecter."
							, "Les champs ne sont pas bien saisie", JOptionPane.ERROR_MESSAGE);
					
				}
				else if(lv.getTxtMdp().getText().length() == 0 ) {
					
					JOptionPane.showMessageDialog(lv, "Saisir le mot de passe correctement pour vous connecter."
							, "Les champs ne sont pas bien saisie", JOptionPane.ERROR_MESSAGE);
					
				}
				else { 
					
					if(lv.getTxtEmail().getText().equals(assMail) && 
							lv.getTxtMdp().getText().equals(assMdp)){
						
						HomeAssistantView assView = new HomeAssistantView();
						HomeAssistantController assController = new HomeAssistantController(assView, cnxModel); 
						assController.initController(); 
						
						lv.dispose(); 
						
					}
					else if(lv.getTxtEmail().getText().equals(bibMail) && 
							lv.getTxtMdp().getText().equals(bibMdp)) {
						
						HomeBibliothecaireView bibView = new HomeBibliothecaireView(); 
						HomeBibController bibController = new HomeBibController(bibView, cnxModel); 
						bibController.initController(); 
						

						
						lv.dispose(); 
												
					}
					else {
						
						JOptionPane.showMessageDialog(lv,"E-mail ou mot de passe incorrecte.", "Erreur d'authentification", JOptionPane.ERROR_MESSAGE); 
						
					}
					
					try {
						
						cnxModel.connect(); 
						JOptionPane.showMessageDialog(lv, "Vous êtes connecté", "Connexion", JOptionPane.INFORMATION_MESSAGE); 
						
					}catch(ClassNotFoundException exc) { 
						
						JOptionPane.showMessageDialog(lv, "Un erreur de connexion est surevenu. ", "Connexion", JOptionPane.ERROR_MESSAGE); 
						
						
					}catch(Exception exc) {
						
						JOptionPane.showMessageDialog(lv, "Un erreur de connexion est surevenu. ", "Connexion", JOptionPane.ERROR_MESSAGE); 
						
					}
					
				}
				
			}
		});
		
	}
	
}
